package org.example;

import org.apache.wicket.Session;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import javax.swing.text.View;
import java.io.Serializable;

public class NewLotPage extends GenericLotPage implements Serializable {

    public NewLotPage() {
        super();
        setVersioned(false);
        DAOLot dao = new DAOLot();
        Session.get().bind();

        add(new Label("header_text_label", "New lot"));

        Panel formPanel = new FormPanel("content");
        add(formPanel);
        LotForm lotForm = (LotForm) formPanel.get("lot_form");


        AbstractLink button1 = new SubmitLink("button1", lotForm) {
            @Override
            public void onAfterSubmit() {
                lotForm.pageCurrentLot.setOwner((User) Session.get().getAttribute("currentUser"));
                lotForm.pageCurrentLot.setLotStatus(Lot.status.CREATED);
                dao.add(lotForm.pageCurrentLot);



                //
                PageParameters pageParameters = new PageParameters();
                pageParameters.add("lotId", lotForm.pageCurrentLot.getId());
                setResponsePage(ManageLotPage.class, pageParameters);
                //

            }
        };
        Link<String> button2 = new Link<>("button2") {
            @Override
            public void onClick() {
                System.out.println("NO clicked");
//TODO
            }
        };
        TwoButtons manageButtons = new TwoButtons(button1, button2, "OK", "NO");
        add(new TwoButtonsPanel("header_components", manageButtons));


        add(new Label("footer", "footer"));
    }
}
