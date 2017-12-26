package jaraya81.bot;

import java.io.File;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gargoylesoftware.htmlunit.BrowserVersion;

import jaraya81.bot.enums.TipoDriver;
import jaraya81.bot.enums.ErrorCode;
import jaraya81.bot.exception.BotException;
import jaraya81.bot.utils.FileUtils;

public class BotImpl implements Bot {

	private static Logger logger = LoggerFactory.getLogger(BotImpl.class);
	private WebDriver webDriver;
	// TODO Implementar control de ventanas

	public BotImpl(TipoDriver enumTipoDriver) throws BotException {
		super();
		this.webDriver = this.cargarDriver(enumTipoDriver);
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public void openWeb(String url) throws BotException {
		if (webDriver == null) {
			throw new BotException("", ErrorCode.DRIVER_NOT_FOUND);
		}
		webDriver.get(url);
		logger.info("page:" + webDriver.getCurrentUrl());
	}

	private WebDriver cargarDriver(TipoDriver enumTipoDriver) throws BotException {
		if (enumTipoDriver == null) {
			throw new BotException("enumTipoDriver", ErrorCode.PARAM_NULL);
		}
		if (enumTipoDriver.equals(TipoDriver.HTML_UNIT)) {
			return new HtmlUnitDriver(BrowserVersion.CHROME);
		}
		if (enumTipoDriver.equals(TipoDriver.CHROME)) {
			return this.getChromeDriver();
		}
		if (enumTipoDriver.equals(TipoDriver.PHANTOM)) {
			new BotException(TipoDriver.PHANTOM.name(), ErrorCode.NOT_IMPLEMENTED);
		}
		return null;
	}

	// TODO PONER DRIVER EN EL CLASSPATH
	private ChromeDriver getChromeDriver() throws BotException {
		File file = FileUtils.getFile("C:\\tmp\\chromedriver.exe");
		if (file == null || !file.exists()) {
			throw new BotException("C:\\tmp\\chromedriver.exe", ErrorCode.FILE_NOT_FOUND);
		}
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		return new ChromeDriver();
	}

	public Boolean waitForEnableElement(String cssSelector, Long timeMax) throws BotException {
		if (webDriver == null) {
			throw new BotException("NO HA CARGADO EL DRIVER", ErrorCode.DRIVER_NOT_FOUND);
		}

		Long time = new Date().getTime();
		while (!webDriver.findElement(By.cssSelector(cssSelector)).isEnabled()
				&& new Date().getTime() < (time + timeMax)) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				throw new BotException("Error Sleep", ErrorCode.ERROR, e);
			}
		}
		if (!webDriver.findElement(By.cssSelector(cssSelector)).isEnabled()) {
			return Boolean.FALSE;
		} else {
			return Boolean.TRUE;
		}
	}

	public Boolean waitForElementByCssSelector(String css, Long timeMax) throws BotException {
		if (webDriver == null) {
			throw new BotException("NO HA CARGADO EL DRIVER:", ErrorCode.ERROR);
		}

		Long time = new Date().getTime();
		while (webDriver.findElements(By.cssSelector(css)).isEmpty() && new Date().getTime() < (time + timeMax)) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				throw new BotException("Error Sleep", ErrorCode.ERROR, e);
			}
		}
		if (webDriver.findElements(By.cssSelector(css)).isEmpty()) {
			return Boolean.FALSE;
		} else {
			logger.info("OK: " + css);
			return Boolean.TRUE;
		}

	}

	public Boolean waitForURL(String urlSite, Long timeMax) throws BotException {
		if (webDriver == null) {
			throw new BotException("NO HA CARGADO EL DRIVER", ErrorCode.ERROR);
		}

		Long time = new Date().getTime();
		while (!webDriver.getCurrentUrl().contains(urlSite) && new Date().getTime() < (time + timeMax)) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				throw new BotException("Error Sleep", ErrorCode.ERROR, e);
			}
		}
		if (!webDriver.getCurrentUrl().contains(urlSite)) {
			return Boolean.FALSE;
		} else {
			logger.info("OK: " + urlSite);
			return Boolean.TRUE;
		}

	}

	public void closeWeb() throws BotException {
		if (webDriver == null) {
			throw new BotException("", ErrorCode.DRIVER_NOT_FOUND);
		}
		webDriver.close();
		webDriver.quit();
		logger.info("OK:closeWeb");

	}

	public Double textToDouble(String text, String pattern) throws BotException {
		return FileUtils.textToDouble(text, pattern);
	}

	public File getFile(String filePath) throws BotException {
		return FileUtils.getFile(filePath);
	}

	public Boolean waitFotURLContains(String urlSite, Long timeMax) throws BotException {
		throw new BotException("NOT IMPLEMENTED YET", ErrorCode.NOT_IMPLEMENTED);
	}

}
