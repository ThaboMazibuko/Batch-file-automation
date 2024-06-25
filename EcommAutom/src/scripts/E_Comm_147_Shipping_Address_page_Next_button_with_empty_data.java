/*
E_Comm_148_Shipping_Address_page_Next_button_with_Shipping_method_logged_out
 
Script Name        : E_Comm_148_Shipping_Address_page_Next_button_with_Shipping_method_logged_out
Purpose            : Script to handle the Shipping Address page Next button with empty data
Developed By      : Thabo Mazibuko
Date              : 11/06/2024
TestDataSheet      : none
Test LInk TestCase Path  : Test Project : E-Commerce --> Test Suite : E-Commerce Test Suite --> Test Suite : Men
 */
package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class E_Comm_147_Shipping_Address_page_Next_button_with_empty_data {

	public static void main(String[] args) throws InterruptedException {
		// Initialize ChromeDriver
		  WebDriver  driver = new ChromeDriver();
		//Pre requisites for the scripts
		  E_Comm_3_Navigate_to_website.navigateToWebsite(driver);
		  E_Comm_20_To_verify_the_functionality_of_add_to_cart_button.addToCartButton(driver);
		  shippingAddressButtonWithEmptyData(driver);
	    driver.quit();
		}
	/*
	 /*
	'!Purpose           : Script to handle the Shipping Address page Next button with empty data
	'!Input  : 
	'                      - WebDriver: Represents the web browser session.
	'                      - By: Class representing mechanisms to locate elements within a document.
	'                      - WebElement: Interface representing an HTML element.
	'                      - Actions: Class representing high-level interactions with the browser.
	'                      - ScreenshotAction: Class containing methods to capture screenshots.
	'                      - InterruptedException: Exception thrown when a thread is interrupted.
							-findElement: function that enables selenium to interact with browser elements
							-moveToElement: functions that allows mouse to move on the page 
							-click: built in function that allows the mouse to click an element
							-sleep:function that allows defined browser waiting time on run time 
							-quit: functions that quits the browser 
							-navigateToWebsite: function that opens the website when called
							-addToCartBurron: adds an item to cart when called
	'!Output            : Handles the the "Next" button on "Shipping Address" page with only shipping method selected and other fields kept empty and logged out
	'!Developed By      : Thabo Mazibuko
	'!Date              : 11/06/2024
	*/
		public static void shippingAddressButtonWithEmptyData(WebDriver driver) throws InterruptedException {
			try {
				//steps to navigate to the Checkout page-Review & Payments.
			    Actions actions = new Actions(driver);
			    // Locate the cart icon
			    WebElement cartIcon = driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a"));
			    Thread.sleep(1000);
			   
			    // scroll back to cart icon 
			    actions.moveToElement(cartIcon).click().perform();
			    System.out.println("cart icon open.");
			    Thread.sleep(3000);
			    //click the proceed to cart button
			    WebElement proceedToCart = cartIcon.findElement(By.xpath("//*[@id=\"top-cart-btn-checkout\"]"));
			    proceedToCart.click();
			    System.out.println("proceed to cart button clicked");
			    //scroll down the page first
			    ScrollHelper.scrollToBottom(driver);
			    Thread.sleep(1000);
			    //click the Next button
			    WebElement Nextbtn = driver.findElement(By.xpath("//span[contains(text(),'Next')]"
			    		+ ""));
			    Nextbtn.click();
			    System.out.println("Next button clicked");
			    //locate and read the expected error
			    String Warning = driver.findElement(By.xpath("//span[contains(text(),'The shipping method is missing. Select the shippin')]")).getText();
			    //comparing both the quantities texts
			    if (Warning.equals("The shipping method is missing. Select the shipping method and try again.")) {
	                System.out.println("warning text is displayed successfully");
	                ScreenshotAction.Screenshot(driver, "warning text is displayed successfully" );
	            } else {
	            	System.out.println("warning text is not displayed ");
	                ScreenshotAction.Screenshot(driver, "warning text is not displayed " );
	                driver.quit();
	            }
			 } catch (Exception e) {
		            e.printStackTrace();
		            driver.quit();
		        }
		    
		}
			
}
