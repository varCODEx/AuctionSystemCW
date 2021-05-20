package org.example;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.wicketstuff.lambda.components.ComponentFactory;

public class HomePage__ extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage__(final PageParameters parameters) {
		super(parameters);

		add(new Label("version", getApplication().getFrameworkSettings().getVersion()));
		add(new Label("greeting_test_label", "TestLabel"));
		add(new Link<Void>("test_link") {
			@Override
			public void onClick() {
				System.out.println("onclick test msg");
			}
		});
		add(ComponentFactory.link("test_link2", (newlink) -> {
			System.out.println(newlink);
		}));

		// TODO Add your page's components here

	}
}
