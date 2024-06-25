package scripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class E_Comm_20_To_verify_the_functionality_of_add_to_cart_button {

	public static void main(String[] args) throws InterruptedException {
	// Initialize ChromeDriver
	  WebDriver  driver = new ChromeDriver();
	  E_Comm_3_Navigate_to_website.navigateToWebsite(driver);
	  addToCartButton(driver);
    driver.quit();
	}

	public static void addToCartButton(WebDriver driver) {
    	try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            //registration data input screenshot
            Thread.sleep(1000);
            // Navigate to a category and click it 
            WebElement MenCategory = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Men")));
            MenCategory.click();
            Thread.sleep(1000);
            ScreenshotAction.Screenshot(driver,"MenSuccess");
            System.out.println("screenshot for men category, success!");
            WebElement TopsOption = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Tops")));
            TopsOption.click();
            Thread.sleep(1000);
            ScreenshotAction.Screenshot(driver,"TopsSuccess");
            System.out.println("screenshot for Tops link, success!");
            WebElement sizeDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"narrow-by-list\"]/div[3]/div[1]")));
            sizeDropdown.click();
            Thread.sleep(1000);
            ScreenshotAction.Screenshot(driver,"dropDownSuccess");
            System.out.println("screenshot for size dropwdown, success!");
            WebElement DropdownOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"narrow-by-list\"]/div[3]/div[2]/div/div/a[2]/div")));
            DropdownOption.click();
            Thread.sleep(1000);
            ScreenshotAction.Screenshot(driver,"dropdwonOptSuccess");
            System.out.println("screenshot for dropwdown option, success!");
            
            Thread.sleep(1000);
            // Scroll down to the price dropdown before clicking it
            WebElement colorDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"narrow-by-list\"]/div[4]/div[1]")));
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", colorDropdown);
            Thread.sleep(1000);
            ScreenshotAction.Screenshot(driver,"scrollSuccess");
            System.out.print("screenshot for men scroll success!");
            wait.until(ExpectedConditions.elementToBeClickable(colorDropdown));
            Thread.sleep(2000);
            colorDropdown.click();
            Thread.sleep(1000);
            ScreenshotAction.Screenshot(driver,"colorClickSuccess");
            System.out.println("color dropdown click, success!");
            WebElement colorOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"narrow-by-list\"]/div[4]/div[2]/div/div/a[4]/div")));
            colorOption.click();
            Thread.sleep(1000);
            ScreenshotAction.Screenshot(driver,"colorOptionSuccess");
            System.out.println("color option click, success!");

            Thread.sleep(2000);
            
            // Locate a specific product item
            WebElement productItem = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[5]/div/a/span/span/img")));
            Thread.sleep(1000);
            System.out.print("product found, success!");
            // Hover over the product item
            Actions actions = new Actions(driver);
            actions.moveToElement(productItem).perform();
            Thread.sleep(1000);
            ScreenshotAction.Screenshot(driver,"hoverOverSuccess");
            System.out.println("product hover over, success!");
            Thread.sleep(3000); 

            // Click the "Add to Cart" button
            WebElement addToCartButton = productItem.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[5]/div/div/div[4]/div/div[1]/form/button"));
            addToCartButton.click();
            Thread.sleep(1000);
            ScreenshotAction.Screenshot(driver,"addToCartSuccess");
            System.out.println("add to cart click, success!");
            
            
            

        } catch (Exception e) {
            System.err.println("Error adding to cart: " + e.getMessage());
            e.printStackTrace();
        }
    }
	
		

}
