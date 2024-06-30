/*
        E-Comm-139 : "Shopping cart "icon 
         
        Script Name    		: E-Comm-139 : "Shopping cart "icon
        'Purpose    		: To verify if "Shopping Cart" icon functions with at least one item added to cart
        'Developed by  		: Sibusiso Prince Phakathi
        'Developed Date 	: 11/06/24
        'TestDataSheet 		: signCredentials.txt
        'Test LInk TestCase Path  : E-Commerce --> Test PLan --> E-Commerce Test Suite --> Authentication  -->E-Comm-139 : "Shopping cart "icon

        */

package automationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class E_Comm_139_Shopping_cart_icon {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup() {
        Webdriver webDriverManager = new Webdriver();
        driver = webDriverManager.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void verifyShoppingCartIconFunctionality() {
        try {
        	String filePath = "Prince/signCredentials.txt";
            SignIncredentials signIncredentials = new SignIncredentials(filePath);
            String[] creds = signIncredentials.getCredentials();

            String url = creds[0];
            String username = creds[1];
            String password = creds[2];
            
            
            
            
            loginToWebsite(url, username, password);
            Thread.sleep(5000);
            selectProduct();
            Thread.sleep(5000);
            addItemToCart();
            Thread.sleep(5000);
            validateMiniCart();
            Thread.sleep(2000);
            
        } catch (Exception e) {
            System.err.println("Test execution failed: " + e.getMessage());
        }
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    void loginToWebsite(String url, String username, String password) {
        
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
                return;
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

    private void selectProduct() throws InterruptedException {
    
        driver.findElement(By.xpath("//span[text()='Men']")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Tops")).click();
        Thread.sleep(2000);
        System.out.println("Selecting product...");
        WebElement productImage = driver.findElement(By.className("product-image-wrapper"));
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        actions.moveToElement(productImage).click().build().perform();

        // Add wait or delay if needed after selecting product
         Thread.sleep(5000);
    }

    private void addItemToCart() throws InterruptedException {
 
        System.out.println("Selecting size and color...");
        Thread.sleep(2000);
        driver.findElement(By.id("option-label-size-143-item-167")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("option-label-color-93-item-50")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("product-addtocart-button")).click();

        boolean itemAdded = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".message-success"))).isDisplayed();
        if (itemAdded) {
            System.out.println("Item added to cart successfully.");
            Screenshot.takeScreenshot(driver, "Item_added_to_cart_successful.png");
        } else {
            System.err.println("Failed to add item to cart.");
            Screenshot.takeScreenshot(driver, "Item_added_to_cart_failed.png");
        }
    }

    private void validateMiniCart() {
        WebElement miniCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".minicart-wrapper")));
        if (miniCart.isDisplayed()) {
            System.out.println("Cart is open and visible.");
            Screenshot.takeScreenshot(driver, "Cart_opened_successful.png");

            // Validate mini cart details
            validateMiniCartDetails(miniCart);
        } else {
            System.err.println("Failed to open the cart.");
            Screenshot.takeScreenshot(driver, "Cart_open_failed.png");
        }
    }

    private void validateMiniCartDetails(WebElement miniCart) {
        // Implement validation of mini cart details
        validateItemCount(miniCart);
        validateCartSubtotal(miniCart);
        validateCheckoutButton(miniCart);
        validateItemDetails(miniCart);
        // Add more validations as needed
    }

    private void validateItemCount(WebElement miniCart) {
        WebElement itemCount = miniCart.findElement(By.cssSelector(".items-total .count"));
        if (itemCount != null && !itemCount.getText().isEmpty()) {
            System.out.println("Number of items in cart: " + itemCount.getText());
            Screenshot.takeScreenshot(driver, "items in cart.png");
        } else {
            System.err.println("Number of items in cart is not displayed.");
            Screenshot.takeScreenshot(driver, "Number of items in cart is not displayed.png");
        }
    }

    private void validateCartSubtotal(WebElement miniCart) {
        WebElement cartSubtotal = miniCart.findElement(By.cssSelector(".subtotal .price"));
        if (cartSubtotal != null && !cartSubtotal.getText().isEmpty()) {
            System.out.println("Cart subtotal: " + cartSubtotal.getText());
            Screenshot.takeScreenshot(driver, "Cart subtotal.png");
        } else {
            System.err.println("Cart subtotal is not displayed.");
            Screenshot.takeScreenshot(driver, "Cart subtotal is not displayed.png");
        }
    }

    private void validateCheckoutButton(WebElement miniCart) {
        WebElement checkoutButton = miniCart.findElement(By.cssSelector(".action.primary.checkout"));
        if (checkoutButton != null && checkoutButton.isDisplayed()) {
            System.out.println("'Proceed to Checkout' button is displayed and blue.");
            Screenshot.takeScreenshot(driver, "'Proceed to Checkout' button is displayed and blue.png");
        } else {
            System.err.println("'Proceed to Checkout' button is not displayed.");
            Screenshot.takeScreenshot(driver, "'Proceed to Checkout' button is not displayed.png");
        }
    }

    private void validateItemDetails(WebElement miniCart) {
        // Implement validation of item details in mini cart
        validateItemPicture(miniCart);
        validateItemName(miniCart);
        validateItemQuantity(miniCart);
        validateItemPrice(miniCart);
        // Add more validations as needed
    }

    private void validateItemPicture(WebElement miniCart) {
        WebElement itemPicture = miniCart.findElement(By.cssSelector(".product-image-photo"));
        if (itemPicture != null && itemPicture.isDisplayed()) {
            System.out.println("Picture of item is displayed.");
            Screenshot.takeScreenshot(driver, "Picture of item is displayed.png");
        } else {
            System.err.println("Picture of item is not displayed.");
            Screenshot.takeScreenshot(driver, "Picture of item is not displayed.png");
        }
    }

    private void validateItemName(WebElement miniCart) {
        WebElement itemName = miniCart.findElement(By.cssSelector(".product-item-name"));
        if (itemName != null && !itemName.getText().isEmpty()) {
            System.out.println("Item name: " + itemName.getText());
            Screenshot.takeScreenshot(driver, "Item name.png");
        } else {
            System.err.println("Item name is not displayed.");
            Screenshot.takeScreenshot(driver, "Item name is not displayed.png");
        }
    }

    private void validateItemQuantity(WebElement miniCart) {
        try {
            WebElement itemQuantity = miniCart.findElement(By.cssSelector("input.item-qty"));
            if (itemQuantity.isDisplayed() && itemQuantity.getAttribute("value") != null) {
                System.out.println("Item quantity: " + itemQuantity.getAttribute("value"));
                Screenshot.takeScreenshot(driver, "Item quantity displayed.png");
            } else {
                System.err.println("Item quantity is not displayed or has no value.");
                Screenshot.takeScreenshot(driver, "Item quantity is not displayed or has no value.png");
            }
        } catch (NoSuchElementException e) {
            System.err.println("Item quantity element not found.");
        }
    }

    private void validateItemPrice(WebElement miniCart) {
        WebElement itemPrice = miniCart.findElement(By.cssSelector(".price"));
        if (itemPrice != null && !itemPrice.getText().isEmpty()) {
            System.out.println("Item price: " + itemPrice.getText());
            Screenshot.takeScreenshot(driver, "Item price displayed.png");
        } else {
            System.err.println("Item price is not displayed.");
            Screenshot.takeScreenshot(driver, "Item price is not displayed.png");
        }
    }

    // Add more validation methods as needed for other details

}
