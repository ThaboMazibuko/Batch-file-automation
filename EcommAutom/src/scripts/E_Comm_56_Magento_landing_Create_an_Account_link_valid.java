package scripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class E_Comm_56_Magento_landing_Create_an_Account_link_valid {
	public static void main(String[] args) throws InterruptedException {
		 // Initialize ChromeDriver
 	  WebDriver  driver = new ChromeDriver();
 	  E_Comm_3_Navigate_to_website.navigateToWebsite(driver);
 	 fillRegistrationForm(driver);
      driver.quit();
	}
	
    public static void fillRegistrationForm(WebDriver driver) {
        try {
        	
            // Read data from file
            String[] regData = readData.readRegistrationDataFromFile();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Thread.sleep(2000);
            ScreenshotAction.Screenshot(driver,"regPageOpenSuccess");
            System.out.print("screenshot for registration page open, success!");
            	// Locate registration fields
                WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstname")));
                WebElement lastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastname")));
                WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email_address")));
                WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
                WebElement confirmPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password-confirmation")));
                WebElement createAccountButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span")));
                //visibility screenshot
                ScreenshotAction.Screenshot(driver,"regElementsVisible");
                System.out.print("screenshot for visibilty of registration elements successfull!");
                // Fill the registration fields with data from the file
                firstNameField.sendKeys(regData[0]);
                lastNameField.sendKeys(regData[1]);
                emailField.sendKeys(regData[2]);
                passwordField.sendKeys(regData[3]);
                confirmPasswordField.sendKeys(regData[4]);
                //registration data input screenshot
                ScreenshotAction.Screenshot(driver,"regDataInputSuccess");
                System.out.print("screenshot for input of registration data successfull!");

                // Click the create account button
                createAccountButton.click();
                Thread.sleep(2000);
                //create account button screenshot
	              ScreenshotAction.Screenshot(driver,"create AccButtonSuccess");
	              System.out.print("screenshot for input of registration data successfull!");
            
	              Thread.sleep(1000);
            
            
            

        } catch (Exception e) {
            System.err.println("Error filling the registration form: " + e.getMessage());
            e.printStackTrace();
        }
        
    }
}
