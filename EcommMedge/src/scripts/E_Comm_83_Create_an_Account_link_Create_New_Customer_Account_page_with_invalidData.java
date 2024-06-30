/*
 E_Comm_83_Create_an_Account_link_Create_New_Customer_Account_page_with_invalidData 
 
Script Name        : E_Comm_83_Create_an_Account_link_Create_New_Customer_Account_page_with_invalidData
Purpose            : Script to handle the creation of a new customer account with invalid data.
'!Developed By      : Thabo Mazibuko
'!Date              : 09/06/2024
TestDataSheet      : [Provide if applicable]
Test LInk TestCase Path  : [Provide if applicable]
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

public class E_Comm_83_Create_an_Account_link_Create_New_Customer_Account_page_with_invalidData {
	
	@Test
	public static void TC83() {
		 // Initialize ChromeDriver
		WebDriver  driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		try {
			E_Comm_3_Navigate_to_website.navigateToWebsite(driver, wait);
			CreateAccButtonWithInvalidData(driver, wait);
			driver.quit();
		} catch (InterruptedException e) {
			e.printStackTrace();
			driver.quit();
		}
		
		
	}
	/*
	 *'!Purpose           : Script to handle the creation of a new customer account with invalid data.
'!Input Parameters  : 
'                      - WebDriver: Represents the web browser session.
'                      - By: Class representing mechanisms to locate elements within a document.
'                      - WebElement: Interface representing an HTML element.
'                      - ScreenshotAction: Class containing methods to capture screenshots.
'                      - InterruptedException: Exception thrown when a thread is interrupted.
'!Output            : Handles the creation of a new customer account with invalid data.
'!Developed By      : Thabo Mazibuko
'!Date              : 09/06/2024
	 */
	public static void CreateAccButtonWithInvalidData(WebDriver driver,WebDriverWait wait) throws InterruptedException {
		try {
			WebElement registrationLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//header/div[1]/div[1]/ul[1]/li[3]/a[1]")));
			registrationLink.click();

			// Wait for the form elements to be present
			WebElement firstNameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstname")));
			WebElement lastNameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("lastname")));
			WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email_address")));
			WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
			WebElement confirmPasswordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password-confirmation")));
			WebElement createAccountButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".submit")));
			
			// Read registration data from the text file
	        String[] registrationData = readData.readRegistrationDataFromFile(driver);

	        // Extracting registration data
	        String regName = registrationData[0];
	        String lastName = registrationData[1];
	        String regEmail = registrationData[2];
	        String password = registrationData[3];
	        String confirmPassword = registrationData[4];

	        Actions actions = new Actions(driver);
	        // Verify cursor focus and send data for First Name field
	        actions.click(firstNameField).perform();
	        if (firstNameField.equals(driver.switchTo().activeElement())) {
	            System.out.println("Cursor is in the First name field successfully.");
	            ScreenshotAction.Screenshot(driver, "Cursor in First name field successfully");
	            //send data for first name 
		        firstNameField.sendKeys(regName);
		        // Compare entered first name with extracted data
		        String enteredFirstName = firstNameField.getAttribute("value");
		        if (enteredFirstName.equals(regName)) {
		            System.out.println("First name entered matches the data extracted from the file successfully.");
		            ScreenshotAction.Screenshot(driver, "First name entered matches from file successfully");
		        } else {
		            System.out.println("First name entered does not match the first name extracted from the file.");
		            ScreenshotAction.Screenshot(driver, "First name entered does not match with the first name on file");
		            driver.quit();
		        }
	        } else {
	            System.out.println("Cursor is not in the First name field.");
	            ScreenshotAction.Screenshot(driver, "Cursor not is in First name field");
	            driver.quit();
	        }
	        

	        // Verify cursor focus and send data for Last Name field
	        actions.click(lastNameField).perform();
	        if (lastNameField.equals(driver.switchTo().activeElement())) {
	            System.out.println("Cursor is in the Last name field successfully.");
	            ScreenshotAction.Screenshot(driver, "Cursor in Last name field successfully");
	            //send data
		        lastNameField.sendKeys(lastName);
		        // Compare entered last name with extracted data
		        String enteredLastName = lastNameField.getAttribute("value");
		        if (enteredLastName.equals(lastName)) {
		            System.out.println("Last name entered matches the last name extracted from the file successfully.");
		            ScreenshotAction.Screenshot(driver, "Last name entered matches the last name on file successfully");
		        } else {
		            System.out.println("Last name entered does not match the last name extracted from the file.");
		            ScreenshotAction.Screenshot(driver, "Last name entered does not match the last name from the file");
		            driver.quit();
		        }
	        } else {
	            System.out.println("Cursor is not in the Last name field.");
	            ScreenshotAction.Screenshot(driver, "Cursor is not in the Last name field");
	            driver.quit();
	        }
	       
	        // Verify cursor focus and send data for Email field
	        actions.click(emailField).perform();
	        if (emailField.equals(driver.switchTo().activeElement())) {
	            System.out.println("Cursor is in the Email field successfully.");
	            ScreenshotAction.Screenshot(driver, "Cursor is in the Email field successfully");
	            emailField.sendKeys(regEmail);

		        // Compare entered email with extracted data
		        String enteredEmail = emailField.getAttribute("value");
		        if (enteredEmail.equals(regEmail)) {
		            System.out.println("Email entered matches the email extracted from the file successfully.");
		            ScreenshotAction.Screenshot(driver, "Email entered matches the email from the file successfully");
		        } else {
		            System.out.println("Email entered does not match the email extracted from the file.");
		            ScreenshotAction.Screenshot(driver, "Email entered does not match the email from file");
		            driver.quit();
		        }
	        }else {
	            System.out.println("Cursor is not in the Email field.");
	            ScreenshotAction.Screenshot(driver, "Cursor is not in the Email field");
	            driver.quit();
	        }
	        

	        // Verify cursor focus and send data for Password field
	        actions.click(passwordField).perform();
	        if (passwordField.equals(driver.switchTo().activeElement())) {
	            System.out.println("Cursor is in the Password field successfully.");
	            ScreenshotAction.Screenshot(driver, "Cursor is in the Password field successfully");
	            passwordField.sendKeys(password);

		        // Compare entered password with extracted data
		        String enteredPassword = passwordField.getAttribute("value");
		        if (enteredPassword.equals(password)) {
		            System.out.println("Password entered matches the password extracted from the file successfully.");
		            ScreenshotAction.Screenshot(driver, "Password entered matches the password from the file");
		        } else {
		            System.out.println("Password entered does not match the password extracted from the file.");
		            ScreenshotAction.Screenshot(driver, "Password entered does not match the password from the file");
		            driver.quit();
		        }
	        } else {
	            System.out.println("Cursor is not in the Password field.");
	            ScreenshotAction.Screenshot(driver, "Cursor not in Password field");
	            driver.quit();
	        }

	        // Verify cursor focus and send data for Confirm Password field
	        actions.click(confirmPasswordField).perform();
	        if (confirmPasswordField.equals(driver.switchTo().activeElement())) {
	            System.out.println("Cursor is in the Confirm Password field successfully.");
	            ScreenshotAction.Screenshot(driver, "Cursor is in the Confirm Password field successfully");
	            confirmPasswordField.sendKeys(confirmPassword);

		        // Compare entered confirm password with extracted data
		        String enteredConfirmPassword = confirmPasswordField.getAttribute("value");
		        if (enteredConfirmPassword.equals(confirmPassword)) {
		            System.out.println("Confirm password entered matches the confirm password extracted from the file successfully.");
		            ScreenshotAction.Screenshot(driver, "Confirm password entered matches the confirm password from the file");
		        } else {
		            System.out.println("Confirm password entered does not match the confirm password extracted from the file.");
		            ScreenshotAction.Screenshot(driver, "Confirm password entered does not match the confirm password extracted from the file");
		            driver.quit();
		        }
		        
	        } else {
	            System.out.println("Cursor is not in the Confirm Password field.");
	            ScreenshotAction.Screenshot(driver, "Cursor not in Confirm Password field");
	            driver.quit();
	        }
	        
	        // Click on the submit button
	        createAccountButton.click();
	        //find the error elements and read the error texts displayed
	        /*WebElement firstNameError = driver.findElement(By.xpath("//div[@id='firstname-error']"));
	        String firstNameErrorText = driver.findElement(By.xpath("//div[@id='firstname-error']")).getText();
	        if((firstNameError.isDisplayed()) && firstNameErrorText.equals("This is a required field.")) {
	        	System.out.println("First name error message displayed successfully.");
	        	ScreenshotAction.Screenshot(driver, "First name error message displayed successfully.");
	        }else {
	        	System.out.println("First name error message failed to be displayed .");
	        	ScreenshotAction.Screenshot(driver, "First name error message failed to be displayed.");
	        	driver.quit();
	        }
	        WebElement lastNameError = driver.findElement(By.xpath("//div[@id='firstname-error']"));
	        String lastNameErrorText = driver.findElement(By.xpath("//div[@id='firstname-error']")).getText();
	        if((lastNameError.isDisplayed()) && lastNameErrorText.equals("This is a required field.")) {
	        	System.out.println("last name error message displayed successfully.");
	        	ScreenshotAction.Screenshot(driver, "last name error message displayed successfully.");
	        }else {
	        	System.out.println("last name error message failed to be displayed .");
	        	ScreenshotAction.Screenshot(driver, "last name error message failed to be displayed.");
	        	driver.quit();
	        }
            */
	        WebElement emailError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='email_address-error']")));
	        String emailErrorText = emailError.getText();
	        if(emailError.isDisplayed() && emailErrorText.equals("Please enter a valid email address (Ex: johndoe@domain.com).")) {
	            System.out.println("email error message displayed successfully.");
	            ScreenshotAction.Screenshot(driver, "email error message displayed successfully.");
	        } else {
	            System.out.println("email error message failed to be displayed.");
	            ScreenshotAction.Screenshot(driver, "email error message failed to be displayed.");
	            driver.quit();
	        }

	        // Wait for the passError element to be present and visible
	        WebElement passError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='password-error']")));
	        String passErrorText = passError.getText();
	        if(passError.isDisplayed() && passErrorText.equals("Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored.")) {
	            System.out.println("Password error message displayed successfully.");
	            ScreenshotAction.Screenshot(driver, "Password error message displayed successfully.");
	        } else {
	            System.out.println("Password error message failed to be displayed.");
	            ScreenshotAction.Screenshot(driver, "Password error message failed to be displayed.");
	            driver.quit();
	        }
	        WebElement confPassError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='password-confirmation-error']")));
	        String confPassErrorText = confPassError.getText();
	        if(confPassError.isDisplayed() && confPassErrorText.equals("Please enter the same value again.")) {
	        	System.out.println("Confirm Password error message displayed successfully.");
	        	ScreenshotAction.Screenshot(driver, "Confirm Password error message displayed successfully.");
	        }else {
	        	System.out.println("Confirm Password error message failed to be displayed.");
	        	ScreenshotAction.Screenshot(driver, "Confirm Password error message failed to be displayed.");
	        	driver.quit();
	        }/* 
	        WebElement ReqFieldError = driver.findElement(By.xpath(""));
	        String ReqFieldErrorText = driver.findElement(By.id("")).getText();
	        if(ReqFieldError.isDisplayed() && ReqFieldErrorText.equals("Required Fields")) {
	        	System.out.println("Required Field error message displayed successfully.");
	        	ScreenshotAction.Screenshot(driver, "Required Field error message displayed successfully.");
	        }else {
	        	System.out.println("Required Field error message failed to be displayed.");
	        	ScreenshotAction.Screenshot(driver, "Required Field error message failed to be displayed.");
	        	driver.quit();
	        }  */
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        driver.quit();
	    }
	   

}
}