package org.example;

import org.apache.wicket.Page;
import org.apache.wicket.Session;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class ManageLotPage extends GenericLotPage {

    public TwoButtons configureManageButtons(LotForm lotForm, Lot pageCurrentLot){
        DAOLot dao = new DAOLot();


        AbstractLink button1_save = new SubmitLink("button1", lotForm) {
            @Override
            public void onAfterSubmit() {
                dao.save(pageCurrentLot);
                System.out.println(LotStorage.storage);
            }
        };

        Link<String> button2_stop = new Link<>("button2") {
            @Override
            public void onClick() {
                System.out.println("STOP clicked");
                pageCurrentLot.setLotStatus(Lot.status.STOPPED);
                dao.save(pageCurrentLot);
                lotForm.setVisible(false);
                System.out.println(LotStorage.storage);
            }
        };

        AbstractLink button1_place = new SubmitLink("button1", lotForm) {
            @Override
            public void onAfterSubmit() {
                button2_stop.add(new Label("button2text", "STOP"));
                getParent().replace(button2_stop);
                button1_save.add(new Label("button1text", "SAVE"));
                getParent().replace(button1_save);
                lotForm.togglePriceLabels();
                pageCurrentLot.setLotStatus(Lot.status.PLACED);
                dao.save(pageCurrentLot);
                //TODO link
                Label link = new Label("additional_header_component", "LINK");
                add(link);
                link.setVisible(true);
                System.out.println(LotStorage.storage);
            }
        };

        Link<String> button2_delete = new Link<>("button2") {
            @Override
            public void onClick() {
                System.out.println("DELETE clicked");
                dao.delete(pageCurrentLot);
                setResponsePage(HomePage.class);
                System.out.println(LotStorage.storage);
            }
        };
        TwoButtons manageButtons;
        if (pageCurrentLot.getLotStatus() == Lot.status.CREATED)
            manageButtons = new TwoButtons(button1_place, button2_delete, "PLACE", "DELETE");
        else
            manageButtons = new TwoButtons(button1_save, button2_stop, "SAVE", "STOP");

        return manageButtons;
    }

    public ManageLotPage(Lot pageCurrentLot) {
        super();
        setVersioned(false);
        if (Session.get().getAttribute("currentUser") != pageCurrentLot.owner)
            setResponsePage(new ViewLotPage(pageCurrentLot));

        add(new Label("header_text_label", "Manage your lot"));

        Panel formPanel = new FormPanel("content", pageCurrentLot);
        add(formPanel);
        LotForm lotForm = (LotForm) formPanel.get("lot_form");

        TwoButtons manageButtons = configureManageButtons(lotForm, pageCurrentLot);
        TwoButtonsPanel twoButtonsPanel = new TwoButtonsPanel("header_components", manageButtons);
        add(twoButtonsPanel);




        add(new Label("footer", "footer"));


    }

    public ManageLotPage(PageParameters pageParameters) {
        this(new DAOLot().read(pageParameters.get("lotId").toInt()));
//        BookmarkablePageLink bookmarkablePageLink = new BookmarkablePageLink<Void>("footer", ViewLotPage.class, pageParameters);
//        replace(bookmarkablePageLink);

    }
}
