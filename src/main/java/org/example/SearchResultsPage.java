package org.example;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class SearchResultsPage extends GenericLotPage{
    public SearchResultsPage(PageParameters pageParameters) {
        add(new Label("header_text_label", "Search results"));
        add(new Label("header_components", pageParameters.get("searchQuery")));
        add(new SearchResultsPageLotListPanel("content", pageParameters.get("searchQuery").toString()));
        add(new Label("footer", "footer"));
    }
}
