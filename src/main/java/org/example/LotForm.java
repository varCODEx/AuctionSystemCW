package org.example;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;

public class LotForm extends org.apache.wicket.markup.html.form.Form {

    //TODO remove this
    @Override
    protected void onError() {
        System.out.println("ERR");
    }

    @Override
    protected void onSubmit() {
        System.out.println("SUBMIT");
        System.out.println(pageCurrentLot);
        System.out.println(LotStorage.storage);
    }

    public void togglePriceLabels() {
        TextField<String> startPriceTextField = (TextField<String>) this.get("startPrice");
        Label currentPriceLabel = (Label) this.get("lastBid.price");

        startPriceTextField.setVisible(!startPriceTextField.isVisible());
        currentPriceLabel.setVisible(!currentPriceLabel.isVisible());
    }

    Lot pageCurrentLot;


    private void init() {
        setDefaultModel(new CompoundPropertyModel<>(pageCurrentLot));


        add(new TextField<>("name"));
//        add(new TextField<>("description"));
        add(new TextArea<>("description"));


        TextField<String> startPriceTextField = new TextField<>("startPrice");
        add(startPriceTextField);

        Label currentPriceLabel = new Label("lastBid.price");
        add(currentPriceLabel);

        if (pageCurrentLot.getLotStatus() == Lot.status.CREATED || pageCurrentLot.getLotStatus() == Lot.status.EMPTY) {
            startPriceTextField.setVisible(true);
            currentPriceLabel.setVisible(false);
        } else {
            startPriceTextField.setVisible(false);
            currentPriceLabel.setVisible(true);
        }


        add(new FeedbackPanel("feedbackPanel"));
    }

    public LotForm(String id) {
        super(id);

        pageCurrentLot = new Lot();
        init();

    }

    public LotForm(String id, Lot pageCurrentLot) {
        super(id);

        this.pageCurrentLot = pageCurrentLot;
        init();
    }
}
