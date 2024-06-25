/*
 E_Comm_108_Sign_In_Link__Customer_Login_with_invalid_data 
 
Script Name        : E_Comm_108_Sign_In_Link__Customer_Login_with_invalid_data
Purpose            : Script to handle customer login with invalid data on the Magento website.
Developed By      : Thabo Mazibuko
Date              : 09/06/2024
TestDataSheet      : SignIn.txt
Test LInk TestCase Path  : Test Project : E-Commerce --> Test Suite : E-Commerce Test Suite --> Test Suite : Authentication
 */
package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class E_Comm_108_Sign_In_Link__Customer_Login_with_invalid_data {

	public static void main(String[] args) throws InterruptedException {
	  // Initialize ChromeDriver
	  WebDriver  driver = new ChromeDriver();
	  //opening the website
      E_Comm_3_Navigate_to_website.navigateToWebsite(driver);
	  SignInButtonWithInvalidData(driver);
      driver.quit();
	}
	/*
	'!Purpose           : Script to handle customer login with invalid data on the Magento website.
	'!Input Parameters  : 
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
	'!Output            : Handles the customer login process with invalid data.
	'!Developed By      : Thabo Mazibuko
	'!Date              : 09/06/2024
	*/
	public static void SignInButtonWithInvalidData(WebDriver driver) throws InterruptedException {
		try {
	        
	        Thread.sleep(1000);
	        //navigating to signIn page
	        WebElement SinInLink = driver.findElement(By.xpath("//header/div[1]/div[1]/ul[1]/li[2]/a[1]"));
	        SinInLink.click();
	        
	        // locate the customer sign in page tittle 
	        WebElement CustLogInHeading = driver.findElement(By.xpath("//span[contains(text(),'Customer Login')]"));

	        // Check if the unique section is displayed on the webpage
	        if (CustLogInHeading.isDisplayed()) {
	            // Print message indicating successful opening of the sign in page
	            System.out.println("Sign in page opened successfully.");
	            ScreenshotAction.Screenshot(driver, "Sign in page opened successfully.");
	        } else {
	            // Print message indicating successful opening of the sign in page
	            System.out.println("Sign in page failed to open");
	            ScreenshotAction.Screenshot(driver, "Sign in page failed to open.");
	        }
	        // Read sign in data from the text file
	        String[] SignInData = readData.readSignInDataFromFile();

	        // Extracting registration data
	        String email = SignInData[0];
	        String password = SignInData[1];
	        
	        Actions actions = new Actions(driver);
	        // Verify cursor focus and send data for email field
	        WebElement emailField = driver.findElement(By.id("email"));
	        actions.click(emailField).perform();
	        if (emailField.equals(driver.switchTo().activeElement())) {
	            System.out.println("mouse Cursor is in the email field successfully.");
	            ScreenshotAction.Screenshot(driver, "mouse Cursor in the email field successfully");
	            //send data for first name 
	            emailField.sendKeys(email);
		        // Compare entered first name with extracted data
		        String enteredemail = emailField.getAttribute("value");
		        if (enteredemail.equals(email)) {
		            System.out.println("email entered matches the email extracted from the file successfully.");
		            ScreenshotAction.Screenshot(driver, "email entered matches the email extracted from the file successfully.");
		        } else {
		            System.out.println("email entered does not match the data extracted from the file.");
		            ScreenshotAction.Screenshot(driver, "email entered does not match the email extracted from the file");
		            driver.quit();
		        }
	        }else {
	            System.out.println("mouse Cursor is not in the email field.");
	            ScreenshotAction.Screenshot(driver, "mouse Cursor is not in the email field");
	            driver.quit();
	        }
	        // Verify cursor focus and send data for password field
	        WebElement passwordField = driver.findElement(By.id("pass"));
	        actions.click(passwordField).perform();
	        if (passwordField.equals(driver.switchTo().activeElement())) {
	            System.out.println("mouse Cursor is in the password field successfully.");
	            ScreenshotAction.Screenshot(driver, "mouse Cursor in the password field successfully");
	            // Send data for password
	            passwordField.sendKeys(password);
	            // Compare entered password with extracted data
	            String enteredPassword = passwordField.getAttribute("value");
	            if (enteredPassword.equals(password)) {
	                System.out.println("Password entered matches the password extracted from the file successfully.");
	                ScreenshotAction.Screenshot(driver, "Password entered matches the extrscted password");
	            } else {
	                System.out.println("Password entered does not match the data extracted from the file.");
	                ScreenshotAction.Screenshot(driver, "Password entered does not match the extracted password");
	                driver.quit();
	            }
	        } else {
	            System.out.println("mouse Cursor is not in the password field.");
	            ScreenshotAction.Screenshot(driver, "mouse Cursor not in password field");
	            driver.quit();
	        }
	        
	        Thread.sleep(2000);
	        // Click on the submit button
	        WebElement SignInButton = driver.findElement(By.id("send2"));
	        SignInButton.click();
	        Thread.sleep(2000);
	        // Find the error elements for email
		    WebElement emailError = driver.findElement(By.id("email-error"));
		    String StringOfemailError = emailError.getText();
		    // Check if error messages is displayed 
		    if (emailError.isDisplayed()) { 
		    	if (StringOfemailError.equals("Please enter a valid email address (Ex: johndoe@domain.com).")) {
            		System.out.println("Email error message displays and matches the expected error message");
	                ScreenshotAction.Screenshot(driver, "Email error message matches the expected error message and displays the error");
            	}else {
            		System.out.println("Email error message does not matches the expected error but displays");
	                ScreenshotAction.Screenshot(driver, "Email error message does not matches the expected error but displays");
	                driver.quit();
            	}
		        
		    }else {
		    	//if the error message does not display, print the ff message.
		    	System.out.println("Email error message does not display at all");
                ScreenshotAction.Screenshot(driver, "Email error message does not displays at all");
                driver.quit();
		    }
		   
	        
	        
	    } catch (Exception e) {
	        // Print any exceptions that occur during the execution of the try block
	        System.out.println("An error occurred: " + e.getMessage());
	        // Take a screenshot of the error
	        ScreenshotAction.Screenshot(driver, "error occurred");
	    }
		
	}

}
