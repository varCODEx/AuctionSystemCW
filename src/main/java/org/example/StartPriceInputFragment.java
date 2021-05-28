package org.example;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Fragment;

public class StartPriceInputFragment extends Fragment {
    public StartPriceInputFragment(String id, String markupId, MarkupContainer markupProvider) {
        super(id, markupId, markupProvider);
        TextField tf = new TextField<>("startPrice");
        add(tf);
//        markupProvider.add(tf);
    }
}
