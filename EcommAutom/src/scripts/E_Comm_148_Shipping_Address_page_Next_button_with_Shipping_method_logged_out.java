/*
E_Comm_148_Shipping_Address_page_Next_button_with_Shipping_method_logged_out
 
Script Name        : E_Comm_148_Shipping_Address_page_Next_button_with_Shipping_method_logged_out
Purpose            : Script to handle the Shipping Address page Next button with Shipping method and logged out
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

public class E_Comm_148_Shipping_Address_page_Next_button_with_Shipping_method_logged_out {

    public static void main(String[] args) {
        try {
            // Initialize ChromeDriver
            WebDriver driver = new ChromeDriver();
            //Pre requisites for the scripts
            E_Comm_3_Navigate_to_website.navigateToWebsite(driver);
            E_Comm_20_To_verify_the_functionality_of_add_to_cart_button.addToCartButton(driver);
            nextButtonWithOneShippingMethod(driver);
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
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
	'!Output            : Handles the the "Next" button on "Shipping Address" page with only shipping method selected and other fields kept empty and logged out
	'!Developed By      : Thabo Mazibuko
	'!Date              : 11/06/2024
	*/
    public static void nextButtonWithOneShippingMethod(WebDriver driver) {
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
            Thread.sleep(1000);
            //scroll down the page first
            ScrollHelper.scrollToBottom(driver);
            Thread.sleep(1000);
            //select one shipping method
            WebElement shippingMethod = driver.findElement(By.cssSelector("body.checkout-index-index.page-layout-checkout:nth-child(2) div.page-wrapper:nth-child(5) main.page-main div.columns:nth-child(3) div.column.main div.checkout-container:nth-child(3) div.opc-wrapper:nth-child(5) ol.opc li.checkout-shipping-method div.checkout-shipping-method div.step-content form.form.methods-shipping table.table-checkout-shipping-method tbody:nth-child(2) tr.row:nth-child(1) td.col.col-method:nth-child(1) > input.radio"));
            if (!shippingMethod.isSelected()) {
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
            //locate the email error field
            String emailError = driver.findElement(By.id("customer-email-error")).getText();
            if (emailError.equals("This is a required field.")) {
                System.out.println("Email Error text is displayed successfully");
                ScreenshotAction.Screenshot(driver, "Email Error text is displayed successfully");
            } else {
                System.out.println("Email Error text is not displayed ");
                ScreenshotAction.Screenshot(driver, "Email Error text is not displayed ");
                driver.quit();
            }
            //locate the first name error field
            String firstNameError = driver.findElement(By.xpath("//body/div[2]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[2]/div[1]/div[1]/div[1]/div[1]/span[1]")).getText();
            if (firstNameError.equals("This is a required field.")) {
                System.out.println("first name Error text is displayed successfully");
                ScreenshotAction.Screenshot(driver, "first name Error text is displayed successfully");
            } else {
                System.out.println("first name Error text is not displayed ");
                ScreenshotAction.Screenshot(driver, "first name Error text is not displayed ");
                driver.quit();
            }
            //locate the first name error field
            String lastNameError = driver.findElement(By.xpath("//body/div[2]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[2]/div[1]/div[2]/div[1]/div[1]/span[1]")).getText();
            if (lastNameError.equals("This is a required field.")) {
                System.out.println("last name Error text is displayed successfully");
                ScreenshotAction.Screenshot(driver, "last name Error text is displayed successfully");
            } else {
                System.out.println("last name Error text is not displayed ");
                ScreenshotAction.Screenshot(driver, "last name Error text is not displayed ");
                driver.quit();
            }
            //locate the street address error field
            String streetAddressError = driver.findElement(By.cssSelector("body.checkout-index-index.page-layout-checkout:nth-child(2) div.page-wrapper:nth-child(5) main.page-main div.columns:nth-child(3) div.column.main div.checkout-container:nth-child(3) div.opc-wrapper:nth-child(5) ol.opc li.checkout-shipping-address div.step-content form.form.form-shipping-address:nth-child(2) div.fieldset.address fieldset.field.street.admin__control-fields.required:nth-child(4) div.control div.field._required._error:nth-child(1) div.control div.field-error > span:nth-child(1)")).getText();
            if (streetAddressError.equals("This is a required field.")) {
                System.out.println("street address Error text is displayed successfully");
                ScreenshotAction.Screenshot(driver, "street address Error text is displayed successfully");
            } else {
                System.out.println("street address Error text is not displayed ");
                ScreenshotAction.Screenshot(driver, "street address Error text is not displayed ");
                driver.quit();
            }
            //locate the city error field
            String cityError = driver.findElement(By.xpath("//body/div[2]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[2]/div[1]/div[4]/div[1]/div[1]/span[1]")).getText();
            if (cityError.equals("This is a required field.")) {
                System.out.println("City Error text is displayed successfully");
                ScreenshotAction.Screenshot(driver, "City Error text is displayed successfully");
            } else {
                System.out.println("City Error text is not displayed ");
                ScreenshotAction.Screenshot(driver, "City Error text is not displayed ");
                driver.quit();
            }
            //locate the city error field
            String state = driver.findElement(By.xpath("//body/div[2]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[2]/div[1]/div[5]/div[1]/div[1]/span[1]")).getText();
            if (state.equals("This is a required field.")) {
                System.out.println("state Error text is displayed successfully");
                ScreenshotAction.Screenshot(driver, "state Error text is displayed successfully");
            } else {
                System.out.println("state Error text is not displayed ");
                ScreenshotAction.Screenshot(driver, "state Error text is not displayed ");
                driver.quit();
            }
            //locate the city error field
            String ZipCode = driver.findElement(By.xpath("//body/div[2]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[2]/div[1]/div[7]/div[1]/div[1]/span[1]")).getText();
            if (ZipCode.equals("This is a required field.")) {
                System.out.println("ZipCode Error text is displayed successfully");
                ScreenshotAction.Screenshot(driver, "ZipCode Error text is displayed successfully");
            } else {
                System.out.println("ZipCode Error text is not displayed ");
                ScreenshotAction.Screenshot(driver, "ZipCode Error text is not displayed ");
                driver.quit();
            }
            //locate the city error field
            String phoneNumber = driver.findElement(By.xpath("//body/div[2]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[2]/div[1]/div[9]/div[1]/div[2]/span[1]")).getText();
            if (phoneNumber.equals("This is a required field.")) {
                System.out.println("phone Number Error text is displayed successfully");
                ScreenshotAction.Screenshot(driver, "phone Number Error text is displayed successfully");
            } else {
                System.out.println("phone Number Error text is not displayed ");
                ScreenshotAction.Screenshot(driver, "phone Number Error text is not displayed ");
                driver.quit();
            }

        } catch (Exception e) {
            e.printStackTrace();
            driver.quit();
        }
    }
}
