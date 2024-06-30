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

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class E_Comm_132_Shipping_page_Order_summery_dropdown {
@Test (enabled = false)
	public static void TC132() {
	 // Initialize ChromeDriver
	  WebDriver  driver = new ChromeDriver();
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	  //pre requisites for the script
	  try {
		 E_Comm_3_Navigate_to_website.navigateToWebsite(driver, wait);
		 E_Comm_105_Sign_In_Link_Customer_Login_with_valid_data.SignInWithValidData(driver, wait);
		 E_Comm_20_To_verify_the_functionality_of_add_to_cart_button.addToCartButton(driver, wait);
		 OrderSummeryDropdown(driver, wait);
		 driver.quit();
	} catch (InterruptedException e) {
		e.printStackTrace();
		driver.quit();
	}

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
   public static void OrderSummeryDropdown(WebDriver driver,WebDriverWait wait) {
	   try {
			//steps to navigate to the Checkout page-Review & Payments.
		    Actions actions = new Actions(driver);
		 // Locate the cart icon
		    WebElement cartIconCountNum = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header/div[2]/div[1]/a[1]/span[2]")));
		    Thread.sleep(1500);
		    // moving back up to the cart icon and click it 
		    actions.moveToElement(cartIconCountNum).click().perform();

		    // Wait for the cart popup to be visible and verify
		    WebElement cartIconOpen = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Balboa Persistence Tee')]")));
		    if(cartIconOpen.isDisplayed()) {
		    	System.out.println("Cart Icon open successfully");
		        ScreenshotAction.Screenshot(driver, "Cart Icon open successfully" );
		    }else {
		    	System.out.println("Cart Icon failed to open");
		        ScreenshotAction.Screenshot(driver, "Cart Icon failed to open" );
		    	driver.quit();
		    }
			 //getting the selected quantity from the cart pop up
		     String cartQTY = wait.until(ExpectedConditions.visibilityOfElementLocated(Variables.cartQTY)).getText();
			 //find and store the cart item total
			 String cartIconPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(Variables.cartSubTotal)).getText().replaceAll("[^0-9.]", "");
			 
			 WebElement seeDetailsDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//header/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[1]/div[1]/div[1]/span[1]")));
			 seeDetailsDropdown.click();
			 WebElement elementVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//dt[contains(text(),'Size')]")));
			 if(elementVisible.isDisplayed()) {
				 System.out.println("Dropdown clicked successfully");
				 ScreenshotAction.Screenshot(driver, "Dropdown clicked successfully" );
			 }else {
				 System.out.println("Dropdown click failed");
				 ScreenshotAction.Screenshot(driver, "Dropdown click failed" );
				 driver.quit();
			 }

			 String cartItemSize = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[1]/div[1]/div[1]/div[1]/dl[1]/dd[1]/span[1]"))).getText();
			 String cartItemColor = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[1]/div[1]/div[1]/div[1]/dl[1]/dd[2]"))).getText();
			 //click the proceed to cart button
		    WebElement proceedToCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='top-cart-btn-checkout']")));
		    proceedToCart.click();
		    // using the presence of the Next button to verify if the proceed to cart was clicked successfully
		    WebElement shippingAddresspageOpen = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Shipping Address')]")));
		    if(shippingAddresspageOpen.isDisplayed() && shippingAddresspageOpen.getText().equals("Shipping Address")) {
		    	System.out.println("Proceed to cart button clicked successfully");
		        ScreenshotAction.Screenshot(driver, "Proceed to cart button clicked successfully" );
		    }else {
		    	System.out.println("Proceed to cart button click failed");
		        ScreenshotAction.Screenshot(driver, "Proceed to cart button click failed" );
		    	driver.quit();
		    }
		  //verify the shipping order summery dropdown
		    WebElement summeryElementVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[2]/main[1]/div[2]/div[1]/div[2]/aside[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ol[1]/li[1]/div[1]/span[1]/span[1]/img[1]")));
		    if(summeryElementVisible.isDisplayed()) {
		    	System.out.println("Shipping Order Summery dropdown clicked and opened successfully");
		        ScreenshotAction.Screenshot(driver, "Shipping Order Summery dropdown clicked and opened successfully" );
		        
		    }else if(!summeryElementVisible.isDisplayed()){
			    WebElement summeryDropdwn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[2]/main[1]/div[2]/div[1]/div[2]/aside[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")));
			    summeryDropdwn.click();
			    System.out.println("Shipping Order Summery dropdown clicked and opened successfully");
		        ScreenshotAction.Screenshot(driver, "Shipping Order Summery dropdown clicked and opened successfully" );
		        
		    }else {
		    	System.out.println("Shipping Order Summery dropdown click failed");
		        ScreenshotAction.Screenshot(driver, "Shipping Order Summery dropdown click failed" );
		    	driver.quit();
		    }
			 String ShipAddressItemQTY = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[2]/main[1]/div[2]/div[1]/div[2]/aside[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ol[1]/li[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[2]"))).getText();
			 String ShipAddressItemPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'$29.00')]"))).getText().replaceAll("$","");
			 //click the details dropdown
			 WebElement ItemDetailsDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'View Details')]")));
			 seeDetailsDropdown.click();
			 WebElement detailsElementVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[2]/main[1]/div[2]/div[1]/div[2]/aside[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ol[1]/li[1]/div[1]/div[1]/div[2]/div[1]")));
			 if(detailsElementVisible.isDisplayed()) {
				 System.out.println(" Shipping address Dropdown clicked successfully");
				 ScreenshotAction.Screenshot(driver, " shipping address Dropdown clicked successfully" );
			 }else {
				 System.out.println("shipping address Dropdown click failed");
				 ScreenshotAction.Screenshot(driver, " shipping address Dropdown click failed" );
				 driver.quit();
			 }
			 
			 String ShipAddressItemSize = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//dd[contains(text(),'S')]"))).getText();
			 String ShipAddressItemColor = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//dd[contains(text(),'Gray')]"))).getText();
		    //comparing both the quantities texts
		    if (cartQTY.equals(ShipAddressItemQTY)) {
                System.out.println("The quantity selected on cart is the same as displayed quantity on order summery.");
                ScreenshotAction.Screenshot(driver, "selected quantity is displayed correctly the same on summery order" );
            } else {
            	System.out.println("The quantity selected on cart is not the same as displayed quantity on order summery.");
                ScreenshotAction.Screenshot(driver, "selected quantity is not displayed correctly the same on summery order" );
                driver.quit();
            }
		    //comparing both the price texts
		    if (cartIconPrice.equals(ShipAddressItemPrice)) {
                System.out.println("The price selected on cart is the same as displayed price on order summery.");
                ScreenshotAction.Screenshot(driver, "selected price is displayed correctly the same on summery order" );
            } else {
            	System.out.println("The price selected on cart is not the same as displayed price on order summery.");
                ScreenshotAction.Screenshot(driver, "selected price is not displayed correctly the same on summery order" );
                driver.quit();
            }
		    //comparing both the sizes
		    if (cartItemSize.equals(ShipAddressItemSize)) {
                System.out.println("The size selected on cart is the same as displayed size on order summery.");
                ScreenshotAction.Screenshot(driver, "selected size is displayed correctly the same on summery order" );
            } else {
            	System.out.println("The size selected on cart is not the same as displayed size on order summery.");
                ScreenshotAction.Screenshot(driver, "selected size is not displayed correctly the same on summery order" );
                driver.quit();
            }
		    //comparing the color
		    if (cartItemColor.equals(ShipAddressItemColor)) {
                System.out.println("The color selected on cart is the same as displayed color on order summery.");
                ScreenshotAction.Screenshot(driver, "selected color is displayed correctly the same on summery order" );
            } else {
            	System.out.println("The color selected on cart is not the same as displayed color on order summery.");
                ScreenshotAction.Screenshot(driver, "selected color is not displayed correctly the same on summery order" );
                driver.quit();
            }
		    
		} catch (Exception e) {
		    System.out.print("Thread was interrupted: " + e.getMessage());
		    driver.quit();
		} 
   }
}
