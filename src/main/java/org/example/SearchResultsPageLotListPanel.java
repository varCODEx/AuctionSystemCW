package org.example;

import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RefreshingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.wicketstuff.lambda.components.ComponentFactory;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchResultsPageLotListPanel extends lotListPanel {
    public SearchResultsPageLotListPanel(String id, String searchQuery) {
        super(id);
        add(new RefreshingView<Lot>("lots") {
            @Override
            protected Iterator<IModel<Lot>> getItemModels() {
                DAOLot dao = new DAOLot();
                Stream<Lot> lotStream = dao.getStream();
                List<IModel<Lot>> lotModels = lotStream
                        .filter(lot -> lot.getLotStatus() != Lot.status.DELETED)
                        .filter(lot -> lot.getName().contains(searchQuery))
                        .map(Model::of)
                        .collect(Collectors.toList());

                return lotModels.iterator();
            }

            @Override
            protected void populateItem(Item<Lot> item) {
                item.add(ComponentFactory.link("lot_item", (link) -> LotLinkRedirector.redirect(this, item.getModelObject())));
            }
        });
    }
}
