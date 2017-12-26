package jaraya81.bot;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jaraya81.bot.enums.TipoDriver;

public class TestsBot {
	private static Logger LOG = LoggerFactory.getLogger(BotImpl.class);

	@Test
	public void testBot() throws Exception {
		Bot bot = new BotImpl(TipoDriver.HTML_UNIT);
		bot.openWeb("http://www.google.com/");
		LOG.info(bot.getWebDriver().getCurrentUrl());
		Assert.assertTrue("", bot.getWebDriver() != null);
		bot.closeWeb();

	}
}
