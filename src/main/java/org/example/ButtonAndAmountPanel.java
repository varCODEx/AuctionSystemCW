package org.example;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

public class ButtonAndAmountPanel extends Panel {
    public ButtonAndAmountPanel(String id) {
        super(id);
        //FIXME
        Form amountForm = new Form("amount_form"){
            @Override
            protected void onSubmit() {
                ((ViewLotPage)getParent().getParent()).onSubmit((int) get("amount").getDefaultModelObject());
            }
        };
        amountForm.add(new TextField<>("amount", Model.of(10)));
        amountForm.add(new FeedbackPanel("feedbackPanel"));
        add(amountForm);

        AbstractLink button = new SubmitLink("button", amountForm);
        button.add(new Label("button_text", Model.of("Place your bid")));
        add(button);
    }

}
