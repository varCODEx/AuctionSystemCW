package org.example;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class ManageLotPage extends GenericLotPage {
    public ManageLotPage(final PageParameters parameters) {
        super(parameters);
        add(new Label("header_text_label", "Manage your lot"));
        add(new Button("header_component_1"));
        add(new Button("header_component_2"));
        add(new DataPanel("content" ));
        add(new Label("footer", "footer"));

//        add(new Form<Void>("lot_form"));
    }
}
