package org.example;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public class FormPanel extends Panel {
    public FormPanel(String id) {
        super(id);

        add(new LotForm("lot_form"));

    }

    public FormPanel(String id, Lot lot) {
        super(id);

        add(new LotForm("lot_form", lot));
    }
}
