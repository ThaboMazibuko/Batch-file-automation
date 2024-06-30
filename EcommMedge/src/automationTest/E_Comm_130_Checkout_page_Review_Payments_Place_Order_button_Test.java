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

Script Name         : E-Comm-129 : _Checkout_page_Review_Payments_Place_Order_button_Test
'Purpose            : TC to verify the on the checkout page, place order button.
'Developed by       : Sibusiso Prince Phakathi
'Developed Date     : 12/06/24
'TestDataSheet      : signCredentials.txt
'Test Link TestCase Path  : E-Commerce --> Test Plan --> E-Commerce Test Suite --> Checkout  --> E_Comm_130_Checkout_page_Review_Payments_Place_Order_button_Test
*/

public class E_Comm_130_Checkout_page_Review_Payments_Place_Order_button_Test {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        // Initialize WebDriver and WebDriverWait
        Webdriver webDriverManager = new Webdriver(); // Adjust as per your actual implementation
        driver = webDriverManager.getDriver();
        if (driver == null) {
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

    @Test
    public void TC129() {
        try {
            String filePath = "Prince/signCredentials.txt";
            SignIncredentials signInCredentials = new SignIncredentials(filePath);
            String[] creds = signInCredentials.getCredentials();

            String url = creds[0];
            String username = creds[1];
            String password = creds[2];

            loginToWebsite(url, username, password);

            // Select product and add to cart
            selectProductAndAddToCart();
            Thread.sleep(1000);

            // Display cart
            displayCart();
            Thread.sleep(1000);

            // Navigate to checkout
            navigateToCheckout();
            Thread.sleep(1000);
          
            
            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button/span")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button/span")).click();
          
          
            Thread.sleep(5000);

            // Verify order confirmation (you can replace with actual expected message)
            verifyOrderConfirmation("Thank you for your purchase!");

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    public void loginToWebsite(String url, String username, String password) {
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
                System.err.println("Login failed: " + errorMessage.getText());
                throw new RuntimeException("Login failed: " + errorMessage.getText());
            }
        } catch (NoSuchElementException ignored) {
            // No error message found, proceed to check URL
        }

        boolean loggedIn = wait.until(ExpectedConditions.urlContains("https://magento.softwaretestingboard.com/"));
        if (loggedIn) {
            System.out.println("Login successful.");
            Screenshot.takeScreenshot(driver, "verifylogin_passed.png");
        } else {
            System.err.println("Login failed.");
            Screenshot.takeScreenshot(driver, "verifylogin_failed.png");
            System.err.println("Current URL: " + driver.getCurrentUrl());
        }
    }

    private void selectProductAndAddToCart() {
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

            boolean itemAdded = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".message-success"))).isDisplayed();
            if (itemAdded) {
                System.out.println("Item added to cart successfully.");
                Screenshot.takeScreenshot(driver, "Item added to cart successfully.png");
                
            } else {
            	Screenshot.takeScreenshot(driver, "Failed to add item to cart.png");
                throw new RuntimeException("Failed to add item to cart.");
                
            }
        } catch (Exception e) {
            System.err.println("An error occurred while selecting product or adding to cart: " + e.getMessage());
        }
    }

    private void displayCart() {
        try {
            driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a")).click();
            Screenshot.takeScreenshot(driver, "displayCart.png");
        } catch (Exception e) {
        	Screenshot.takeScreenshot(driver, "An error occurred while displaying the cart.png");
            System.err.println("An error occurred while displaying the cart: " + e.getMessage());
        }
    }

    private void navigateToCheckout() {
        try {
            WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"top-cart-btn-checkout\"]")));
            checkoutButton.click();
            Screenshot.takeScreenshot(driver, "checkout button displayed.png");
        } catch (Exception e) {
        	Screenshot.takeScreenshot(driver, "An error occurred while navigating to checkout.png");
            System.err.println("An error occurred while navigating to checkout: " + e.getMessage());
        }
    }


    public void verifyOrderConfirmation(String expectedMessage) {
        try {
            // Wait for the confirmation message to be visible
            WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span")));

            // Extract the text of the confirmation message
            String actualMessage = confirmationMessage.getText();

            // Compare the actual message with the expected message
            if (actualMessage.contains(expectedMessage)) {
                System.out.println("Order confirmation message verified: " + actualMessage);
                Screenshot.takeScreenshot(driver, "Order confirmation message verified.png");
            } else {
                System.err.println("Order confirmation message does not match. Actual: " + actualMessage + ", Expected: " + expectedMessage);
                Screenshot.takeScreenshot(driver, "Order confirmation message does not match.png");
            }
        } catch (Exception e) {
            System.err.println("An error occurred while verifying the order confirmation message: " + e.getMessage());
        }
    }
}
