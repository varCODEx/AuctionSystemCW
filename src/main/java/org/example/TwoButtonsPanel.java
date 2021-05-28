package org.example;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;

public class TwoButtonsPanel extends Panel {
    public void replace(TwoButtons twoButtons){
        replace(twoButtons.button1);
        replace(twoButtons.button2);
        twoButtons.button1.replace(new Label("button1text", new PropertyModel(twoButtons, "button1text")));
        twoButtons.button2.replace(new Label("button2text", new PropertyModel(twoButtons, "button2text")));
    }

    public TwoButtonsPanel(String id, TwoButtons twoButtons) {
        super(id);

        add(twoButtons.button1);
        add(twoButtons.button2);
        twoButtons.button1.add(new Label("button1text", new PropertyModel(twoButtons, "button1text")));
        twoButtons.button2.add(new Label("button2text", new PropertyModel(twoButtons, "button2text")));

    }
}
