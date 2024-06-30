package luma;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;
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
 * Script Title
 * Script Name: E_Comm_19_To_verify_Create_an_account_link
 * Purpose: Verifies the "Create New Customer Account" page for the given e-commerce website.
 * Developed by: Mutshidzi
 * Developed Date: 12/06/24
 * TestDataSheet: 
 * Test Link TestCase Path: E-commerce---E-commerce test suite----Authentication-----E_Comm_19 
 */

/**
 * Function Name: E_Comm_19_To_verify_Create_an_account_link
 * Purpose: Verifies the "Create New Customer Account" page for the given e-commerce website.
 * Input: WebDriver driver - The WebDriver instance used for the test.
 * Output: Verifies the presence and visibility of various elements on the "Create New Customer Account" page.
 * Developed By: [Mutshidzi]
 * Date: 12/06/24
 */
public class E_Comm_19_To_verify_Create_an_account_link {
	 /**
     * Function Name: verifyCreateAccountPage
     * Purpose: Verifies the "Create New Customer Account" page title and the visibility of sections and buttons on the page.
     * Input: WebDriver driver - The WebDriver instance used for the test.
     * Output: Prints the verification results of the page title, "Personal Information" section, "Sign In Information" section, and the "Create an Account" button.
     */
    private WebDriver driver;
    private WebDriverWait wait;
    private String filePath = "jeniffer/url.txt";

    @BeforeClass
    public void setUp() {
        // Set the path to your WebDriver executable if necessary
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void verifyCreateAccountPage() {
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

            
            // Verify "Create New Customer Account" page title
            try {
                String expectedTitle = "Create New Customer Account";
                String actualTitle = driver.getTitle();
                if (actualTitle.equals(expectedTitle)) {
                    System.out.println("Page title verification: Passed");
                    screenshot.takeScreenshot(driver, "page_title_passed.png");
                } else {
                    System.out.println("Page title verification: Failed");
                    screenshot.takeScreenshot(driver, "page_title_failed.png");
                }
            } catch (Exception e) {
                handleException(driver, e, "Failed to verify page title");
            }

            // Continue with other verification steps as per your original script...
            // Verify "Personal Information" section
            try {
                WebElement personalInfoSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstname")));
                if (personalInfoSection.isDisplayed()) {
                    System.out.println("Personal Information section verification: Passed");
                    screenshot.takeScreenshot(driver, "personal_info_passed.png");
                } else {
                    System.out.println("Personal Information section verification: Failed");
                    screenshot.takeScreenshot(driver, "personal_info_failed.png");
                }
            } catch (Exception e) {
                handleException(driver, e, "Failed to verify Personal Information section");
            }

            // Verify "Sign In Information" section
            try {
                WebElement signInInfoSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email_address")));
                if (signInInfoSection.isDisplayed()) {
                    System.out.println("Sign In Information section verification: Passed");
                    screenshot.takeScreenshot(driver, "sign_in_info_passed.png");
                } else {
                    System.out.println("Sign In Information section verification: Failed");
                    screenshot.takeScreenshot(driver, "sign_in_info_failed.png");
                }
            } catch (Exception e) {
                handleException(driver, e, "Failed to verify Sign In Information section");
            }

            // Verify "Create an Account" button
            try {
                WebElement createAccountButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span")));
                if (createAccountButton.isDisplayed() && createAccountButton.getText().equals("Create an Account")) {
                    System.out.println("Create an Account button is displayed");
                    screenshot.takeScreenshot(driver, "create_account_button_passed.png");
                } else {
                    System.out.println("Create an Account button is not displayed");
                    screenshot.takeScreenshot(driver, "create_account_button_failed.png");
                }
            } catch (Exception e) {
                handleException(driver, e, "Failed to verify Create an Account button");
            }

        } catch (Exception e) {
            handleException(driver, e, "Error during verification");
        }
    
        }
    

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private String[] readSignInDataFromFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String email = br.readLine();
            String password = br.readLine();
            return new String[]{email, password};
        }
    }

    private String readUrlFromFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            return br.readLine();
        }
    }

    private void handleException(WebDriver driver, Exception e, String errorMessage) {
        System.err.println(errorMessage + ": " + e.getMessage());
        e.printStackTrace();
        screenshot.takeScreenshot(driver, "error.png");
        driver.quit();
        throw new RuntimeException(errorMessage, e);
    }
}
