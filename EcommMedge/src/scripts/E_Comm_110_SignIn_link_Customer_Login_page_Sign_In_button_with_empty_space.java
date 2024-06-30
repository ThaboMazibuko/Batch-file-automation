/*
 E_Comm_110_SignIn_link_Customer_Login_page_Sign_In_button_with_empty_space 
 
Script Name       : E_Comm_110_SignIn_link_Customer_Login_page_Sign_In_button_with_empty_space
Purpose           : Script to handle the Sign In button on the customer login page with empty data.
Developed By      : Thabo Mazibuko
Date              : 09/06/2024
TestDataSheet     : SignIn.txt
Test LInk TestCase Path  : Test Project : E-Commerce --> Test Suite : E-Commerce Test Suite --> Test Suite : Authentication
 */
package scripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class E_Comm_110_SignIn_link_Customer_Login_page_Sign_In_button_with_empty_space {
@Test (enabled = false)
	public static void TC110()  {
		 // Initialize ChromeDriver
	  WebDriver  driver = new ChromeDriver();
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	//Pre requisites for the scripts
	//opening the website
      try {
		E_Comm_3_Navigate_to_website.navigateToWebsite(driver, wait);
		SignInButtonWithEmptyData(driver, wait);
		driver.quit();
	} catch (InterruptedException e) {
		e.printStackTrace();
		driver.quit();
	}
	  
     
	}
	/*
 *'!Purpose           : Script to handle the Sign In button on the customer login page with empty data.
'!Input 			  : 
'                      - WebDriver: Represents the web browser session.
'                      - By: Class representing mechanisms to locate elements within a document.
'                      - WebElement: Interface representing an HTML element.
'                      - ScreenshotAction: Class containing methods to capture screenshots.
'                      - InterruptedException: Exception thrown when a thread is interrupted.
						-navigateToWebsite: function that opens the website when called
						-findElement: function that enables selenium to interact with browser elements
						-moveToElement: functions that allows mouse to move on the page 
						-click: built in function that allows the mouse to click an element
						-sleep:function that allows defined browser waiting time on run time 
						-quit: functions that quits the browser 
'!Output            : Handles the Sign In button on the customer login page with empty data.
'!Developed By      : Thabo Mazibuko
'!Date              : 09/06/2024
	 */
	public static void SignInButtonWithEmptyData(WebDriver driver,WebDriverWait wait) throws InterruptedException {
		try {
	        
			//navigating to signIn page
			WebElement SinInLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//header/div[1]/div[1]/ul[1]/li[2]/a[1]")));
			SinInLink.click();

			//verify if the sign in page is displayed
			WebElement CustLogInHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Customer Login')]")));

			// Check if the unique section is displayed on the webpage
			if (CustLogInHeading.isDisplayed() && CustLogInHeading.getText().equals("Customer Login")) {
			    // Print message indicating successful opening of the sign in page
			    System.out.println("Sign in page opened successfully.");
			    ScreenshotAction.Screenshot(driver, "Sign in page opened successfully.");
			} else {
			    // Print message indicating successful opening of the sign in page
			    System.out.println("Sign in page failed to open");
			    ScreenshotAction.Screenshot(driver, "Sign in page failed to open.");
			    driver.quit();
			}
			Thread.sleep(1000);
			// Click on the submit button
			WebElement SignInbutton = wait.until(ExpectedConditions.elementToBeClickable(By.id("send2")));
			SignInbutton.click();

			// Find the error elements for email
			WebElement emailError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email-error")));

			// Check if error messages are displayed and matches the expected 
			if (emailError.isDisplayed()) { 
			    System.out.println("Email error element displayed successfully.");
			    //get the text and compares it with the expected text
			    String StringOfemailError = emailError.getText();
			    if(StringOfemailError.equals("This is a required field.")) {
			        System.out.println("Email error element text matches the expected email error message.");
			        ScreenshotAction.Screenshot(driver, "Email error element text matches the expected email error message.");

			    }else {
			        System.out.println("Email error element text does not match the expected email error text.");
			        ScreenshotAction.Screenshot(driver, "Email error element text does not match the extected email error text.");
			        driver.quit();
			    }
			    
			}else {
			    // If the error message for the email is not displayed, print the message
			    System.out.println("error message for the email field is not displayed");
			    ScreenshotAction.Screenshot(driver, "error message for the email field is not displayed");
			    driver.quit();
			}
			// Find the error elements for password
			WebElement passError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass-error")));

			// Check if error messages are displayed and matches the expected 
			if (passError.isDisplayed()) { 
			    System.out.println("Password error element displayed successfully.");
			    //get the text and compares it with the expected text
			    String StringOfpassError = passError.getText();
			    if(StringOfpassError.equals("This is a required field.")) {
			        System.out.println("Password error element text matches successfully with the expected password error.");
			    }else {
			        System.out.println("Password error element text does not match the expected password error message.");
			        ScreenshotAction.Screenshot(driver, "Password error element text does not match the expected password error message.");
			        driver.quit();
			    }
			    
			}else {
			    // If the error message for the password is not displayed, print the message
			    System.out.println("error message for the password is not displayed");
			    ScreenshotAction.Screenshot(driver, "error message for the password is not displayed");
			    driver.quit();
			}
	        
	        
	    } catch (Exception e) {
	        // Print any exceptions that occur during the execution of the try block
	        System.out.println("A try catch error occurred: " + e.getMessage());
	        // Take a screenshot of the error
	        ScreenshotAction.Screenshot(driver, " try catch error occurred");
	        driver.quit();
	    }
		
	}
	
	

}
