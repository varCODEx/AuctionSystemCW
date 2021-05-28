package org.example;

import org.apache.wicket.Session;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RefreshingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.wicketstuff.lambda.components.ComponentFactory;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HomePage extends WebPage {
    public HomePage(PageParameters parameters) {
        super(parameters);
        setStatelessHint(true);
        setVersioned(false);
        DAOLot dao = new DAOLot();
        Session.get().bind();

        add(new HomePageLotListPanel("lot_list"));



        if(Session.get().getAttribute("currentUser") == null)
            Session.get().setAttribute("currentUser", new User(Session.get().getId()));

        add(new Label("welcome_username_label", Model.of("welcome, mr. " + ((User)Session.get().getAttribute("currentUser")).getId())));
        add(ComponentFactory.link("new_lot_link", (link) -> setResponsePage(NewLotPage.class)));

        PageParameters searchParameters = new PageParameters();
        //FIXME
        searchParameters.add("searchQuery", "SMTH");
        add(ComponentFactory.link("search_link", (link) -> setResponsePage(new SearchResultsPage(searchParameters))));
    }
}
