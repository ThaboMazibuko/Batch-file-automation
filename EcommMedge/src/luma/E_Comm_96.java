package luma;

/*
 * Script Title: To verify if '"Sign In" link 
 * Script Name: E_Comm_96_VerifysignInlink
 * Purpose: Verifies the sizes and colors available on the product page
 * Developed by: Mutshidzi
 * Developed Date: 12/06/24
 * TestDataSheet: 
 * Test Link TestCase Path: E-commerce---E-commerce test suite----Authentication-----E_Comm_96
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

/**
 * Script Title: To verify if '"Sign In" link
 * Script Name: E_Comm_96_VerifysignInlink
 * Purpose: Verifies the sizes and colors available on the product page
 * Developed by: Mutshidzi
 * Developed Date: 12/06/24
 * TestDataSheet:
 * Test Link TestCase Path: E-commerce---E-commerce test suite----Authentication-----E_Comm_96
 */

public class E_Comm_96 {

    WebDriver driver; // Declare a WebDriver variable to control the browser
    WebDriverWait wait; // Declare a WebDriverWait variable to handle explicit waits
    String url; // Declare a String variable to store the web page URL

    // Function Name  : VerifysignInlink
    // Purpose        : Verifies the sign in link
    // Input          : url
    // Output         : link should open
    // Developed By   : Mutshidzi
    // Date           : 12/06/24
@Test
    public void setUp() throws IOException {
        try {
            // File path to read URL and other data
            String filePath = "jeniffer/url.txt/";

            // Read details from the file
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                // Read details from the notepad
                url = br.readLine();
            } catch (IOException e) {
                System.err.println("Error reading data from file: " + e.getMessage());
                throw e;
            }

            // Ensure URL is read correctly
            if (url == null || url.isEmpty()) {
                throw new IOException("Failed to read URL from file");
            }

            // Initialize Chrome options
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized"); // Add an argument to start the browser maximized

            // Initialize the driver
            driver = new ChromeDriver(options);

            // Initialize the wait object
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Navigate to the URL
            driver.get(url);
        } catch (Exception e) {
            e.printStackTrace();
           // tearDown();
            throw e;
        }
    }

    public void testSignInLink() {
        try {
            // Click on the "Sign In" link
            driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a")).click();

            // Wait for the Customer Login page to load
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-form")));

            // Verify the Email field is displayed
            WebElement emailField = driver.findElement(By.id("email"));
            if (emailField.isDisplayed()) {
                System.out.println("Email field is displayed");
                screenshot.takeScreenshot(driver, "email displayed_passed.png");
            } else {
                System.out.println("Email field is NOT displayed");
                screenshot.takeScreenshot(driver, "email displayed_failed.png");
            }

            // Verify the Password field is displayed
            WebElement passwordField = driver.findElement(By.id("pass"));
            if (passwordField.isDisplayed()) {
                System.out.println("Password field is displayed");
                screenshot.takeScreenshot(driver, "password displayed_passed.png");
            } else {
                System.out.println("Password field is NOT displayed");
                screenshot.takeScreenshot(driver, "password displayed_failed.png");
            }

            // Verify the Sign In button is displayed and has the correct color
            WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"send2\"]/span"));
            if (signInButton.isDisplayed()) {
                System.out.println("Sign In button is displayed");
                screenshot.takeScreenshot(driver, "sign in displayed_passed.png");
            } else {
                System.out.println("Sign In button is NOT displayed");
                screenshot.takeScreenshot(driver, "sign in displayed_failed.png");
            }

            // Verify the "forgot your password" link is displayed
            WebElement forgotPasswordLink = driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/div[4]/div[2]/a/span"));
            if (forgotPasswordLink.isDisplayed()) {
                System.out.println("Forgot your password link is displayed");
                screenshot.takeScreenshot(driver, "forgot password displayed_passed.png");
            } else {
                System.out.println("Forgot your password link is NOT displayed");
                screenshot.takeScreenshot(driver, "forgot password displayed_failed.png");
            }
        } catch (Exception e) {
            e.printStackTrace();
           // tearDown();
        }
    }
    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }

    public static void main(String[] args) {
        E_Comm_96 test = new E_Comm_96();
        try {
            test.setUp();
            test.testSignInLink();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            test.tearDown();
        }
    }
}
