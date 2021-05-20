package org.example;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public class DataPanel extends Panel {
    public DataPanel(String id) {
        super(id);
    }

    public DataPanel(String id, IModel<?> model) {
        super(id, model);
    }
}
