package jaraya81.bot;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gargoylesoftware.htmlunit.BrowserVersion;

import jaraya81.bot.enums.EnumTipoDriver;
import jaraya81.bot.utils.FileUtils;

public class Bot {

	private static Logger logger = LoggerFactory.getLogger(Bot.class);
	private WebDriver webDriver;
	// TODO Implementar control de ventanas

	public Bot(EnumTipoDriver enumTipoDriver) throws Exception {
		super();
		this.webDriver = this.cargarDriver(enumTipoDriver);
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public void openWeb(String url) throws Exception {
		if (webDriver == null) {
			throw new Exception("driver not found");
		}
		webDriver.get(url);
		logger.info("page:" + webDriver.getCurrentUrl());
	}

	private WebDriver cargarDriver(EnumTipoDriver enumTipoDriver) throws Exception {
		if (enumTipoDriver == null) {
			throw new Exception("enumTipoDriver null");
		}
		if (enumTipoDriver.equals(EnumTipoDriver.HTML_UNIT)) {
			return new HtmlUnitDriver(BrowserVersion.CHROME);
		}
		if (enumTipoDriver.equals(EnumTipoDriver.CHROME)) {
			return this.getChromeDriver();
		}
		if (enumTipoDriver.equals(EnumTipoDriver.PHANTOM)) {
			new Exception("NOT IMPLEMENTED YET");
		}
		return null;
	}

	// TODO PONER DRIVER EN EL CLASSPATH
	private ChromeDriver getChromeDriver() throws Exception {
		File file = FileUtils.getFile("C:\\tmp\\chromedriver.exe");
		if (file == null || !file.exists()) {
			throw new Exception("CHROME DRIVER NOT FOUND");
		}
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		return new ChromeDriver();
	}

	// TODO MEJORAR LOS BUSY-WAITING
	public void waitForEnableElement(String cssSelector) throws Exception {
		if (webDriver == null) {
			throw new Exception("NO HA CARGADO EL DRIVER:");
		}
		Integer i = 1;
		while (!webDriver.findElement(By.cssSelector(cssSelector)).isEnabled() && i < 10000) {
			i++;
		}
		if (!webDriver.findElement(By.cssSelector(cssSelector)).isEnabled()) {
			throw new Exception("ELEMENTO NO ESTÁ ACTIVADO");
		}
	}

	// TODO MEJORAR LOS BUSY-WAITING
	public void waitForElementByCssSelector(String css) throws Exception {
		if (webDriver == null) {
			throw new Exception("NO HA CARGADO EL DRIVER:");
		}
		Integer i = 1;
		while (webDriver.findElements(By.cssSelector(css)).isEmpty() && i < 5000) {
			i++;
		}
		if (webDriver.findElements(By.cssSelector(css)).isEmpty()) {
			throw new Exception("NO SE ENCUENTRA O NO CARGÓ EL ELEMENTO A TIEMPO");
		}
		logger.info("OK: " + css);

	}

	// TODO MEJORAR LOS BUSY-WAITING
	public void waitForURL(String urlSite) throws Exception {
		if (webDriver == null) {
			throw new Exception("NO HA CARGADO EL DRIVER:");
		}
		Integer i = 1;
		while (!webDriver.getCurrentUrl().contains(urlSite) && i < 10000) {
			i++;
		}
		if (!webDriver.getCurrentUrl().contains(urlSite)) {
			throw new Exception("NO INGRESÓ CORRECTAMENTE A LA URL SOLICITADA");
		}
		logger.info("OK: " + urlSite);
	}

	public void closeWeb() throws Exception {
		if (webDriver == null) {
			throw new Exception("NO HA CARGADO EL DRIVER:");
		}
		webDriver.close();
		webDriver.quit();
		logger.info("OK:closeWeb");

	}

}
