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
import org.testng.annotations.Test;

public class E_Comm_123_Checkout_page_Review_Payments_Ship_To {
@Test (enabled = false)
	public static void TC123() {
		 // Initialize ChromeDriver
	  WebDriver  driver = new ChromeDriver();
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	  //Pre requisites for the scripts
	  try {
		E_Comm_3_Navigate_to_website.navigateToWebsite(driver, wait);
		E_Comm_105_Sign_In_Link_Customer_Login_with_valid_data.SignInWithValidData(driver, wait);
		E_Comm_20_To_verify_the_functionality_of_add_to_cart_button.addToCartButton(driver, wait);
		verifyShipToDetails(driver, wait);
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
	
	public static void verifyShipToDetails(WebDriver driver,WebDriverWait wait) throws InterruptedException { 
		
		try {
			
			//steps to navigate to the Checkout page-Review & Payments.
		    Actions actions = new Actions(driver);
		    // Locate the cart icon
		    WebElement cartIconCountNum = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header/div[2]/div[1]/a[1]/span[2]")));
		    
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
		    
		    //click the address and verify if its clicked
		    WebElement shipHereAddressbtnVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[2]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/div[1]/div[1]/div[1]/div[3]/button[2]")));
		    //select and store the shipping address from the shipping page
		    String ShipToAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[2]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/div[1]/div[1]/div[1]/div[3]"))).getText();
		    System.out.println("Shipping Address stored as: "+ShipToAddress);
		    if(shipHereAddressbtnVisible.isDisplayed()){
		    	System.out.println("Address not selected because button is visible by default");
			    WebElement shipHereAddressbtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[2]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/div[1]/div[1]/div[1]/div[3]/button[2]")));
			    shipHereAddressbtn.click();
			  
		    	if(!shipHereAddressbtnVisible.isDisplayed()) {
		    		System.out.println("Address selected successfully");
		    		ScreenshotAction.Screenshot(driver, "Address selected successfully" );
		    	}else {
		    		System.out.println("failed to interact with button");
		    		ScreenshotAction.Screenshot(driver, "failed to interact with button" );
		    		driver.quit();
		    	}
		    	
		    }else {
		    	System.out.println("Selecting address was successfully on default");
		        ScreenshotAction.Screenshot(driver, "selecting address successfully on default" );		    	
		    }

		    //click the next button;
		    WebElement NextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Next')]")));
		    NextButton.click();
		    // using the presence of the Payment method heading to verify if the Next button was clicked successfully
		    WebElement headingVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Payment Method')]")));
		    if(headingVisible.isDisplayed() && headingVisible.getText().equals("Payment Method")) {
		    	System.out.println("Next button clicked successfully");
		        ScreenshotAction.Screenshot(driver, "Next button clicked successfully" );
		    }else {
		    	System.out.println("Next button click failed");
		        ScreenshotAction.Screenshot(driver, "Next button click failed" );
		    	driver.quit();
		    }
		    //scroll down the page
		    ScrollHelper.scrollToBottom(driver);
            
		    // Get the ship to address
		    String ReviewPaymentAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[3]/main[1]/div[2]/div[1]/div[2]/aside[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]"))).getText();
		    System.out.println("The Review Payment page address is: "+ ReviewPaymentAddress);

		    //compare the addresses 
		    if(ReviewPaymentAddress.equals(ShipToAddress)) {
		        //if addresses are the same prints the following
		        System.out.println("The selected address is displayed correctly on the Ship To details.");
		        ScreenshotAction.Screenshot(driver, "selected address is displayed correctly" );
		    } else {
		        //if they are not the same print the following
		        System.out.println("The selected address is not displayed correctly on the Ship To details.");
		        ScreenshotAction.Screenshot(driver, "selected address is not displayed correctly" );
		        driver.quit();
		    }

		} catch (Exception e) {
		    System.out.print("The method has an error: " + e.getMessage());
		 // Take a screenshot of the error
	        ScreenshotAction.Screenshot(driver, " try catch error occurred");
		    driver.quit();
		} 
	}
}
