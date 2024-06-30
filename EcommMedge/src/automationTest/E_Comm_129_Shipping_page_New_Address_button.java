package automationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/*
E-Comm-129 : Shipping page_"New Address" button

Script Name         : E-Comm-129 : Shipping page_"New Address" button
'Purpose            : TC to verify the "+ New Address" button.
'Developed by       : Sibusiso Prince Phakathi
'Developed Date     : 12/06/24
'TestDataSheet      : signCredentials.txt
'Test LInk TestCase Path  : E-Commerce --> Test PLan --> E-Commerce Test Suite --> Checkout  --> E_Comm_111_:_E-Comm-129 : Shipping page_"New Address" button
*/

public class E_Comm_129_Shipping_page_New_Address_button {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        // Initialize WebDriver and WebDriverWait
        // Assuming Webdriver is your custom class managing WebDriver
        Webdriver webDriverManager = new Webdriver(); // Adjust as per your actual implementation
        driver = webDriverManager.getDriver();
        if (driver == null) {
            Screenshot.takeScreenshot(driver, "Driver initialization failed!.png");
            throw new RuntimeException("Driver initialization failed!");
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test (enabled = false)
    public void TC129() {
        try {
        	String filePath = "Prince/signCredentials.txt";
            SignIncredentials signInCredentials = new SignIncredentials(filePath);
            String[] creds = signInCredentials.getCredentials();

            String url = creds[0];
            String username = creds[1];
            String password = creds[2];
            
            Thread.sleep(1000);
            driver.get(url);

            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
            usernameField.sendKeys(username);

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass")));
            passwordField.sendKeys(password);

            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("send2")));
            loginButton.click();

            try {
                WebElement errorMessage = driver.findElement(By.cssSelector(".message-error"));
                if (errorMessage.isDisplayed()) {
                	Screenshot.takeScreenshot(driver, "Login failed.png");
                    System.err.println("Login failed: " + errorMessage.getText());
                    throw new RuntimeException("Login failed: " + errorMessage.getText());
                }
            } catch (NoSuchElementException ignored) {
                // No error message found, proceed to check URL
            }
            // Login process
            login();
            
            // Select product and add to cart
            selectProductAndAddToCart();
            Thread.sleep(1000);
            cartdisplay();
            Thread.sleep(1000);
            // Navigate to checkout
            navigateToCheckout();
            Thread.sleep(1000);
            // Click "+ New Address" button
            clickNewAddressButton();
            Thread.sleep(5000);
            // Verify fields and buttons on shipping address form
            verifyShippingAddressForm();
            Thread.sleep(5000);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    void login() throws InterruptedException {
        // Load credentials
    	

      
    }

    void selectProductAndAddToCart() {
        try {
            driver.findElement(By.xpath("//span[text()='Men']")).click();
            driver.findElement(By.linkText("Tops")).click();

            System.out.println("Selecting product...");
            WebElement productImage = driver.findElement(By.className("product-image-wrapper"));
            Actions actions = new Actions(driver);
            actions.moveToElement(productImage).click().build().perform();

            driver.findElement(By.id("option-label-size-143-item-167")).click();
            driver.findElement(By.id("option-label-color-93-item-50")).click();
            driver.findElement(By.id("product-addtocart-button")).click();
            driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a")).click();

            boolean itemAdded = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".message-success"))).isDisplayed();
            if (itemAdded) {
                System.out.println("Item added to cart successfully.");
                Screenshot.takeScreenshot(driver, "Item added to cart successfully.png");
            } else {
            	Screenshot.takeScreenshot(driver, "Failed to add item to cart.png");
                throw new RuntimeException("Failed to add item to cart.");
                
            }
        } catch (Exception e) {
        	Screenshot.takeScreenshot(driver, "An error occurred while selecting product or adding to cart.png");
            System.err.println("An error occurred while selecting product or adding to cart: " + e.getMessage());
        }
    }
    
    void cartdisplay()
    {
    	try {
    	driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a")).click();
    	}
    	catch (Exception e) {
    		
    	}
    }

    private void navigateToCheckout() {
        try {
            WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"top-cart-btn-checkout\"]")));
            checkoutButton.click();
        } catch (Exception e) {
        	Screenshot.takeScreenshot(driver, "An error occurred while navigating to checkout.png");
            System.err.println("An error occurred while navigating to checkout: " + e.getMessage());
        }
    }

    private void clickNewAddressButton() {
        try {
            WebElement newAddressButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"checkout-step-shipping\"]/div[2]/button/span")));
            newAddressButton.click();
        } catch (Exception e) {
            System.err.println("An error occurred while clicking 'New Address' button: " + e.getMessage());
        }
    }

    private void verifyShippingAddressForm() {
        try {
            checkFieldPresenceAndLabel("firstname", "First Name");
            checkFieldPresenceAndLabel("lastname", "Last Name");
            checkFieldPresenceAndLabel("company", "Company", false);
            checkFieldPresenceAndLabel("street[0]", "Street Address");
            checkFieldPresenceAndLabel("city", "City");
            checkFieldPresenceAndLabel("region_id", "State/Province (dropdown)");
            checkFieldPresenceAndLabel("postcode", "Zip/Postal Code");
            checkFieldPresenceAndLabel("country_id", "Country (dropdown)");
            checkFieldPresenceAndLabel("telephone", "Phone Number");

            // Verify 'Save in address book' checkbox
            WebElement saveInAddressBookCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"shipping-save-in-address-book\"]")));
            System.out.println("'Save in address book' checkbox is displayed: " + saveInAddressBookCheckbox.isDisplayed());

            // Verify 'Cancel' button
            WebElement cancelButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/aside[2]/div[2]/footer/button[2]/span")));
            System.out.println("'Cancel' button is displayed: " + cancelButton.isDisplayed());

            // Verify 'Ship Here' button
            WebElement shipHereButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/aside[2]/div[2]/footer/button[1]/span")));
            System.out.println("'Ship Here' button is displayed: " + shipHereButton.isDisplayed());

        } catch (Exception e) {
            System.err.println("An error occurred while verifying shipping address form: " + e.getMessage());
        }
    }

    private void checkFieldPresenceAndLabel(String fieldName, String expectedLabel) {
        checkFieldPresenceAndLabel(fieldName, expectedLabel, true);
    }

    private void checkFieldPresenceAndLabel(String fieldName, String expectedLabel, boolean isRequired) {
        try {
            WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(fieldName)));
            if (field != null && field.isDisplayed()) {
            	Screenshot.takeScreenshot(driver, "field is displayed.png");
                System.out.println("'" + expectedLabel + "' field is displayed.");
            } else {
                System.err.println("'" + expectedLabel + "' field is not displayed.");
                Screenshot.takeScreenshot(driver, "field is not displayed.png");
            }
        } catch (Exception e) {
        	Screenshot.takeScreenshot(driver, "An error occurred while checking field.png");
            System.err.println("An error occurred while checking field '" + expectedLabel + "': " + e.getMessage());
        }
    }
}
