package jaraya81.bot;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import jaraya81.bot.exception.BotException;

public interface Bot {

	/**
	 * Obtiene el WebDriver Selenium instanciado en el bot.
	 * 
	 * @return
	 */
	WebDriver getWebDriver();

	/**
	 * Abre el navegador a la página solicitada.
	 * 
	 * @param url
	 * @throws BotException
	 */
	void openWeb(String url) throws BotException;

	/**
	 * Espera que un elemento esté activo dentro de la página.
	 * 
	 * @param cssSelector
	 *            cssSelector del elemento a esperar.
	 * @param timeMax
	 *            milisegundos máximos de espera por el elemento.
	 * @return true si el elemento está activo, false si no lo está.
	 * @throws BotException
	 */
	Boolean waitForEnableElement(String cssSelector, Long timeMax) throws BotException;

	/**
	 * Espera que un elemento exista dentro de la página.
	 * 
	 * @param css
	 *            cssSelector del elemento a esperar.
	 * @param timeMax
	 *            milisegundos máximos de espera por el elemento.
	 * @return true si el elemento existe, false si no existe.
	 * @throws BotException
	 */
	Boolean waitForElementByCssSelector(String css, Long timeMax) throws BotException;

	/**
	 * Espera que el navegador esté en la URL solicitada.
	 * 
	 * @param urlSite
	 *            URL solicitada
	 * @param timeMax
	 *            milisegundos máximos de espera por la página.
	 * @return true si el navegador está en la página, false si no está.
	 * @throws BotException
	 */
	Boolean waitForURL(String urlSite, Long timeMax) throws BotException;

	/**
	 * Espera que la URL del navegador haga match con el patrón solicitado
	 * 
	 * @param pattern
	 *            Patrón que hará match con la URL.
	 * @param timeMax
	 *            milisegundos máximos de espera por la página.
	 * @return true si la URL del navegador hace match, false si no.
	 * @throws BotException
	 */
	Boolean waitFotURLContains(String pattern, Long timeMax) throws BotException;

	/**
	 * Convierte el contenido de un texto a Double.
	 * 
	 * @param text
	 *            texto a convertir
	 * @param pattern
	 *            patrón para capturar el double dentro del texto (usar
	 *            parentesis para capturar)
	 * @return
	 * @throws BotException
	 */
	Double textToDouble(String text, String pattern) throws BotException;

	/**
	 * Obtiene un File dado un path especificado
	 * 
	 * @param filePath
	 *            path del File.
	 * @return
	 * @throws BotException
	 */
	File getFile(String filePath) throws BotException;

	WebElement findElement(By arg0);

	/**
	 * Cierra el navegador y mata al WebDriver
	 * 
	 * @throws BotException
	 */
	void closeWeb() throws BotException;

}
