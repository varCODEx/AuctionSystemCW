package org.example;

import org.apache.wicket.Session;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class ViewLotPage extends GenericLotPage {

    Lot pageCurrentLot;

    public void onSubmit(int priceIncrease){
        pageCurrentLot.makeBid((User) Session.get().getAttribute("currentUser"), priceIncrease);
        System.out.println(pageCurrentLot.lastBid);
    }

    public ViewLotPage(Lot pageCurrentLot) {
        super();
        setVersioned(false);
        this.pageCurrentLot = pageCurrentLot;

        add(new Label("header_text_label", "View lot"));

        Panel dataPanel = new DataPanel("content", pageCurrentLot);
        add(dataPanel);


        ButtonAndAmountPanel buttonAndAmountPanel = new ButtonAndAmountPanel("header_components");
        add(buttonAndAmountPanel);
        if(pageCurrentLot.getLotStatus() != Lot.status.PLACED)
            buttonAndAmountPanel.setVisible(false);


        add(new Label("footer", "footer"));
    }

    public ViewLotPage(PageParameters pageParameters) {
        this(new DAOLot().read(pageParameters.get("lotId").toInt()));
    }
}
