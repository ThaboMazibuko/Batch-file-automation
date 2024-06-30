
/*
E-Comm-129 : Shipping page_"New Address" button

Script Name         : E_Comm_111_Sign_In_Link_Customer_Login_page_Create_An_Account_Button
'Purpose            : TC to verify the "Create an Account" button.
'Developed by       : Sibusiso Prince Phakathi
'Developed Date     : 12/06/24
'TestDataSheet      : signCredentials.txt
'Test LInk TestCase Path  : E-Commerce --> Test PLan --> E-Commerce Test Suite --> Authentication  --> E_Comm_111_Sign_In_Link_Customer_Login_page_Create_An_Account_Button
*/


package automationTest;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class E_Comm_111_Sign_In_Link_Customer_Login_page_Create_An_Account_Button {

    private WebDriver driver;
    private WebDriverWait wait;
    private Webdriver webDriverManager;

    @BeforeMethod
    public void setUp() {
        // Initialize the WebDriver instance using the Webdriver class
        webDriverManager = new Webdriver();
        driver = webDriverManager.getDriver();  // Ensure driver is initialized here
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));  // Initialize WebDriverWait with the driver
    }

    @AfterMethod
    public void tearDown() {
        // Properly quit the driver using the WebDriver manager
        if (webDriverManager != null) {
            webDriverManager.quitDriver();
        }
    }

    @Test (enabled = false)
    public void TC111() {
        try {
            // Load credentials
            String filePath = "Prince/signCredentials.txt";
            SignIncredentials signInCredentials = new SignIncredentials(filePath);
            String[] creds = signInCredentials.getCredentials();

            String url = creds[0];

            // Navigate to the URL
            driver.get(url);

            // Navigate and verify Create Account page
            navigateAndVerifyCreateAccountPage();

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    public void clickSignIn() {
        try {
            // Wait for and click the 'Sign In' button
            WebElement signInButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a")));
            signInButton.click();
            System.out.println("Clicked on 'Sign In' button.");
            Screenshot.takeScreenshot(driver, "Clicked on 'Sign In' button.png");
        } catch (Exception e) {
            System.err.println("Failed to click 'Sign In' button: " + e.getMessage());
            Screenshot.takeScreenshot(driver, "Failed to click 'Sign In' button.png");
        }
    }

    public void clickCreateAccount() {
        try {
            // Wait for and click the 'Create an Account' button
            WebElement createAccountButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[2]/div[2]/div/div/a")));
            createAccountButton.click();
            System.out.println("Clicked on 'Create an Account' button.");
            Screenshot.takeScreenshot(driver, "Clicked on 'Create an Account' button.png");
        } catch (Exception e) {
            System.err.println("Failed to click 'Create an Account' button: " + e.getMessage());
            Screenshot.takeScreenshot(driver, "Failed to click 'Create an Account' button.png");
        }
    }

    public void navigateAndVerifyCreateAccountPage() {
        clickSignIn();
        clickCreateAccount();

        // Verify if the "Create New Customer Account" page is displayed
        if (isCreateAccountPageDisplayed()) {
            System.out.println("The 'Create New Customer Account' page is displayed.");
            Screenshot.takeScreenshot(driver, "The 'Create New Customer Account' page is displayed.png");
        } else {
            System.err.println("The 'Create New Customer Account' page is NOT displayed.");
            Screenshot.takeScreenshot(driver, "The 'Create New Customer Account' page is NOT displayed.png");
        }
    }

    private boolean isCreateAccountPageDisplayed() {
        try {
            // Check if the page title matches "Create New Customer Account"
            WebElement createAccountHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.page-title span")));
            boolean isDisplayed = "Create New Customer Account".equals(createAccountHeader.getText());
            System.out.println("Page title: " + createAccountHeader.getText());
            return isDisplayed;
        } catch (Exception e) {
            System.err.println("Error while verifying 'Create New Customer Account' page: " + e.getMessage());
            Screenshot.takeScreenshot(driver, "Error while verifying 'Create New Customer Account' page.png");
            return false;
        }
    }
}
