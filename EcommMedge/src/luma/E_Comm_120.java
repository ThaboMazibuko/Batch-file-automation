package luma;

/*
 * Script Title: E-Commerce Product Page Verification
 * Script Name: E_Comm_120_VerifyProductPageAttributes
 * Purpose: Verifies the sizes and colors available on the product page
 * Developed by: Mutshidzi
 * Developed Date: 12/06/24
 * TestDataSheet: 
 * Test Link TestCase Path: E-commerce---E-commerce test suite----checkout-----E_Comm_120
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class E_Comm_120 {
	// Function Name  : VerifyProductPageAttributes
	// Purpose        : Verifies the sizes and colors available on the product page
	// Input          : 
	// Output         : Prints verification results for sizes and colors
	// Developed By   : Mutshidzi
	// Date           : 12/06/24
    private WebDriver driver;
    private WebDriverWait wait;
    private final String filePath = "jeniffer/product page.txt/";

    @BeforeClass
    public void setUp() {
        // Set up ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        // Initialize the ChromeDriver
        driver = new ChromeDriver(options);

        // Initialize WebDriverWait with a 10-second timeout
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test (enabled = false)
    public void verifyProductPageAttributes() throws IOException {
        // Read URL from file
        String url1 = null;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            url1 = br.readLine();
        } catch (IOException e) {
            System.err.println("Error reading data from file: " + e.getMessage());
            return;
        }

        // Ensure URL is read correctly
        if (url1 == null || url1.isEmpty()) {
            System.err.println("Failed to read URL from file");
            return;
        }

        try {
            // Navigate to the URL
            driver.get(url1);

            // Expected sizes and colors
            List<String> expectedSizes = Arrays.asList("XS", "S", "M", "L", "XL");
            List<String> expectedColors = Arrays.asList("Black", "Gray", "Green");

            // Verify available sizes
            List<WebElement> sizeElements = driver.findElements(By.xpath("//div[@class='swatch-attribute size']//div[@role='option']"));
            System.out.println("Available sizes:");
            for (WebElement size : sizeElements) {
                System.out.println("Size: " + size.getAttribute("aria-label"));
            }

            // Verify available colors
            List<WebElement> colorElements = driver.findElements(By.xpath("//div[@class='swatch-attribute color']//div[@role='option']"));
            System.out.println("Available colors:");
            for (WebElement color : colorElements) {
                System.out.println("Color: " + color.getAttribute("aria-label"));
            }

            // Check sizes
            boolean allSizesDisplayed = expectedSizes.stream()
                    .allMatch(size -> sizeElements.stream().anyMatch(element -> element.getAttribute("aria-label").equals(size)));

            if (allSizesDisplayed) {
                System.out.println("All expected sizes are displayed.");
                screenshot.takeScreenshot(driver, "expected_sizes_passed.png");
            } else {
                System.out.println("Not all expected sizes are displayed.");
                screenshot.takeScreenshot(driver, "expected_sizes_failed.png");
            }

            // Check colors
            boolean allColorsDisplayed = expectedColors.stream()
                    .allMatch(color -> colorElements.stream().anyMatch(element -> element.getAttribute("aria-label").equals(color)));

            if (allColorsDisplayed) {
                System.out.println("All expected colors are displayed.");
                screenshot.takeScreenshot(driver, "expected_colors_passed.png");
            } else {
                System.out.println("Not all expected colors are displayed.");
                screenshot.takeScreenshot(driver, "expected_colors_failed.png");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
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
