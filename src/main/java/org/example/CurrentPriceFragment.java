package org.example;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Fragment;

public class CurrentPriceFragment extends Fragment {
    public CurrentPriceFragment(String id, String markupId, MarkupContainer markupProvider) {
        super(id, markupId, markupProvider);
        add(new Label("currentPrice", "CurrPr"));
    }
}
