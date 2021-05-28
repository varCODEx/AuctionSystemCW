package org.example;

import org.apache.wicket.markup.html.link.AbstractLink;

import java.io.Serializable;

//TODO serializable?
public class TwoButtons implements Serializable {
    //e.g. SubmitLink or Link
    AbstractLink button1;
    AbstractLink button2;
    String button1text;
    String button2text;

    public TwoButtons(AbstractLink button1, AbstractLink button2, String button1text, String button2text) {
        this.button1 = button1;
        this.button2 = button2;
        this.button1text = button1text;
        this.button2text = button2text;
    }
}
