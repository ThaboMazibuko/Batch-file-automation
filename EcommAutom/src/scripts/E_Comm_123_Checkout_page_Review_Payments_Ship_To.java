/*
 E_Comm_132_Shipping_page_Order_summery_dropdown 
 
Script Name        : E_Comm_132_Shipping_page_Order_summery_dropdown
Purpose            : Script to handle the checkout page ship to address 
Developed By      : Thabo Mazibuko
Date              : 11/06/2024
TestDataSheet      : link.txt,SignIn.txt
Test LInk TestCase Path  : Test Project : E-Commerce --> Test Suite : E-Commerce Test Suite --> Test Suite : Checkout
 */
package scripts;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class E_Comm_123_Checkout_page_Review_Payments_Ship_To {

	public static void main(String[] args) throws InterruptedException {
		 // Initialize ChromeDriver
	  WebDriver  driver = new ChromeDriver();
	  //Pre requisites for the scripts
	  E_Comm_3_Navigate_to_website.navigateToWebsite(driver);
	  E_Comm_105_Sign_In_Link_Customer_Login_with_valid_data.SignInWithValidData(driver);
	  E_Comm_20_To_verify_the_functionality_of_add_to_cart_button.addToCartButton(driver);
	  verifyShipToDetails(driver);
	  driver.quit();
	}
	/*
	'!Purpose           : Script to handle order summery dropdown
	'!Input Parameters  : 
	'                      - WebDriver: Represents the web browser session.
	'                      - By: Class representing mechanisms to locate elements within a document.
	'                      - WebElement: Interface representing an HTML element.
	'                      - Actions: Class representing high-level interactions with the browser.
	'                      - ScreenshotAction: Class containing methods to capture screenshots.
	'                      - InterruptedException: Exception thrown when a thread is interrupted.
							-navigateToWebsite: function that opens the website when called
							-SignInWithValidData: functions that performes sign in operation when called
							-addToCartButton: function to handle the adding an item to cart operations
							-findElement: function that enables selenium to interact with browser elements
							-moveToElement: functions that allows mouse to move on the page 
							-click: built in function that allows the mouse to click an element
							-sleep:function that allows defined browser waiting time on run time 
							-quit: functions that quits the browser 
	'!Output            : Handles the customer login process with invalid data.
	'!Developed By      : Thabo Mazibuko
	'!Date              : 11/06/2024
	*/
	
	public static void verifyShipToDetails(WebDriver driver) throws InterruptedException { 
		
		try {
			
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			
			//steps to navigate to the Checkout page-Review & Payments.
		    Actions actions = new Actions(driver);
		    // Locate the cart icon
		    WebElement cartIcon = driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a"));
		    Thread.sleep(1000);
		    // Hover over the cart icon and click it 
		    actions.moveToElement(cartIcon).click().perform();
		    Thread.sleep(5000);
		    //click the proceed to cart button
		    WebElement proceedToCart = cartIcon.findElement(By.xpath("//*[@id=\"top-cart-btn-checkout\"]"));
            proceedToCart.click();
            
            Thread.sleep(3000);
			
            //select the address first
            WebElement shipHereAddressbtn = driver.findElement(By.cssSelector("body.checkout-index-index.page-layout-checkout:nth-child(2) div.page-wrapper:nth-child(5) main.page-main div.columns:nth-child(3) div.column.main div.checkout-container:nth-child(3) div.opc-wrapper:nth-child(5) ol.opc li.checkout-shipping-address div.step-content div.field.addresses:nth-child(1) div.control div.shipping-address-items div.shipping-address-item.not-selected-item:nth-child(3) button.action.action-select-shipping-item:nth-child(9) > span:nth-child(1)"));
            actions.moveToElement(shipHereAddressbtn).click().perform();
            System.out.println("Address selected ");
            //select and store the shipping address from the shipping page
            String address = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/div[1]/div[1]/div[1]/div[3]")).getText();
            System.out.println("Address stored as: "+address);
            
            Thread.sleep(1000);
            //click the next button;
            WebElement NextButton = driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
            NextButton.click();
            
            Thread.sleep(2000);
            //scroll down the page
            WebElement scrollDown = driver.findElement(By.id("block-discount-heading"));
            ScrollHelper.scrollToElement(driver, scrollDown);
            Thread.sleep(2000);
            
            String shipToaddress = driver.findElement(By.xpath("//*[@id=\"opc-sidebar\"]/div[2]/div/div[1]/div[2]")).getText();
            System.out.println("The ship To address is: "+ shipToaddress);
            //compare the addresses
            if(address.equals(shipToaddress)) {
            	//if addresses are the same prints the following
            	System.out.println("The selected address is displayed correctly on the Ship To details.");
                ScreenshotAction.Screenshot(driver, "selected address is displayed correctly" );
            }
            else {
            	//if they are not the same print the following
            	 System.out.println("The selected address is not displayed correctly on the Ship To details.");
                 ScreenshotAction.Screenshot(driver, "selected address is not displayed correctly" );
                 driver.quit();
            }

		} catch (InterruptedException e) {
		    System.out.print("The method has an error: " + e.getMessage());
		    driver.quit();
		} 
	}
}
