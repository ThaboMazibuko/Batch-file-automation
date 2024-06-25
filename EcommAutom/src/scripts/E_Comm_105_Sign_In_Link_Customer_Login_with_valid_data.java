
package scripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class E_Comm_105_Sign_In_Link_Customer_Login_with_valid_data {

	public static void main(String[] args) throws InterruptedException {
	// Initialize ChromeDriver
	  WebDriver  driver = new ChromeDriver();
	//Pre requisites for the scripts
	  E_Comm_3_Navigate_to_website.navigateToWebsite(driver);
	  SignInWithValidData(driver);
    driver.quit();
	}

	public static void SignInWithValidData(WebDriver driver) throws InterruptedException {
		
		 //navigating to signIn page
        WebElement SinInLink = driver.findElement(By.xpath("//header/div[1]/div[1]/ul[1]/li[2]/a[1]"));
        SinInLink.click();
        
        // locate the customer sign in page tittle 
        WebElement CustLogInHeading = driver.findElement(By.xpath("//span[contains(text(),'Customer Login')]"));

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
            String[] signInData = readData.readSignInDataFromFile();
            if (signInData == null || signInData.length < 2) {
                driver.quit();
                throw new IllegalArgumentException("Invalid sign-in data");
            }
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            
            // Click on Sign In link
            WebElement signIn = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign In")));
            signIn.click();
            
            // Locate sign-in fields
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass")));
            WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("send2")));
            
            // Verify if the sign-in button is displayed and enabled
            if (signInButton.isDisplayed() && signInButton.isEnabled()) {
            	 System.out.println("");
            // Fill the sign-in fields with data from the file
            emailField.sendKeys(signInData[0]);
            passwordField.sendKeys(signInData[1]);
 
            // Click the sign-in button
            signInButton.click();
            } else {
                System.out.println("Sign-in button is not displayed ");
            }
 
        } catch (Exception e) {
            System.err.println("Error during sign-in: " + e.getMessage());
            e.printStackTrace();
        }
    }
	

}
