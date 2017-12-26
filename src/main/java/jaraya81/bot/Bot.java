package jaraya81.bot;

import java.io.File;

import org.openqa.selenium.WebDriver;

import jaraya81.bot.exception.BotException;

public interface Bot {

	WebDriver getWebDriver();

	void openWeb(String url) throws BotException;

	Boolean waitForEnableElement(String cssSelector, Long timeMax) throws BotException;

	Boolean waitForElementByCssSelector(String css, Long timeMax) throws BotException;

	Boolean waitForURL(String urlSite, Long timeMax) throws BotException;

	Boolean waitFotURLContains(String urlSite, Long timeMax) throws BotException;

	Double textToDouble(String text, String pattern) throws BotException;

	File getFile(String filePath) throws BotException;

	void closeWeb() throws BotException;

}
