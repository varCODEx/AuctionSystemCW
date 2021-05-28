package org.example;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;

public class DataPanel extends Panel {
    public DataPanel(String id, Lot pageCurrentLot) {
        super(id);

        setDefaultModel(new CompoundPropertyModel<>(Model.of(pageCurrentLot)));

        add(new Label("name"));
        add(new Label("description"));
        add(new Label("startPrice"));
        add(new Label("owner"));
        add(new Label("lastBid.price"));
        add(new Label("lotStatus"));

    }

}
