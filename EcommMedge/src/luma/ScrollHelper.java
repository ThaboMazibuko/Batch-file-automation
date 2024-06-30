package luma;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
/**
* Helper class providing methods to scroll within a web page using JavaScriptExecutor.
*/
 
public class ScrollHelper {
	 /**
     * Scrolls to the bottom of the web page.
     *
     * @param driver The WebDriver instance controlling the browser.
     */
    public static void scrollToBottom(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
 
    /**
     * Scrolls to the specified web element on the web page.
     *
     * @param driver  The WebDriver instance controlling the browser.
     * @param element The WebElement to scroll to.
     */
    public static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}