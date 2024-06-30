/*
E_Comm_148_Shipping_Address_page_Next_button_with_Shipping_method_logged_out
 
Script Name        : E_Comm_148_Shipping_Address_page_Next_button_with_Shipping_method_logged_out
Purpose            : Script to handle the Shipping Address page Next button with empty data and and user logged in.
Developed By      : Thabo Mazibuko
Date              : 11/06/2024
TestDataSheet      : none
Test LInk TestCase Path  : Test Project : E-Commerce --> Test Suite : E-Commerce Test Suite --> Test Suite : Men
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

public class E_Comm_149_Shipping_Address_page_Next_button_with_Shipping_method_logged_in {

	@Test
	public static void TC149() {
		// Initialize ChromeDriver
		  WebDriver  driver = new ChromeDriver();
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		//Pre requisites for the scripts
		  try {
			  E_Comm_3_Navigate_to_website.navigateToWebsite(driver, wait);
			  E_Comm_105_Sign_In_Link_Customer_Login_with_valid_data.SignInWithValidData(driver, wait);
			  E_Comm_20_To_verify_the_functionality_of_add_to_cart_button.addToCartButton(driver, wait);
			  nextButtonWithOneShippingMethodAndLoggedIn(driver, wait);
			  driver.quit();
		} catch (InterruptedException e) {
			e.printStackTrace();
			driver.quit();
		}
		 
	    
		}
	/*
	'!Purpose           : Script to handle the Shipping Address page Next button with Shipping method and logged out
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
	'!Output            : Handles the "Next" button on "Shipping Address" page with empty field, and user logged in.
	'!Developed By      : Thabo Mazibuko
	'!Date              : 11/06/2024
	*/
    public static void nextButtonWithOneShippingMethodAndLoggedIn(WebDriver driver,WebDriverWait wait) {
        try {
            //steps to navigate to the Checkout page-Review & Payments.
            Actions actions = new Actions(driver);
            // Locate the cart icon
            WebElement cartIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header/div[2]/div[1]/a[1]")));

	         actions.moveToElement(cartIcon).click().perform();
	         System.out.println("cart icon open.");
	
	         // Wait for the proceedToCart button to be clickable
	         WebElement proceedToCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"top-cart-btn-checkout\"]")));
	         proceedToCart.click();
	         System.out.println("proceed to cart button clicked");
	
	         // Wait for the shipHereAddressbtn element to be clickable
	         WebElement shipHereAddressbtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[3]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/div[1]/div[1]/div[1]/div[3]/button[2]")));
	         shipHereAddressbtn.click();
	         WebElement address = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[3]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/div[1]/div[1]/div[1]/div[3]")));
	         address.click();

	         if(address.isEnabled()) {
	             System.out.println("Address selected ");
	             ScreenshotAction.Screenshot(driver, "Address selected ");
	         } else {
	             System.out.println("Address not selected ");
	             ScreenshotAction.Screenshot(driver, "Address not selected ");
	             driver.quit();
	         }

	         // Scroll down the page first
	         ScrollHelper.scrollToBottom(driver);

	         // Wait for the shipping method element to be clickable
	         WebElement shippingMethod = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[1]/input[1]")));
	         shippingMethod.click();
	         if (shippingMethod.isSelected()) {
	             System.out.println("shipping method selected");
	             ScreenshotAction.Screenshot(driver, "shipping method selected");
	         } else {
	             System.out.println("shipping method failed to be selected");
	             ScreenshotAction.Screenshot(driver, "shipping method failed to be selected");
	             driver.quit();
	         }

	         WebElement Nextbtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Next')]")));
	         Nextbtn.click();
	         System.out.println("Next button clicked");

	         // Locate payment method page elements
	         WebElement orderSummaryHeadingElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Order Summary')]")));
	         String OrderSummeryHeading = orderSummaryHeadingElement.getText();
	         WebElement summeryDisplayedElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[contains(text(),'Order Total')]")));
	         if (OrderSummeryHeading.equals("Order Summary") && summeryDisplayedElement.isDisplayed()) {
	             System.out.println("Order Summary heading is displayed successfully");
	             ScreenshotAction.Screenshot(driver, "Order Summary heading is displayed successfully");
	         } else {
	             System.out.println("Order Summary heading is not displayed ");
	             ScreenshotAction.Screenshot(driver, "Order Summary heading is not displayed ");
	             driver.quit();
	         }

	         // Locate the place order button
	         WebElement placeOrderbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Place Order')]")));
	         if (placeOrderbtn.isDisplayed()) {
	             System.out.println("place order button is displayed successfully");
	             ScreenshotAction.Screenshot(driver, "place order button text is displayed successfully");
	         } else {
	             System.out.println("place order button text is not displayed ");
	             ScreenshotAction.Screenshot(driver, "place order button text is not displayed ");
	             driver.quit();
	         }
	         WebElement shipToElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Ship To:')]")));
	         String shipToHeading = shipToElement.getText();
	         WebElement displayedAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[3]/main[1]/div[2]/div[1]/div[2]/aside[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]")));
	         if (shipToHeading.equals("Ship To:") && displayedAddress.isDisplayed()) {
	             System.out.println("Ship To: section is displayed successfully");
	             ScreenshotAction.Screenshot(driver, "Ship To: section is displayed successfully");
	         } else {
	             System.out.println("Ship To: section is not displayed ");
	             ScreenshotAction.Screenshot(driver, "Ship To: section is not displayed ");
	             driver.quit();
	         }

	         // Locate the shipping method section
	         WebElement shippingMethodElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Shipping Method:')]")));
	         String shippingMethodHeading = shippingMethodElement.getText();
	         WebElement displayedShipping = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[3]/main[1]/div[2]/div[1]/div[2]/aside[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/span[1]"))); 
	         if (shippingMethodHeading.equals("Shipping Method:") && displayedShipping.isDisplayed()) {
	             System.out.println("Shipping Method: is displayed successfully");
	             ScreenshotAction.Screenshot(driver, "Shipping Method: is displayed successfully");
	         } else {
	             System.out.println("Shipping Method: is not displayed ");
	             ScreenshotAction.Screenshot(driver, "Shipping Method: is not displayed ");
	             driver.quit();
	         }
           
        } catch (Exception e) {
            e.printStackTrace();
            driver.quit();
        }
    }
}
