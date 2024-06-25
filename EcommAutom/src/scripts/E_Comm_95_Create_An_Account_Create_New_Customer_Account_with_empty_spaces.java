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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class E_Comm_95_Create_An_Account_Create_New_Customer_Account_with_empty_spaces {

	public static void main(String[] args) throws InterruptedException {
		 // Initialize ChromeDriver
	  WebDriver  driver = new ChromeDriver();
	  E_Comm_3_Navigate_to_website.navigateToWebsite(driver);
	 CreateAccButtonWithInvalidData(driver);
      driver.quit();
	}
	@Test
	public static void TC95() throws InterruptedException {
		 // Initialize ChromeDriver
	  WebDriver  driver = new ChromeDriver();
	  E_Comm_3_Navigate_to_website.navigateToWebsite(driver);
	 CreateAccButtonWithInvalidData(driver);
     driver.quit();
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
	public static void CreateAccButtonWithInvalidData(WebDriver driver) throws InterruptedException {
		try {
		    
		    Thread.sleep(1000);

		    WebElement registrationLink = driver.findElement(By.xpath("//header/div[1]/div[1]/ul[1]/li[3]/a[1]"));
		    registrationLink.click();
		    // Verify the presence of the first name field and clear any default data
		    WebElement firstNameField = driver.findElement(By.id("firstname"));
		    firstNameField.clear();
		    if (firstNameField.isDisplayed() && firstNameField.getText().equals("")) {
		        System.out.println("First name field is displayed successfully and it is blank.");
		        ScreenshotAction.Screenshot(driver, "First name field is displayed successfully and it is blank.");
		    } else {
		        System.out.println("First name field is not displayed and has a default text.");
		        ScreenshotAction.Screenshot(driver, "First name field is not displayed and has a default text.");
		        driver.quit();
		    }

		    // Verify the presence of the last name field
		    WebElement lastNameField = driver.findElement(By.id("lastname"));
		    lastNameField.clear();
		    if (lastNameField.isDisplayed() && lastNameField.getText().equals("")) {
		    	System.out.println("last name field is displayed successfully and it is blank.");
		        ScreenshotAction.Screenshot(driver, "last name field is displayed successfully and it is blank.");
		    } else {
		        System.out.println("last name field is not displayed and has a default text.");
		        ScreenshotAction.Screenshot(driver, "last name field is not displayed and has a default text.");
		        driver.quit();
		    }

		    // Verify the presence of the email field
		    WebElement emailField = driver.findElement(By.id("email_address"));
		    emailField.clear();
		    if (emailField.isDisplayed() && emailField.getText().equals("")) {
		    	System.out.println("email field is displayed successfully and it is blank.");
		        ScreenshotAction.Screenshot(driver, "email field is displayed successfully and it is blank.");
		    } else {
		        System.out.println("email field is not displayed and has a default text.");
		        ScreenshotAction.Screenshot(driver, "email field is not displayed and has a default text.");
		        driver.quit();
		    }

		    // Verify the presence of the password field
		    WebElement passwordField = driver.findElement(By.id("password"));
		    passwordField.clear();
		    if (passwordField.isDisplayed() && passwordField.getText().equals("")) {
		    	System.out.println("password field is displayed successfully and it is blank.");
		        ScreenshotAction.Screenshot(driver, "password field is displayed successfully and it is blank.");
		    } else {
		        System.out.println("password field is not displayed and has a default text.");
		        ScreenshotAction.Screenshot(driver, "password field is not displayed and has a default text.");
		        driver.quit();
		    }

		    // Verify the presence of the confirm password field
		    WebElement confirmPasswordField = driver.findElement(By.id("password-confirmation"));
		    confirmPasswordField.clear();
		    if (confirmPasswordField.isDisplayed()&& confirmPasswordField.getText().equals("")) {
		    	System.out.println("confirm password field is displayed successfully and it is blank.");
		        ScreenshotAction.Screenshot(driver, "confirm password field is displayed successfully and it is blank.");
		    } else {
		        System.out.println("confirm password field is not displayed and has a default text.");
		        ScreenshotAction.Screenshot(driver, "confirm password field is not displayed and has a default text.");
		        driver.quit();
		    }

		    // Verify the presence of the create account button
		    WebElement createAccountButton = driver.findElement(By.cssSelector(".submit"));
		    if (createAccountButton.isDisplayed()) {
		        System.out.println("Create account button is displayed.");
		        ScreenshotAction.Screenshot(driver, "Create account button is displayed.");
		    } else {
		        System.out.println("Create account button is not displayed.");
		        ScreenshotAction.Screenshot(driver, "Create account button is not displayed.");
		        driver.quit();
		    }
		    // Click on the submit button
		    createAccountButton.click();
		    // Pause execution for 2 seconds to allow time for elements to load
		    Thread.sleep(2000);

		    // Find the error elements for first name, last name, email, password, and confirm password
		    WebElement firstNameError = driver.findElement(By.id("firstname-error"));
		    WebElement lastNameError = driver.findElement(By.id("lastname-error"));
		    WebElement emailError = driver.findElement(By.id("email_address-error"));
		    WebElement passwordError = driver.findElement(By.id("password-error"));
		    WebElement confPassError = driver.findElement(By.id("password-confirmation-error"));
		    
		    //get the error texts
		    String firstNameErrorText = firstNameError.getText();
		    String lastNameErrorText = lastNameError.getText();
		    String emailErrorText = emailError.getText();
		    String passwordErrorText = passwordError.getText();
		    String confPassErrorText = confPassError.getText();

		    // Check if error messages are displayed for each field and print corresponding messages
		    if (firstNameError.isDisplayed() && firstNameErrorText.equals("This is a required field.")) { 
		        // If the error message for the first name is displayed, print the message
		        System.out.println("first name error message displays and matchs the expected error text successfully");
		    	ScreenshotAction.Screenshot(driver, "first name error message displays and matchs the expected error successfully");

		    }else {
		    	//else print
		    	System.out.println("first name error message does not displays and not matches the expected error text");
		    	ScreenshotAction.Screenshot(driver, "first name error message does not displays and not matches the expected error text");
		    	driver.quit();
		    }
		    if(lastNameError.isDisplayed() && lastNameErrorText.equals("This is a required field.")){
		        // If the error message for the last name is displayed, print the message
		        System.out.println("last name error message displays and matches the expected error successfully");
		    	ScreenshotAction.Screenshot(driver, "last name error message displays and matches the expected error successfully");

		    }else {
		    	System.out.println("last name error message does not displays and not matches the expected");
		    	ScreenshotAction.Screenshot(driver, "last name error message does not displays and matches the expected");
		    	driver.quit();
		    }
		    if(emailError.isDisplayed() && emailErrorText.equals("This is a required field.")) { 
		        // If the error message for the email is displayed, print the message
		        System.out.println("The email error message displays and matches the expected error successfully");
		    	ScreenshotAction.Screenshot(driver, "The email error message displays and matches the expected error successfully");

		    }else {
		    	//else print
		    	System.out.println("email error message does not displays and not matches the expected");
		    	ScreenshotAction.Screenshot(driver, "email error message does not displays and not matches the expected");
		    	driver.quit();
		    }
		    if(passwordError.isDisplayed() && passwordErrorText.equals("This is a required field.")){
		        // If the error message for the password is displayed, print the message
		        System.out.println("password error message displays and matches the expected error text successfully");
		    	ScreenshotAction.Screenshot(driver, "password error message displays and matches the expected error text successfully");

		    }else {
		    	//else print
		    	System.out.println("password error message does not displays and matchs the expected");
		    	ScreenshotAction.Screenshot(driver, "password error message does not displays and not matches the expected");
		    	driver.quit();
		    }
		    if(confPassError.isDisplayed() && confPassErrorText.equals("This is a required field.")){
		        // If the error message for the confirm password is displayed, print the message
		        System.out.println("confirm password error message displays and matches the expected error text successfully");
		    	ScreenshotAction.Screenshot(driver, "confirm password error message displays and matches the expected error text successfully");

		    }else {
		    	//else print
		    	System.out.println("confirm password error message does not displays and matchs the expected");
		    	ScreenshotAction.Screenshot(driver, "confirm password error message does not displays and not matches the expected");
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
