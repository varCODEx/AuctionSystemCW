package org.example;

import org.apache.wicket.Component;
import org.apache.wicket.Session;

public class LotLinkRedirector {

    public static void redirect(Component component, Lot lot) {
        if(lot.owner.equals(Session.get().getAttribute("currentUser")))
            component.setResponsePage(new ManageLotPage(lot));
        else
            component.setResponsePage(new ViewLotPage(lot));
    }
}
