package luma;
/*
 * Script Title: E-Commerce Create Account Test
 * Script Name: E_Comm_64_Create_an_Account_link
 * Purpose: This test case automates the process of creating a new account on the e-commerce website.
 * Developed by: Mutshidzi
 * Developed Date: 12/06/24
 * TestDataSheet: 
 * Test Link TestCase Path:E-commerce---E-commerce test suite----Authentication-----E_Comm_64
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

public class E_Comm_64_Create_an_Account_link {

    private WebDriver driver;
    private WebDriverWait wait;
    private String filePath = "jeniffer/mutshidzi luma.txt";

    @BeforeClass
    public void setUp() {
        // Set the path to your WebDriver executable if necessary
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void createAccount() throws IOException, InterruptedException {
        try {
            // Read URL from file
            String url = readUrlFromFile();
            if (url == null || url.isEmpty()) {
                throw new IllegalArgumentException("Invalid URL");
            }

            // Navigate to the URL
            driver.get(url);

            // Read credentials from file
            String[] credentials = readCredentials(filePath, 6);

            // Locate and fill in form fields
            try {
                WebElement firstnameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstname")));
                firstnameField.sendKeys(credentials[1]);
                System.out.println("Successfully entered First Name: " + credentials[1]);
                screenshot.takeScreenshot(driver, "firstname_passed.png");
            } catch (Exception e) {
                handleException(driver, e, "Failed to find or fill First Name field");
            }

            // Repeat for other form fields (lastname, email_address, password, password-confirmation)
            try {
                WebElement lastnameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastname")));
                if (lastnameField != null) {
                    lastnameField.sendKeys(credentials[2]);
                    System.out.println("Successfully entered Last Name: " + credentials[2]);
                    screenshot.takeScreenshot(driver, "lastname_passed.png");
                } else {
                    System.out.println("Last Name field not found.");
                    screenshot.takeScreenshot(driver, "lastname_failed.png");
                    throw new Exception("Last Name field not found");
                }
            } catch (Exception e) {
                handleException(driver, e, "Failed to find or fill Last Name field");
            }

            try {
                WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email_address")));
                if (emailField != null) {
                    emailField.sendKeys(credentials[3]);
                    System.out.println("Successfully entered Email Address: " + credentials[3]);
                    screenshot.takeScreenshot(driver, "email_address_passed.png");
                } else {
                    System.out.println("Email Address field not found.");
                    screenshot.takeScreenshot(driver, "email_address_failed.png");
                    throw new Exception("Email Address field not found");
                }
            } catch (Exception e) {
                handleException(driver, e, "Failed to find or fill Email Address field");
            }

            try {
                WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
                if (passwordField != null) {
                    passwordField.sendKeys(credentials[4]);
                    System.out.println("Successfully entered Password");
                    screenshot.takeScreenshot(driver, "password_passed.png");
                } else {
                    System.out.println("Password field not found.");
                    screenshot.takeScreenshot(driver, "password_failed.png");
                    throw new Exception("Password field not found");
                }
            } catch (Exception e) {
                handleException(driver, e, "Failed to find or fill Password field");
            }

            try {
                WebElement confirmPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password-confirmation")));
                if (confirmPasswordField != null) {
                    confirmPasswordField.sendKeys(credentials[5]);
                    System.out.println("Successfully entered Confirm Password");
                    screenshot.takeScreenshot(driver, "confirm_password_passed.png");
                } else {
                    System.out.println("Confirm Password field not found.");
                    screenshot.takeScreenshot(driver, "confirm_password_failed.png");
                    throw new Exception("Confirm Password field not found");
                }
            } catch (Exception e) {
                handleException(driver, e, "Failed to find or fill Confirm Password field");
            }
            // Submit the form
            try {
                WebElement createAccountButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span")));
                createAccountButton.click();
                System.out.println("Successfully clicked on Create Account button.");
                screenshot.takeScreenshot(driver, "create_account_button_passed.png");
            } catch (Exception e) {
                handleException(driver, e, "Failed to find or click Create Account button");
            }

        } catch (Exception e) {
            handleException(driver, e, "Error during account creation");
        }
    }

    private String readUrlFromFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            return br.readLine(); // Assuming the URL is on the first line of the file
        }
    }

    private String[] readCredentials(String filePath, int numberOfCredentials) throws IOException {
        String[] credentials = new String[numberOfCredentials];
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null && index < numberOfCredentials) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    credentials[index++] = parts[1].trim();
                }
            }
        }
        return credentials;
    }

    private void handleException(WebDriver driver, Exception e, String errorMessage) {
        System.err.println(errorMessage + ": " + e.getMessage());
        e.printStackTrace();
        screenshot.takeScreenshot(driver, "error.png");
        driver.quit();
        throw new RuntimeException(errorMessage, e);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
