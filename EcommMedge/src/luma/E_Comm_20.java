package luma;
/*
 * Script Title: E-Commerce Add to Cart Test
 * Script Name: E_Comm_20_AddToCartTest
 * Purpose: To verify the functionality of adding an item to the cart, 
 *          including checking the presence of size and color options and 
 *          validating the "You need to choose options for your item." message.
 * Developed by: Mutshidzi
 * Developed Date: 12/06/24
 * TestDataSheet: 
 * Test Link TestCase Path: E-commerce---E-commerce test suite----Authentication-----E_Comm_20
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
/**
 * Function Name: AddToCartTest
 * Purpose: This test case verifies the process of adding an item to the cart on an e-commerce website.
 * Input: WebDriver driver - Instance of the WebDriver to interact with the browser.
 * Output: True/False - Returns true on successful addition of item to the cart.
 * Developed By: Mutshidzi
 * Date: 12/06/24
 */
public class E_Comm_20 {

    private WebDriver driver;
    private WebDriverWait wait;
    private String filePath = "jeniffer/test case 20.txt";

    @BeforeClass
    public void setUp() {
        // Initialize the WebDriver (using EdgeDriver as an example)
        driver = new EdgeDriver();
        // Initialize WebDriverWait with a 10-second timeout
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        try {
            // Read URL from file
            String url = readUrlFromFile();
            if (url == null || url.isEmpty()) {
                throw new IllegalArgumentException("Invalid URL");
            }

            // Navigate to the URL
            driver.get(url);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read URL from file", e);
        }
    }

    @Test
    public void addToCart() throws InterruptedException {
        try {
            Actions actions = new Actions(driver); // Initialize Actions class for performing mouse hover actions

            driver.findElement(By.xpath("//span[text()='Men']")).click();
            driver.findElement(By.linkText("Tops")).click();
            WebElement button = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[10]/div[1]"));
            ScrollHelper.scrollToElement(driver, button);
            
            Thread.sleep(2000);
            
            // Step 2: Hover over an item image
            WebElement itemImage = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[5]/div/a/span/span/img")); // Locate item image element
            actions.moveToElement(itemImage).perform(); // Perform mouse hover action on item image
            Thread.sleep(2000);

            // Verify "Add to Cart" button is displayed
            WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[5]/div/div/div[3]/div/div[1]/form/button")); // Locate add to cart button element
            
            if (addToCartButton.isDisplayed()) {
                System.out.println("The 'Add to Cart' button is displayed on the item details");
                ScreenshotAction.Screenshot(driver, "Add to cart button_passed");
            } else {
                System.out.println("The 'Add to Cart' button is not displayed on the item details");
                ScreenshotAction.Screenshot(driver, "The 'Add to Cart' button is not displayed on the item details");
            }
            Thread.sleep(2000);
            // Step 3: Select and click a product to cart
            actions.moveToElement(addToCartButton).click().perform();// Click on add to cart button

            Thread.sleep(4000);
            // Verify message "You need to choose options for your item."
            WebElement message = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")); // Locate message element
            message.getText();
            if (message.getText().contains("You need to choose options for your item.")) {
                System.out.println("Message displayed: 'You need to choose options for your item.'");
                ScreenshotAction.Screenshot(driver, "Message displayed_passed");
            } else {
                System.out.println("Expected message not displayed");
                ScreenshotAction.Screenshot(driver, "Message displayed_failed");
            }
            Thread.sleep(4000);
            // Step 4: Hover to the size option
            WebElement sizeOption = driver.findElement(By.id("option-label-size-143")); // Locate size option element
            actions.moveToElement(sizeOption).perform(); // Perform mouse hover action on size option
          
            // Verify 5 size options are displayed
            int sizeOptionsCount = driver.findElements(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]/div")).size(); // Count size options
            if (sizeOptionsCount == 5) {
                System.out.println("5 size options are displayed (XS, S, M, L, XL)");
                ScreenshotAction.Screenshot(driver, "size options displayed_passed");
            } else {
                System.out.println("Expected 5 size options, but found " + sizeOptionsCount);
                ScreenshotAction.Screenshot(driver, "size options displayed_failed");
            }

            // Step 5: Hover to the color option
            WebElement colorOption = driver.findElement(By.id("option-label-color-93")); // Locate color option element
            actions.moveToElement(colorOption).perform(); // Perform mouse hover action on color option

            // Verify 3 color options are displayed
            int colorOptionsCount = driver.findElements(By.id("option-label-color-93-item-53")).size(); // Count color options
            if (colorOptionsCount == 3) {
                System.out.println("3 color options are displayed");
                ScreenshotAction.Screenshot(driver, "color options displayed_passed");
            } else {
                System.out.println("Expected 3 color options, but found " + colorOptionsCount);
                ScreenshotAction.Screenshot(driver, "color options displayed_failed");
            }

            WebElement addButtom = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
            ScrollHelper.scrollToElement(driver, addButtom);
            // Step 6: Click on "Add to Cart" button
            addButtom.click(); // Click on add to cart button
            
            // Verify item is added to the cart
            WebElement cartItem = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]")); // Locate cart item element
            if (cartItem.isDisplayed()) {
                System.out.println("Item is added to the cart");
                ScreenshotAction.Screenshot(driver, "item added_passed");
            } else {
                System.out.println("Item is not added to the cart");
                ScreenshotAction.Screenshot(driver, "item added_failed");
            }
           
            
        } finally {
            // Close the browser
            driver.quit();
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private String readUrlFromFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            return br.readLine(); // Assuming the URL is on the first line of the file
        }
    }

    public static void main(String[] args) {
        // TestNG will automatically invoke the tests defined in this class.
    }
}
