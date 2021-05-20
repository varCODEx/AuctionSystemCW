package org.example;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public class FormPanel extends Panel {
    public FormPanel(String id) {
        super(id);
    }

    public FormPanel(String id, IModel<?> model) {
        super(id, model);
    }
}
