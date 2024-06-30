package luma;

/*
 * Script Title: E-Commerce To verify if '"Sign In" link 
 * Script Name: E_Comm_105_Verifysignin link
 * Purpose: Verifies the signing into an account
 * Developed by: Mutshidzi
 * Developed Date: 12/06/24
 * TestDataSheet: 
 * Test Link TestCase Path: E-commerce---E-commerce test suite----Authentication-----E_Comm_105
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
/**
 * Function Name: E_Comm_105
 * Purpose: This test case automates the process of signing into an account on the e-commerce website.
 * Input: WebDriver driver - Instance of the WebDriver to interact with the browser.
 * Output: True/False - Returns true on successful sign-in.
 * Developed By: Mutshidzi
 * Date: 12/06/24
 */
public class E_Comm_105 {

    private WebDriver driver;
    private WebDriverWait wait;

    // Method to read sign-in data from file
    public static String[] readSignInDataFromFile() {
        String filePath = "jeniffer/sign in.txt";
        String[] signInData = new String[2];

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            for (int i = 0; i < 2; i++) {
                signInData[i] = br.readLine();
            }
        } catch (IOException e) {
            System.err.println("Error reading data from file: " + e.getMessage());
            e.printStackTrace();
        }

        return signInData;
    }

    // Method to read URL from file
    public static String readUrlFromFile() {
        String filePath = "jeniffer/url sign in.txt";
        String url = "";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            url = br.readLine();
        } catch (IOException e) {
            System.err.println("Error reading URL from file: " + e.getMessage());
            e.printStackTrace();
        }

        return url;
    }

    @BeforeClass
    public void setUp() {
        // Initialize the ChromeDriver
        driver = new ChromeDriver();
        // Initialize WebDriverWait with a 10-second timeout
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test (enabled = false)
    public void signIn() {
        try {
            // Read sign-in data from file
            String[] signInData = readSignInDataFromFile();
            if (signInData == null || signInData.length < 2) {
                throw new IllegalArgumentException("Invalid sign-in data");
            }

            // Read URL from file
            String url = readUrlFromFile();
            if (url == null || url.isEmpty()) {
                throw new IllegalArgumentException("Invalid URL");
            }

            // Navigate to the sign-in page
            driver.get(url);
            screenshot.takeScreenshot(driver, "navigate_to_signin_page_passed.png");

            // Click on Sign In link
            WebElement signIn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a")));
            signIn.click();
            screenshot.takeScreenshot(driver, "click_signin_link_passed.png");

            // Verify the Customer Login page elements
            verifyElementDisplayed(By.xpath("//*[@id=\"block-customer-login-heading\"]"), "Registered customers");
            verifyElementDisplayed(By.xpath("//*[@id=\"login-form\"]/fieldset/div[2]/label/span"), "Email label");
            verifyElementDisplayed(By.xpath("//*[@id=\"login-form\"]/fieldset/div[3]/label/span"), "Password label");
            WebElement signInButton = verifyElementDisplayed(By.id("send2"), "Sign In button");
            verifyElementDisplayed(By.linkText("Forgot Your Password?"), "Forgot your password? link");
            verifyElementDisplayed(By.xpath("//*[@id=\"block-new-customer-heading\"]"), "New customers label");
            verifyElementDisplayed(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[2]/div[2]/div/div/a/span"), "Create An Account tab");

            // Locate sign-in fields
            WebElement emailField = verifyElementDisplayed(By.id("email"), "Email field");
            WebElement passwordField = verifyElementDisplayed(By.id("pass"), "Password field");

            if (signInButton.isDisplayed() && signInButton.isEnabled()) {
                System.out.println("Sign-in button is displayed and enabled");
                screenshot.takeScreenshot(driver, "signin_button_displayed_enabled_passed.png");
                // Fill the sign-in fields with data from the file
                emailField.sendKeys(signInData[0]);
                Thread.sleep(2000);
                passwordField.sendKeys(signInData[1]);
                Thread.sleep(2000);
                screenshot.takeScreenshot(driver, "filled_signin_fields_passed.png");

                // Click the sign-in button
                signInButton.click();
                screenshot.takeScreenshot(driver, "click_signin_button_passed.png");
            } else {
                System.out.println("Sign-in button is not displayed or not enabled");
                screenshot.takeScreenshot(driver, "signin_button_not_displayed_failed.png");
            }

        } catch (Exception e) {
            System.err.println("Error during sign-in: " + e.getMessage());
            screenshot.takeScreenshot(driver, "signin_error_failed.png");
            e.printStackTrace();
        }
    }

    private WebElement verifyElementDisplayed(By locator, String elementName) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        if (element.isDisplayed()) {
            System.out.println(elementName + " is displayed");
            screenshot.takeScreenshot(driver, elementName.replace(" ", "_").toLowerCase() + "_displayed_passed.png");
        } else {
            System.out.println(elementName + " is not displayed");
            screenshot.takeScreenshot(driver, elementName.replace(" ", "_").toLowerCase() + "_not_displayed_failed.png");
        }
        return element;
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void main(String[] args) {
        // TestNG will automatically invoke the tests defined in this class.
    }
}
