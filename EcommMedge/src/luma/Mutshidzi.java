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
/**
 * Function Name: E_Comm_105
 * Purpose: This test case automates the process of signing into an account on the e-commerce website.
 * Input: WebDriver driver - Instance of the WebDriver to interact with the browser.
 * Output: True/False - Returns true on successful sign-in.
 * Developed By: Mutshidzi
 * Date: 12/06/24
 */
public class Mutshidzi {

    // Method to read sign-in data from file
    public static String[] readSignInDataFromFile() {
        String filePath = "C:\\Users\\MutshidziMukwevho-LF\\OneDrive - Linkfields innovations\\Documents\\sign in.txt";
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

    // Method to sign in
    public void signIn(WebDriver driver) {
        try {
            // Read sign-in data from file
            String[] signInData = readSignInDataFromFile();
            if (signInData == null || signInData.length < 2) {
               // driver.quit();
                throw new IllegalArgumentException("Invalid sign-in data");
            }
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Click on Sign In link
            WebElement signIn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a")));
            signIn.click();

            // Verify the Customer Login page elements
            verifyElementDisplayed(wait, By.xpath("//*[@id=\"block-customer-login-heading\"]"), "Registered customers");
            verifyElementDisplayed(wait, By.xpath("//*[@id=\"login-form\"]/fieldset/div[2]/label/span"), "Email label");
            verifyElementDisplayed(wait, By.xpath("//*[@id=\"login-form\"]/fieldset/div[3]/label/span"), "Password label");
            WebElement signInButton = verifyElementDisplayed(wait, By.id("send2"), "Sign In button");
            verifyElementDisplayed(wait, By.linkText("Forgot Your Password?"), "Forgot your password? link");
            verifyElementDisplayed(wait, By.xpath("//*[@id=\"block-new-customer-heading\"]"), "New customers label");
            verifyElementDisplayed(wait, By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[2]/div[2]/div/div/a/span"), "Create An Account tab");

            // Locate sign-in fields
            WebElement emailField = verifyElementDisplayed(wait, By.id("email"), "Email field");
            WebElement passwordField = verifyElementDisplayed(wait, By.id("pass"), "Password field");

            if (signInButton.isDisplayed() && signInButton.isEnabled()) {
                System.out.println("Sign-in button is displayed and enabled");
                // Fill the sign-in fields with data from the file
                emailField.sendKeys(signInData[0]);
                Thread.sleep(2000);
                passwordField.sendKeys(signInData[1]);
                Thread.sleep(2000);

                // Click the sign-in button
                signInButton.click();
            } else {
                System.out.println("Sign-in button is not displayed or not enabled");
            }

            // Verify that "My Account" page is displayed with correct details
            verifyElementDisplayed(wait, By.xpath("//*[contains(text(),'Account Information')]"), "Account Information");
            verifyElementDisplayed(wait, By.xpath("//*[contains(text(),'Contact Information')]"), "Contact Information");
            verifyElementDisplayed(wait, By.xpath("//*[contains(text(),'Default Billing Address')]"), "Default Billing Address");
            verifyElementDisplayed(wait, By.xpath("//*[contains(text(),'Default Shipping Address')]"), "Default Shipping Address");
            verifyElementDisplayed(wait, By.xpath("//*[contains(text(),'Add to Cart')]"), "Add to Cart button");
            verifyElementDisplayed(wait, By.xpath("//*[contains(text(),'Recent Orders')]"), "Recent Orders list");

        } catch (Exception e) {
            System.err.println("Error during sign-in: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private WebElement verifyElementDisplayed(WebDriverWait wait, By locator, String elementName) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        if (element.isDisplayed()) {
            System.out.println(elementName + " is displayed");
        } else {
            System.out.println(elementName + " is not displayed");
        }
        return element;
    }

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        // Create an instance of E_Comm_64_Create_an_Account_link
       // E_Comm_64_Create_an_Account_link accountLink = new E_Comm_64_Create_an_Account_link(driver);

        // Create an instance of E_Comm_19_To_verify_Create_an_account_link
      //  E_Comm_19_To_verify_Create_an_account_link pageVerifier = new E_Comm_19_To_verify_Create_an_account_link();
        Mutshidzi eComm = new Mutshidzi();

        try {
            // Call the createAccount method from E_Comm_64_Create_an_Account_link
         //   accountLink.createAccount();

            // Call the verifyCreateAccountPage method from E_Comm_19_To_verify_Create_an_account_link
         //   E_Comm_19_To_verify_Create_an_account_link.verifyCreateAccountPage(driver);
            eComm.signIn(driver);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           // driver.quit();
        }
    }
}