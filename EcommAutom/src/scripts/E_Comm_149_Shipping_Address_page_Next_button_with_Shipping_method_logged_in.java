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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class E_Comm_149_Shipping_Address_page_Next_button_with_Shipping_method_logged_in {

	public static void main(String[] args) throws InterruptedException {
		// Initialize ChromeDriver
		  WebDriver  driver = new ChromeDriver();
		//Pre requisites for the scripts
		  E_Comm_3_Navigate_to_website.navigateToWebsite(driver);
		  E_Comm_105_Sign_In_Link_Customer_Login_with_valid_data.SignInWithValidData(driver);
		  E_Comm_20_To_verify_the_functionality_of_add_to_cart_button.addToCartButton(driver);
		  nextButtonWithOneShippingMethodAndLoggedIn(driver);
	    driver.quit();
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
    public static void nextButtonWithOneShippingMethodAndLoggedIn(WebDriver driver) {
        try {
            //steps to navigate to the Checkout page-Review & Payments.
            Actions actions = new Actions(driver);
            // Locate the cart icon
            WebElement cartIcon = driver.findElement(By.xpath("//header/div[2]/div[1]/a[1]"));
            Thread.sleep(1000);

            // scroll back to cart icon
            actions.moveToElement(cartIcon).click().perform();
            System.out.println("cart icon open.");
            Thread.sleep(3000);
            //click the proceed to cart button
            WebElement proceedToCart = cartIcon.findElement(By.xpath("//*[@id=\"top-cart-btn-checkout\"]"));
            proceedToCart.click();
            System.out.println("proceed to cart button clicked");
            Thread.sleep(4000);
            
            //select the address first
            WebElement shipHereAddressbtn = driver.findElement(By.xpath("//body/div[3]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/div[1]/div[1]/div[1]/div[3]/button[2]"));
            shipHereAddressbtn.click();
            //actions.moveToElement(shipHereAddressbtn).click().perform();
            WebElement address = driver.findElement(By.xpath("//body/div[3]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/div[1]/div[1]/div[1]/div[3]"));
            address.click();

            if(address.isEnabled()) {
            	System.out.println("Address selected ");
            	ScreenshotAction.Screenshot(driver, "Address selected ");
            }else {
            	System.out.println("Address not selected ");
            	ScreenshotAction.Screenshot(driver, "Address not selected ");
            	driver.quit();
            }
            
            //scroll down the page first
            ScrollHelper.scrollToBottom(driver);
            
            Thread.sleep(1000);
            //select one shipping method
            WebElement shippingMethod = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/input[1]"));
            shippingMethod.click();
            if (shippingMethod.isSelected()) {
                shippingMethod.click();
                System.out.println("shipping method selected");
                ScreenshotAction.Screenshot(driver, "shipping method selected");
            } else {
                System.out.println("shipping method failed to be selected");
                ScreenshotAction.Screenshot(driver, "shipping method failed to be selected");
                driver.quit();
            }

            //click the Next button
            WebElement Nextbtn = driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
            Nextbtn.click();
            System.out.println("Next button clicked");
            
            //locate payment method page elements
            String OrderSummeryHeading = driver.findElement(By.xpath("//span[contains(text(),'Order Summary')]")).getText();
            WebElement summeryDisplayedElement = driver.findElement(By.xpath("//strong[contains(text(),'Order Total')]"));
            if (OrderSummeryHeading.equals("Order Summary") && summeryDisplayedElement.isDisplayed()) {
                System.out.println("Order Summary heading is displayed successfully");
                ScreenshotAction.Screenshot(driver, "Order Summary heading is displayed successfully");
            } else {
                System.out.println("Order Summary heading is not displayed ");
                ScreenshotAction.Screenshot(driver, "Order Summary heading is not displayed ");
                driver.quit();
            }
            Thread.sleep(2000);
            //locate the place order button
            WebElement placeOrderbtn = driver.findElement(By.xpath("//span[contains(text(),'Place Order')]"));
            if (placeOrderbtn.isDisplayed()) {
                System.out.println("place order button is displayed successfully");
                ScreenshotAction.Screenshot(driver, "place order button text is displayed successfully");
            } else {
                System.out.println("place order button text is not displayed ");
                ScreenshotAction.Screenshot(driver, "place order button text is not displayed ");
                driver.quit();
            }
            //locate the ship to: section
            String shipToHeading = driver.findElement(By.xpath("//span[contains(text(),'Ship To:')]")).getText();
            WebElement displayedAddress = driver.findElement(By.xpath("//body/div[3]/main[1]/div[2]/div[1]/div[2]/aside[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]"));
            if (shipToHeading.equals("Ship To:") && displayedAddress.isDisplayed()) {
                System.out.println("Ship To: section is displayed successfully");
                ScreenshotAction.Screenshot(driver, "Ship To: section is displayed successfully");
            } else {
                System.out.println("Ship To: section is not displayed ");
                ScreenshotAction.Screenshot(driver, "Ship To: section is not displayed ");
                driver.quit();
            }
            //locate the shipping method section
            String shippingMethodHeading = driver.findElement(By.xpath("//span[contains(text(),'Shipping Method:')]")).getText();
            WebElement displayedShipping = driver.findElement(By.xpath("//body/div[3]/main[1]/div[2]/div[1]/div[2]/aside[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/span[1]")); 
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
