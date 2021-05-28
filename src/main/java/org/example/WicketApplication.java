package org.example;

import org.apache.wicket.core.request.mapper.CryptoMapper;
import org.apache.wicket.csp.CSPDirective;
import org.apache.wicket.csp.CSPDirectiveSrcValue;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

public class WicketApplication extends WebApplication
{
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();
//		mountPage("/home", HomePage.class);
//		mountPage("/view/", ViewLotPage.class);
//		mountPage("/manage/", ManageLotPage.class);
//		mountPage("/new/", NewLotPage.class);
//		mountPage("/genericwtf/", GenericLotPage.class);
//		setRootRequestMapper(new CryptoMapper(getRootRequestMapper(), this));
//		mountPage("/home/", HomePage.class);
//		mountPage("/view/", ViewLotPage.class);
//		mountPage("/manage/", ManageLotPage.class);
//		mountPage("/new/", NewLotPage.class);
//		mountPage("/genericwtf/", GenericLotPage.class);

		// needed for the styling used by the quickstart
		getCspSettings().blocking()
			.add(CSPDirective.STYLE_SRC, CSPDirectiveSrcValue.SELF)
			.add(CSPDirective.STYLE_SRC, "https://fonts.googleapis.com/css")
			.add(CSPDirective.FONT_SRC, "https://fonts.gstatic.com");

		// add your configuration here
	}
}
