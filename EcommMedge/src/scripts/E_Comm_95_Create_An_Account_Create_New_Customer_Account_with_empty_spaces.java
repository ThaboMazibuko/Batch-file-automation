/*
 E_Comm_95_Create_An_Account_Create_New_Customer_Account_with_empty_spaces 
 
Script Name        : E_Comm_95_Create_An_Account_Create_New_Customer_Account_with_empty_spaces
Purpose            : Script to handle the creation of a new customer account with empty spaces.
'!Developed By      : Thabo Mazibuko
'!Date              : 09/06/2024
TestDataSheet      : none
Test LInk TestCase Path  : Test Project : E-Commerce --> Test Suite : E-Commerce Test Suite --> est Suite : Authentication
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

public class E_Comm_95_Create_An_Account_Create_New_Customer_Account_with_empty_spaces {

	@Test
	public static void TC95()  {
		 // Initialize ChromeDriver
	  WebDriver  driver = new ChromeDriver();
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	  try {
		E_Comm_3_Navigate_to_website.navigateToWebsite(driver, wait);
		CreateAccButtonWithInvalidData(driver, wait);
		driver.quit();
	} catch (InterruptedException e) {
		System.out.println("try Error in TC95 ");
		e.printStackTrace();
		driver.quit();
	}
	 
	}
	/*
'!Purpose           : Script to handle the creation of a new customer account with empty spaces.
'!Input Parameters  : 
'                      - WebDriver: Represents the web browser session.
'                      - By: Class representing mechanisms to locate elements within a document.
'                      - WebElement: Interface representing an HTML element.
'                      - ScreenshotAction: Class containing methods to capture screenshots.
'                      - InterruptedException: Exception thrown when a thread is interrupted.
'!Output            : Handles the creation of a new customer account with empty data.
'!Developed By      : Thabo Mazibuko
'!Date              : 09/06/2024
	 */
	public static void CreateAccButtonWithInvalidData(WebDriver driver,WebDriverWait wait) throws InterruptedException {
		try {
		    
			WebElement registrationLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//header/div[1]/div[1]/ul[1]/li[3]/a[1]")));
			registrationLink.click();

			// Wait for the firstNameField element to be present
			WebElement firstNameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstname")));
			firstNameField.clear();
			if (firstNameField.isDisplayed() && firstNameField.getAttribute("value").equals("")) {
			    System.out.println("First name field is displayed successfully and it is blank.");
			    ScreenshotAction.Screenshot(driver, "First name field is displayed successfully and it is blank.");
			} else {
			    System.out.println("First name field is not displayed and has a text.");
			    ScreenshotAction.Screenshot(driver, "First name field is not displayed and has a text.");
			    driver.quit();
			}

			// Wait for the lastNameField element to be present
			WebElement lastNameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("lastname")));
			lastNameField.clear();
			if (lastNameField.isDisplayed() && lastNameField.getAttribute("value").equals("")) {
			    System.out.println("Last name field is displayed successfully and it is blank.");
			    ScreenshotAction.Screenshot(driver, "Last name field is displayed successfully and it is blank.");
			} else {
			    System.out.println("Last name field is not displayed and has a text.");
			    ScreenshotAction.Screenshot(driver, "Last name field is not displayed and has a text.");
			    driver.quit();
			}
		    // Verify the presence of the email field
			WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email_address")));
			emailField.clear();
			if (emailField.isDisplayed() && emailField.getAttribute("value").equals("")) {
			    System.out.println("email field is displayed successfully and it is blank.");
			    ScreenshotAction.Screenshot(driver, "email field is displayed successfully and it is blank.");
			} else {
			    System.out.println("email field is not displayed and has a text.");
			    ScreenshotAction.Screenshot(driver, "email field is not displayed and has a text.");
			    driver.quit();
			}

			// Wait for the passwordField element to be present
			WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
			passwordField.clear();
			if (passwordField.isDisplayed() && passwordField.getAttribute("value").equals("")) {
			    System.out.println("password field is displayed successfully and it is blank.");
			    ScreenshotAction.Screenshot(driver, "password field is displayed successfully and it is blank.");
			} else {
			    System.out.println("password field is not displayed and has a text.");
			    ScreenshotAction.Screenshot(driver, "password field is not displayed and has a text.");
			    driver.quit();
			}

			// Wait for the confirmPasswordField element to be present
			WebElement confirmPasswordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password-confirmation")));
			confirmPasswordField.clear();
			if (confirmPasswordField.isDisplayed() && confirmPasswordField.getAttribute("value").equals("")) {
			    System.out.println("confirm password field is displayed successfully and it is blank.");
			    ScreenshotAction.Screenshot(driver, "confirm password field is displayed successfully and it is blank.");
			} else {
			    System.out.println("confirm password field is not displayed and might have a text.");
			    ScreenshotAction.Screenshot(driver, "confirm password field is not displayed and might have a text.");
			    driver.quit();
			}

		    // Verify the presence of the create account button
			WebElement createAccountButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".submit")));
			if (createAccountButton.isDisplayed()) {
			    System.out.println("Create account button is displayed successfully.");
			    ScreenshotAction.Screenshot(driver, "Create account button is displayed successfully.");
			} else {
			    System.out.println("Create account button failed to be displayed.");
			    ScreenshotAction.Screenshot(driver, "Create account button failed to be displayed.");
			    driver.quit();
			}
			// Click on the submit button
			createAccountButton.click();

			// Wait for the error elements to be present
			WebElement firstNameError = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstname-error")));
			WebElement lastNameError = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("lastname-error")));
			WebElement emailError = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email_address-error")));
			WebElement passwordError = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password-error")));
			WebElement confPassError = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password-confirmation-error")));
		    //get the error texts
		    String firstNameErrorText = firstNameError.getText();
		    String lastNameErrorText = lastNameError.getText();
		    String emailErrorText = emailError.getText();
		    String passwordErrorText = passwordError.getText();
		    String confPassErrorText = confPassError.getText();

		    // Check if error messages are displayed for each field and print corresponding messages
		    if (firstNameError.isDisplayed() && firstNameErrorText.equals("This is a required field.")) { 
		        // If the error message for the first name is displayed, print the message
		        System.out.println("first name error message displays and matchs the expected first name error text successfully");
		    	ScreenshotAction.Screenshot(driver, "first name error message displays and matchs the expected first name error successfully");

		    }else {
		    	//else print
		    	System.out.println("first name error message does not displays and not matches the expected first nawe error text");
		    	ScreenshotAction.Screenshot(driver, "first name error message does not displays and not matches the expected first name error text");
		    	driver.quit();
		    }
		    if(lastNameError.isDisplayed() && lastNameErrorText.equals("This is a required field.")){
		        // If the error message for the last name is displayed, print the message
		        System.out.println("last name error message displays and matches the last name expected error successfully");
		    	ScreenshotAction.Screenshot(driver, "last name error message displays and matches the expected error successfully");

		    }else {
		    	System.out.println("last name error message does not displays and not matches the expected last name error text");
		    	ScreenshotAction.Screenshot(driver, "last name error message does not displays and matches the expected last name error text");
		    	driver.quit();
		    }
		    if(emailError.isDisplayed() && emailErrorText.equals("This is a required field.")) { 
		        // If the error message for the email is displayed, print the message
		        System.out.println("The email error message displays and matches the expected email error successfully");
		    	ScreenshotAction.Screenshot(driver, "The email error message displays and matches the expected email error successfully");

		    }else {
		    	//else print
		    	System.out.println("email error message does not displays and not matches the expected email error");
		    	ScreenshotAction.Screenshot(driver, "email error message does not displays and not matches the expected email error");
		    	driver.quit();
		    }
		    if(passwordError.isDisplayed() && passwordErrorText.equals("This is a required field.")){
		        // If the error message for the password is displayed, print the message
		        System.out.println("password error message displays and matches the expected password error text successfully");
		    	ScreenshotAction.Screenshot(driver, "password error message displays and matches the expected password error text successfully");

		    }else {
		    	//else print
		    	System.out.println("password error message does not displays and matchs the expected");
		    	ScreenshotAction.Screenshot(driver, "password error message does not displays and not matches the expected");
		    	driver.quit();
		    }
		    if(confPassError.isDisplayed() && confPassErrorText.equals("This is a required field.")){
		        // If the error message for the confirm password is displayed, print the message
		        System.out.println("confirm password error message displays and matches the expected confirm password error text successfully");
		    	ScreenshotAction.Screenshot(driver, "confirm password error message displays and matches the expected confirm password error text successfully");

		    }else {
		    	//else print
		    	System.out.println("confirm password error message does not displays and matchs the expected confirm password error message");
		    	ScreenshotAction.Screenshot(driver, "confirm password error message does not displays and not matches the expected confirm password error message");
		    	driver.quit();
		    }
		} catch (Exception e) {
		    // Print any exceptions that occur during the execution of the try block
		    System.out.println("An error occurred: " + e.getMessage());
		    // Take a screenshot of the error
		    ScreenshotAction.Screenshot(driver, "error occurred on the catch");
		    driver.quit();
		}finally {
			driver.quit();
		}
		
	}

}
