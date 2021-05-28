package org.example;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;

public class GenericLotPage extends WebPage {

    public GenericLotPage() {
        super();
        setVersioned(false);
        WebMarkupContainer markupContainer = new WebMarkupContainer("additional_header_component");
        add(markupContainer);
        markupContainer.setVisible(false);
    }
}
