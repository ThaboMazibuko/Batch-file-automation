
package scripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class E_Comm_105_Sign_In_Link_Customer_Login_with_valid_data {
@Test (enabled = false)
	public static void TC105() {
	// Initialize ChromeDriver
	  WebDriver  driver = new ChromeDriver();
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	//Pre requisites for the scripts
	  try {
		E_Comm_3_Navigate_to_website.navigateToWebsite(driver, wait);
		SignInWithValidData(driver, wait);
	} catch (InterruptedException e) {
		e.printStackTrace();
		driver.quit();
	}
	  
    
	}

	public static void SignInWithValidData(WebDriver driver,WebDriverWait wait) throws InterruptedException {
		
		//navigating to signIn page
		WebElement SinInLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//header/div[1]/div[1]/ul[1]/li[2]/a[1]")));
		SinInLink.click();

		// Wait for the customer sign in page title to be visible
		WebElement CustLogInHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Customer Login')]")));

		// Check if the unique section is displayed on the webpage
		if (CustLogInHeading.isDisplayed()) {
		    // Print message indicating successful opening of the sign in page
		    System.out.println("Sign in page opened successfully.");
		    ScreenshotAction.Screenshot(driver, "Sign in page opened successfully. screenshot saved");
		} else {
		    // Print message indicating successful opening of the sign in page
		    System.out.println("Sign in page failed to open");
		    ScreenshotAction.Screenshot(driver, "Sign in page failed to open. screenshot saved");
		}
        try {
            // Read sign-in data from file
            String[] signInData = readData.readSignInDataFromFile(driver);
            if (signInData == null || signInData.length < 2) {
                driver.quit();
                throw new IllegalArgumentException("Invalid sign-in data");
            }
            
            // Click on Sign In link
            WebElement signIn = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign In")));
            signIn.click();
            
            // Locate sign-in fields
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass")));
            WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("send2")));
            
            // Verify if the sign-in button is displayed and enabled
            if (signInButton.isDisplayed() && signInButton.isEnabled()) {
            	 System.out.println("Sign In button visible successfully");
            // Fill the sign-in fields with data from the file
            emailField.sendKeys(signInData[0]);
            passwordField.sendKeys(signInData[1]);
 
            // Click the sign-in button
            signInButton.click();
            } else {
                System.out.println("Sign-in button is not displayed ");
                driver.quit();
            }
 
        } catch (Exception e) {
            System.err.println("Error during sign-in: " + e.getMessage());
         // Take a screenshot of the error
	        ScreenshotAction.Screenshot(driver, "error occurred in catch");
            driver.quit();
        }
    }
	

}
