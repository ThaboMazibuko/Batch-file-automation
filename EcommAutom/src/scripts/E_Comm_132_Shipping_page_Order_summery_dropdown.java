/*
 E_Comm_132_Shipping_page_Order_summery_dropdown 
 
Script Name        : E_Comm_132_Shipping_page_Order_summery_dropdown
Purpose            : Script to handle order summery dropdown
Developed By      : Thabo Mazibuko
Date              : 11/06/2024
TestDataSheet      : link.txt,SignIn.txt
Test LInk TestCase Path  : Test Project : E-Commerce --> Test Suite : E-Commerce Test Suite --> Test Suite : Checkout
 */
package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class E_Comm_132_Shipping_page_Order_summery_dropdown {

	public static void main(String[] args) throws InterruptedException {
	 // Initialize ChromeDriver
	  WebDriver  driver = new ChromeDriver();
	  //pre requisites for the script
	  E_Comm_3_Navigate_to_website.navigateToWebsite(driver);
	  E_Comm_105_Sign_In_Link_Customer_Login_with_valid_data.SignInWithValidData(driver);
	  OrderSummeryDropdown(driver);
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
							- SignInWithValidData: functions that performes sign in operation when called
							-findElement: function that enables selenium to interact with browser elements
							-moveToElement: functions that allows mouse to move on the page 
							-click: built in function that allows the mouse to click an element
							-sleep:function that allows defined browser waiting time on run time 
							-quit: functions that quits the browser 
	'!Output            : Handls the order summery dropdown details
	'!Developed By      : Thabo Mazibuko
	'!Date              : 11/06/2024
	*/
   public static void OrderSummeryDropdown(WebDriver driver) {
	   try {
		   Thread.sleep(2000);
			//steps to navigate to the Checkout page-Review & Payments.
		    Actions actions = new Actions(driver);
		    // Locate the cart icon
		    WebElement cartIcon = driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a"));
		    Thread.sleep(1000);
		   
		    // scroll back to cart icon 
		    actions.moveToElement(cartIcon).click().perform();
		    System.out.println("cart icon open.");
		    Thread.sleep(5000);
		    //getting the selected quantity from the cart pop up
		    WebElement cartQTY = driver.findElement(Variables.cartQTY);
		    String cartQTYtext = cartQTY.getText().replaceAll("[^0-9.]", "");
		    //System.out.println("The quantity on cart is: "+cartQTYtext);
		    //find and store the cart subtotal
		    WebElement cartPrice = cartIcon.findElement(Variables.cartSubTotal);
		    String cartpriceText = cartPrice.getText().replaceAll("[^0-9.]", "");
		    //print the cart icon quantity text
		    System.out.println("The subtotal on cart is: "+cartpriceText);
		    WebElement seeDetailsDropdown = cartIcon.findElement(By.xpath("//header/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[1]/div[1]/div[1]/span[1]"));
		    seeDetailsDropdown.click();
		    System.out.println("Dropdown clicked");
		    String cartSize = driver.findElement(By.xpath("//header/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[1]/div[1]/div[1]/div[1]/dl[1]/dd[1]/span[1]")).getText();
		    String cartColor = driver.findElement(By.xpath("//span[contains(text(),'Gray')]")).getText();

		    Thread.sleep(1000);
		    //click the proceed to cart button
		    WebElement proceedToCart = cartIcon.findElement(By.xpath("//*[@id=\"top-cart-btn-checkout\"]"));
		    proceedToCart.click();
		    System.out.println("proceed to cart button clicked");
		    
		    Thread.sleep(2000);
		    //getting the displayed quantity from the cart pop up
           	WebElement ShippingorderQTY = cartIcon.findElement(Variables.ShippingorderQTY);
		    String ShippingorderQTYtext = ShippingorderQTY.getText().replaceAll("[^0-9.]", "");
		    WebElement shippingItemPrice = driver.findElement(Variables.shippingItemPrice);
		    String shippingItemPriceText = shippingItemPrice.getText().replaceAll("[^0-9.]", "");
		    WebElement ViewDetailsDropdown = cartIcon.findElement(By.xpath("//span[contains(text(),'View Details')]"));
		    ViewDetailsDropdown.click();
		    String ShipAddressItemSize = driver.findElement(By.xpath("//dd[contains(text(),'S')]")).getText();
		    String ShipAddressItemColor = driver.findElement(By.xpath("//dd[contains(text(),'Gray')]")).getText();

		    //comparing both the quantities texts
		    if (cartQTYtext.equals(ShippingorderQTYtext)) {
                System.out.println("The quantity selected on cart is the same as displayed quantity on order summery.");
                ScreenshotAction.Screenshot(driver, "selected quantity is displayed correctly the same on summery order" );
            } else {
            	System.out.println("The quantity selected on cart is not the same as displayed quantity on order summery.");
                ScreenshotAction.Screenshot(driver, "selected quantity is not displayed correctly the same on summery order" );
                driver.quit();
            }
		    //comparing both the price texts
		    if (cartpriceText.equals(shippingItemPriceText)) {
                System.out.println("The price selected on cart is the same as displayed price on order summery.");
                ScreenshotAction.Screenshot(driver, "selected price is displayed correctly the same on summery order" );
            } else {
            	System.out.println("The price selected on cart is not the same as displayed price on order summery.");
                ScreenshotAction.Screenshot(driver, "selected price is not displayed correctly the same on summery order" );
                driver.quit();
            }
		    //comparing both the sizes
		    if (cartSize.equals(ShipAddressItemSize)) {
                System.out.println("The size selected on cart is the same as displayed size on order summery.");
                ScreenshotAction.Screenshot(driver, "selected size is displayed correctly the same on summery order" );
            } else {
            	System.out.println("The size selected on cart is not the same as displayed size on order summery.");
                ScreenshotAction.Screenshot(driver, "selected size is not displayed correctly the same on summery order" );
                driver.quit();
            }
		    //comparing the color
		    if (cartColor.equals(ShipAddressItemColor)) {
                System.out.println("The color selected on cart is the same as displayed color on order summery.");
                ScreenshotAction.Screenshot(driver, "selected color is displayed correctly the same on summery order" );
            } else {
            	System.out.println("The color selected on cart is not the same as displayed color on order summery.");
                ScreenshotAction.Screenshot(driver, "selected color is not displayed correctly the same on summery order" );
                driver.quit();
            }
		    
           
		} catch (InterruptedException e) {
		    System.out.print("Thread was interrupted: " + e.getMessage());
		    driver.quit();
		} 
   }
}
