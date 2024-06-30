
/*
 E_Comm_17_Navigate_to_website 
 
Script Name    		: E_Comm_17_Navigate_to_website
'Purpose    		: Navigating to Magento landing page test case
'Developed by  		: Thabo Mazibuko
'Developed Date 	: 09/06/2024
'TestDataSheet 		: link.txt
'Test LInk TestCase Path  :  E-Commerce --> E-Commerce Test Suite --> Test Suite : Authentication   --> E-Comm-17
 */
package scripts;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

//script to open website
public class E_Comm_3_Navigate_to_website {
	
	@Test
	public void TC3() {
		//String  strChrome = readData.readBrowserFromFile();
		 WebDriver  driver = new ChromeDriver();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	  	  try {
			navigateToWebsite(driver,wait);
			driver.quit();
		} catch (InterruptedException e) {
			e.printStackTrace();
			driver.quit();
		}
	        
	}
	
	/*!Function Name    : navigateToWebsite 
	'!Purpose           : Script to open a website and verify the availability of elements
	'!Input Parameters    : 
                   		- driver: WebDriver input representing the web browser session.
                    	- By: Class representing mechanisms to locate elements within a document.
                      	- Variables: Class containing variables used to locate elements on the webpage.
                     	- WebElement: Interface representing an HTML element.
                      	- Actions: Class representing high-level interactions with the browser.
                      	- NoSuchElementException: Exception thrown when an element is not found on the webpage.
                      	- Thread: Class providing static methods to interact with threads.
              	       	- ScreenshotAction: Class containing methods to capture screenshots.
	'!Output            : fuction Navigates to the website when called
	'!Developed By      : Thabo Mazibuko
	'!Date              : 09/06/2024
	*/
	
    public static void navigateToWebsite(WebDriver driver,WebDriverWait wait) throws InterruptedException {
       
        // Assigning a URL from the object to a new URL in this class
        String url = Variables.URL(driver);
        
        try {
            // Access the website
            driver.get(url);
            // Maximizing the browser window to fill the whole screen
            driver.manage().window().maximize();
            // Pause execution for 2 seconds to allow any necessary actions
            Thread.sleep(1500);
            // Validate if the website is open
            // Locate the "What's New" section that gets displayed only when you navigate to the website
            WebElement whatsNewSection = wait.until(ExpectedConditions.visibilityOfElementLocated(Variables.whatsNewSection));

            // Check if the unique section is displayed on the webpage
            if (whatsNewSection.isDisplayed()) {
            	System.out.println("Verifying step 1");
                // Print message indicating successful opening of the website
                System.out.println("Landing page opens successfully.");
                
                System.out.println("Verifying step 2");
                // Locate and verify the header
                /*WebElement header = wait.until(ExpectedConditions.presenceOfElementLocated(Variables.header));
                if (header.isDisplayed()) {
                    System.out.println("Header_LUMA_Menu bar_Search icon and cart icon are displayed successfully");
                 // Capture screenshot of the webpage with the message "Header successfully."
                    ScreenshotAction.Screenshot(driver, "Header_LUMA_Menu bar_Search icon and cart icon are displayed successfully");
                } else {
                    System.out.println("Header_LUMA_Menu bar_Search icon and cart icon Failed to display");
                 // Capture screenshot of the webpage with the message "Header not opened successfully."
                    ScreenshotAction.Screenshot(driver, "Header_LUMA_Menu bar_Search icon and cart icon Failed to display");
                    driver.quit();
                }

                // Locate and verify the LUMA logo
                WebElement lumaLogo = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("logo")));

                if (lumaLogo.isDisplayed()) {
                    System.out.println("LUMA logo is displayed successfully.");
                    ScreenshotAction.Screenshot(driver, "logo is displayed successfully.");
                } else {
                    System.out.println("LUMA logo failed to display");
                    ScreenshotAction.Screenshot(driver, "logo failed to be displayed");
                    driver.quit();
                }

                // Wait for the menuBar element to be present
                WebElement menuBar = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("nav.navigation")));

                if (menuBar.isDisplayed()) {
                    System.out.println("Menu bar is displayed.");
                    ScreenshotAction.Screenshot(driver, "menu navigation displayed");
                } else {
                    System.out.println("Menu bar is NOT displayed. step 2 failed");
                    ScreenshotAction.Screenshot(driver, "menu navigation failed to be displayed");
                    driver.quit();
                }

                // Wait for the searchIcon element to be present
                WebElement searchIcon = wait.until(ExpectedConditions.presenceOfElementLocated(Variables.searchIcon));

                if (searchIcon.isDisplayed()) {
                    System.out.println("Search icon is displayed.");
                    ScreenshotAction.Screenshot(driver, "search icon is displayed");
                } else {
                    System.out.println("Search icon failed to be displayed.");
                    ScreenshotAction.Screenshot(driver, "search icon failed to be displayed");
                    driver.quit();
                }

                // Locate and verify the cart icon
                WebElement cartIcon = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a.action.showcart")));

                if (cartIcon.isDisplayed()) {
                    System.out.println("Cart icon is displayed successfully.");
                    ScreenshotAction.Screenshot(driver, "cart is displayed successfully");
                } else {
                    System.out.println("Cart icon failed to be displayed.");
                    ScreenshotAction.Screenshot(driver, "cart failed to be displayed");
                    driver.quit();
                }

                System.out.println("Verifying step 3");

                // Wait for the supportThisProjectLink element to be present
                WebElement supportThisProjectLink = wait.until(ExpectedConditions.presenceOfElementLocated(Variables.supportThisProjectLink));

                if (supportThisProjectLink.isDisplayed()) {
                    System.out.println("Support This Project link is displayed successfully.");
                    ScreenshotAction.Screenshot(driver, "Support This Project link is displayed successfully");
                } else {
                    System.out.println("Support This Project link is failed to be displayed.");
                    ScreenshotAction.Screenshot(driver, "Support This Project link failed to be displayed.");
                }

                // Wait for the signInLink element to be present
                WebElement signInLink = wait.until(ExpectedConditions.presenceOfElementLocated(Variables.signInLink));

                if (signInLink.isDisplayed()) {
                    System.out.println("Sign In link is displayed successfully.");
                    ScreenshotAction.Screenshot(driver, "Sign In link is displayed successfully.");
                } else {
                    System.out.println("Sign In link failed to be displayed.");
                    ScreenshotAction.Screenshot(driver, "Sign In link failed to be displayed.");
                }

                // Wait for the createAnAccountLink element to be present
                WebElement createAnAccountLink = wait.until(ExpectedConditions.presenceOfElementLocated(Variables.createAnAccountLink));

                if (createAnAccountLink.isDisplayed()) {
                    System.out.println("Create An Account link is displayed successfully.");
                    ScreenshotAction.Screenshot(driver, "Create An Account link is displayed successfully.");
                } else {
                    System.out.println("Create An Account link failed to be displayed.");
                    ScreenshotAction.Screenshot(driver, "Create An Account link failed to be displayed");
                }
                System.out.println("Verifying step 4");
                // Locate and verify the 'What's New' tab
                WebElement whatsNewTab = wait.until(ExpectedConditions.presenceOfElementLocated(Variables.whatsNewTab));

                if (whatsNewTab.isDisplayed()) {
                    System.out.println("What's New link is displayed successfully.");
                    ScreenshotAction.Screenshot(driver, "What's New link is displayed successfully");
                } else {
                    System.out.println("What's New link failed to be displayed.");
                    ScreenshotAction.Screenshot(driver, "What's New link failed to be displayed");
                    driver.quit();
                }

                // Wait for the womenTab element to be present
                WebElement womenTab = wait.until(ExpectedConditions.presenceOfElementLocated(Variables.womenTab));

                if (womenTab.isDisplayed()) {
                    System.out.println("Women link is displayed successfully.");
                    ScreenshotAction.Screenshot(driver, "Women link is displayed successfully");
                } else {
                    System.out.println("Women link failed to be displayed.");
                    ScreenshotAction.Screenshot(driver, "Women link failed to be displayed");
                    driver.quit();
                }

                // Wait for the menTab element to be present
                WebElement menTab = wait.until(ExpectedConditions.presenceOfElementLocated(Variables.menTab));

                if (menTab.isDisplayed()) {
                    System.out.println("Men link is displayed successfully.");
                    ScreenshotAction.Screenshot(driver, "Men link is displayed successfully");
                } else {
                    System.out.println("Men link failed to be displayed.");
                    ScreenshotAction.Screenshot(driver, "Men link failed to be displayed");
                    driver.quit();
                }

                // Wait for the gearTab element to be present
                WebElement gearTab = wait.until(ExpectedConditions.presenceOfElementLocated(Variables.gearTab));

                if (gearTab.isDisplayed()) {
                    System.out.println("Gear link is displayed successfully.");
                    ScreenshotAction.Screenshot(driver, "Gear link is displayed successfully");
                } else {
                    System.out.println("Gear link failed to be displayed.");
                    ScreenshotAction.Screenshot(driver, "Gear link failed to be displayed");
                    driver.quit();
                }

                // Locate and verify the 'Training' tab
                WebElement trainingTab = wait.until(ExpectedConditions.presenceOfElementLocated(Variables.trainingTab));

                if (trainingTab.isDisplayed()) {
                    System.out.println("Training link is displayed successfully.");
                    ScreenshotAction.Screenshot(driver, "Training link is displayed successfully");
                } else {
                    System.out.println("Training link failed to be displayed.");
                    ScreenshotAction.Screenshot(driver, "Training link failed to be displayed");
                    driver.quit();
                }

                // Wait for the saleTab element to be present
                WebElement saleTab = wait.until(ExpectedConditions.presenceOfElementLocated(Variables.saleTab));

                if (saleTab.isDisplayed()) {
                    System.out.println("Sale link is displayed successfully.");
                    ScreenshotAction.Screenshot(driver, "Sale is displayed successfully.");
                } else {
                    System.out.println("Sale link failed to be displayed.");
                    ScreenshotAction.Screenshot(driver, "Sale link failed to be displayed");
                    driver.quit();
                }

                System.out.println("Verifying step 6");

                // Wait for the hoodiesAndSweatshirtsLink element to be present
                WebElement hoodiesAndSweatshirtsLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Hoodies & Sweatshirts")));

                if (hoodiesAndSweatshirtsLink.isDisplayed()) {
                    System.out.println("'Hoodies & Sweatshirts' link in the 'New in Women's' section is displayed successfully.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "'Hoodies & Sweatshirts' link in the 'New in Women's' section is displayed successfully.");
                } else {
                    System.out.println("'Hoodies & Sweatshirts' link in the 'New in Women's' section failed to be displayed.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "'Hoodies & Sweatshirts' link in the 'New in Women's' section failed to be displayed");
                    // Quit browser
                    driver.quit();
                }

                // Wait for the jacketsLink element to be present
                WebElement jacketsLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Jackets")));

                if (jacketsLink.isDisplayed()) {
                    System.out.println("'Jackets' link in the 'New in Women's' section is displayed successfully.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "'Jackets' link in the 'New in Women's' section is displayed successfully.");
                } else {
                    System.out.println("'Jackets' link in the 'New in Women's' section failed to be displayed.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "'Jackets' link in the 'New in Women's' section failed to be displayed");
                    // Quit browser
                    driver.quit();
                }

                // Wait for the teesLink element to be present
                WebElement teesLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Tees")));

                if (teesLink.isDisplayed()) {
                    System.out.println("'Tees' link in the 'New in Women's' section is displayed successfully.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "'Tees' link in the 'New in Women's' section is displayed successfully.");
                } else {
                    System.out.println("'Tees' link in the 'New in Women's' section failed to be displayed.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "'Tees' link in the 'New in Women's' section failed to be displayed");
                    // Quit browser
                    driver.quit();
                }

                // Wait for the brasAndTanksLink element to be present
                WebElement brasAndTanksLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Bras & Tanks")));

                if (brasAndTanksLink.isDisplayed()) {
                    System.out.println("'Bras & Tanks' link in the 'New in Women's' section is displayed successfully.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "'Bras & Tanks' link in the 'New in Women's' section is displayed successfully");
                } else {
                    System.out.println("'Bras & Tanks' link in the 'New in Women's' section failed to be displayed.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "'Bras & Tanks' link in the 'New in Women's' section failed to be displayed");
                    // Quit browser
                    driver.quit();
                }

                // Wait for the pantsLink element to be present
                WebElement pantsLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Pants")));

                if (pantsLink.isDisplayed()) {
                    System.out.println("'Pants' link in the 'New in Women's' section is displayed successfully.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "'Pants' link in the 'New in Women");
                } else {
                    System.out.println("'Pants' link in the 'New in Women's' section failed to be displayed.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "'Pants' link in the 'New in Women's' section failed to be displayed");
                    // Quit browser
                    driver.quit();
                }

                // Locate and verify the 'Shorts' link in the "New in Women's" section
                WebElement shortsLink = driver.findElement(By.linkText("Shorts"));
                if (shortsLink.isDisplayed()) {
                    System.out.println("'Shorts' link in the 'New in Women's' section is displayed successfully.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "'Shorts' link in the 'New in Women's' section is displayed successfully");
                } else {
                    System.out.println("'Shorts' link in the 'New in Women's' section failed to be displayed.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "'Shorts' link in the 'New in Women's' section failed to be displayed");
                    // Quit browser
                    driver.quit();
                }
                System.out.println("Verifying step 7");
                // Locate and verify the 'Hoodies & Sweatshirts' link in the "New in Men's" section
                WebElement mensHoodiesAndSweatshirtsLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Hoodies & Sweatshirts")));

                if (mensHoodiesAndSweatshirtsLink.isDisplayed()) {
                    System.out.println("'Hoodies & Sweatshirts' link in the 'New in Men's' section is displayed successfully.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "'Hoodies & Sweatshirts' link in the 'New in Men's' section is displayed successfully.");
                } else {
                    System.out.println("'Hoodies & Sweatshirts' link in the 'New in Men's' section failed to be displayed.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "'Hoodies & Sweatshirts' link in the 'New in Men's' section failed to be displayed");
                    // Quit browser
                    driver.quit();
                }

                // Wait for the mensJacketsLink element to be present
                WebElement mensJacketsLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Jackets")));

                if (mensJacketsLink.isDisplayed()) {
                    System.out.println("'Jackets' link in the 'New in Men's' section is displayed successfully.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "'Jackets' link in the 'New in Men's' section is displayed successfully");
                } else {
                    System.out.println("'Jackets' link in the 'New in Men's' section failed to be displayed.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "'Jackets' link in the 'New in Men's' section failed to be displayed");
                    // Quit browser
                    driver.quit();
                }

                // Wait for the mensTeesLink element to be present
                WebElement mensTeesLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Tees")));

                if (mensTeesLink.isDisplayed()) {
                    System.out.println("'Tees' link in the 'New in Men's' section is displayed successfully.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "'Tees' link in the 'New in Men's' section is displayed successfully");
                } else {
                    System.out.println("'Tees' link in the 'New in Men's' section failed to be displayed.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "'Tees' link in the 'New in Men's' section failed to be displayed");
                    // Quit browser
                    driver.quit();
                }

                // Wait for the mensTanksLink element to be present
                WebElement mensTanksLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Tanks")));

                if (mensTanksLink.isDisplayed()) {
                    System.out.println("'Tanks' link in the 'New in Men's' section is displayed successfully.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "'Tanks' link in the 'New in Men's' section is displayed successfully");
                } else {
                    System.out.println("'Tanks' link in the 'New in Men's' section failed to be displayed.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "'Tanks' link in the 'New in Men's' section failed to be displayed");
                    // Quit browser
                    driver.quit();
                }

                // Wait for the mensPantsLink element to be present
                WebElement mensPantsLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Pants")));

                if (mensPantsLink.isDisplayed()) {
                    System.out.println("'Pants' link in the 'New in Men's' section is displayed successfully.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "'Pants' link in the 'New in Men's' section is displayed successfully");
                } else {
                    System.out.println("'Pants' link in the 'New in Men's' section failed to be displayed.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "'Pants' link in the 'New in Men's' section failed to be displayed");
                    // Quit browser
                    driver.quit();
                }

                // Locate and verify the 'Shorts' link in the "New in Men's" section
                WebElement mensShortsLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Shorts")));

                if (mensShortsLink.isDisplayed()) {
                    System.out.println("'Shorts' link in the 'New in Men's' section is displayed successfully.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "'Shorts' link in the 'New in Men's' section is displayed successfully");
                } else {
                    System.out.println("'Shorts' link in the 'New in Men's' section failed to be displayed.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "'Shorts' link in the 'New in Men's' section failed to be displayed");
                    // Quit browser
                    driver.quit();
                }

                System.out.println("Verifying step 8");

                // Wait for the lumasLatestSection element to be present
                WebElement lumasLatestSection = wait.until(ExpectedConditions.presenceOfElementLocated(Variables.lumasLatestSection));
                Actions actions = new Actions(driver);
                actions.moveToElement(lumasLatestSection).perform();

                if (lumasLatestSection.isDisplayed()) {
                    System.out.println("'Just In Time For The New Season' section is displayed successfully.");
                    ScreenshotAction.Screenshot(driver, "Just in Time tittle displayed successfully");
                } else {
                    System.out.println("'Just In Time For The New Season' section failed to be displayed.");
                    ScreenshotAction.Screenshot(driver, "Just in Time tittle failed to be displayed");
                }

                // Wait for the productImage element to be present
                WebElement productImage = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".product-item-photo")));

                if (productImage.isDisplayed()) {
                    System.out.println("Product image under 'Luma's Latest' section is displayed successfully.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "Product image under 'Luma's Latest' section is displayed successfully");
                } else {
                    System.out.println("Product image under 'Luma's Latest' section failed to be displayed.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "Product image under 'Luma's Latest' section failed to be displayed");
                    // Quit browser
                    driver.quit();
                }

                // Wait for the productDescription element to be present
                WebElement productDescription = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".product-item-link")));

                if (productDescription.isDisplayed()) {
                    System.out.println("Product description under 'Luma's Latest' section is displayed successfully.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "Product description under 'Luma's Latest' section is displayed successfully");
                } else {
                    System.out.println("Product description under 'Luma's Latest' section failed to be displayed.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "Product description under 'Luma's Latest' section failed to be displayed");
                    // Quit browser
                    driver.quit();
                }

                // Verify product price under "Luma's Latest"
                WebElement productPrice = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".price")));

                if (productPrice.isDisplayed()) {
                    System.out.println("Product price under 'Luma's Latest' section is displayed successfully.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "Product price under 'Luma's Latest' section is displayed successfully.");
                } else {
                    System.out.println("Product price under 'Luma's Latest' section failed to be displayed.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "Product price under 'Luma's Latest' section failed to be displayed");
                    // Quit browser
                    driver.quit();
                }

                System.out.println("Verifying step 9");

                // Wait for the newLumaYogaDescription element to be present
                WebElement newLumaYogaDescription = wait.until(ExpectedConditions.presenceOfElementLocated(Variables.newLumaYogaDescription));

                if (newLumaYogaDescription.isDisplayed()) {
                    System.out.println("New Luma Yoga Collection description is displayed successfully.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "New Luma Yoga Collection description is displayed successfully");
                } else {
                    System.out.println("New Luma Yoga Collection description failed to be displayed.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "New Luma Yoga Collection description failed to be displayed");
                    // Quit browser
                    driver.quit();
                }

                // Wait for the shopNewYogaButton element to be present
                WebElement shopNewYogaButton = wait.until(ExpectedConditions.presenceOfElementLocated(Variables.shopNewYogaButton));

                if (shopNewYogaButton.isDisplayed()) {
                    System.out.println("Shop New Yoga button is displayed successfully.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "Shop New Yoga button is displayed successfully");
                } else {
                    System.out.println("Shop New Yoga button failed to be displayed.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "Shop New Yoga button failed to be displayed");
                    // Quit browser
                    driver.quit();
                }

                System.out.println("Verifying step 10");

                // Wait for the whateverDayBringsDescription element to be present
                WebElement whateverDayBringsDescription = wait.until(ExpectedConditions.presenceOfElementLocated(Variables.whateverDayBringsDescription));

                actions.moveToElement(whateverDayBringsDescription);
                actions.perform();

                if (whateverDayBringsDescription.isDisplayed()) {
                    System.out.println("Whatever day brings description is displayed successfully.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "Whatever day brings description is displayed successfully.");
                } else {
                    System.out.println("Whatever day brings description failed to be displayed.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "Whatever day brings description failed to be displayed");
                    // Quit browser
                    driver.quit();
                }

                WebElement performanceFabricsLink = wait.until(ExpectedConditions.presenceOfElementLocated(Variables.performanceFabricsLink));

                if (performanceFabricsLink.isDisplayed()) {
                    System.out.println("Performance fabrics link is displayed successfully.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "Performance fabrics link is displayed successfully");
                } else {
                    System.out.println("Performance fabrics link failed to be displayed.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "Performance fabrics link failed to be displayed");
                    // Quit browser
                    driver.quit();
                }

                System.out.println("Verifying step 11");

                // Wait for the senseOfRenewalDescription element to be present
                WebElement senseOfRenewalDescription = wait.until(ExpectedConditions.presenceOfElementLocated(Variables.senseOfRenewalDescription));

                if (senseOfRenewalDescription.isDisplayed()) {
                    System.out.println("A sense of renewal description is displayed successfully.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "A sense of renewal description is displayed successfully");
                } else {
                    System.out.println("A sense of renewal description failed to be displayed.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "A sense of renewal description failed to be displayed");
                    // Quit browser
                    driver.quit();
                }

                // Verify presence of "shop Eco friendly" text link
                WebElement shopEcoFriendlyLink = wait.until(ExpectedConditions.presenceOfElementLocated(Variables.shopEcoFriendlyLink));

                if (shopEcoFriendlyLink.isDisplayed()) {
                    System.out.println("Shop Eco friendly link is displayed successfully.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "Shop Eco friendly link is displayed successfully");
                } else {
                    System.out.println("Shop Eco friendly link failed to be displayed.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "Shop Eco friendly link failed to be displayed");
                    // Quit browser
                    driver.quit();
                }

                System.out.println("Verifying step 12");

                // Wait for the noteslink element to be present
                WebElement noteslink = wait.until(ExpectedConditions.presenceOfElementLocated(Variables.noteslink));

                actions.moveToElement(noteslink).build();

                if (noteslink.isDisplayed()) {
                    // Print message indicating that the link is displayed
                    System.out.println("notes link is displayed successfully.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "notes link is displayed successfully.");
                } else {
                    // Print message indicating that the link is not displayed
                    System.out.println("notes link failed to be displayed.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "notes link failed to be displayed");
                    // Quit driver
                    driver.quit();
                }
                WebElement APITestlink = wait.until(ExpectedConditions.presenceOfElementLocated(Variables.APITestlink));

                if (APITestlink.isDisplayed()) {
                    // Print message indicating that the link is displayed
                    System.out.println("APITestlink link is displayed successfully.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "APITestlink  link is displayed successfully");
                } else {
                    // Print message indicating that the link is not displayed
                    System.out.println("APITestlink  link failed to be displayed.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "APITestlink  link failed to be displayed");
                    // Quit driver
                    driver.quit();
                }

                // Wait for the WriteUslink element to be present
                WebElement WriteUslink = wait.until(ExpectedConditions.presenceOfElementLocated(Variables.WriteUslink));

                if (WriteUslink.isDisplayed()) {
                    // Print message indicating that the link is displayed
                    System.out.println("WriteUslink  link is displayed successfully.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "WriteUslink  link is displayed successfully");
                } else {
                    // Print message indicating that the link is not displayed
                    System.out.println("WriteUslink  link failed to be displayed.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "WriteUslink  link failed to be displayed");
                    // Quit driver
                    driver.quit();
                }
                WebElement OrderReturnlink = wait.until(ExpectedConditions.presenceOfElementLocated(Variables.OrderReturnlink));

                if (OrderReturnlink.isDisplayed()) {
                    // Print message indicating that the link is displayed
                    System.out.println("OrderReturnlink link is displayed successfully.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "OrderReturnlink   link is displayed successfully");
                } else {
                    // Print message indicating that the link is not displayed
                    System.out.println("OrderReturnlink  link failed to be displayed.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "OrderReturnlink link failed to be displayed");
                    // Quit driver
                    driver.quit();
                }

                // Wait for the SearchTermslink element to be present
                WebElement SearchTermslink = wait.until(ExpectedConditions.presenceOfElementLocated(Variables.SearchTermslink));

                if (SearchTermslink.isDisplayed()) {
                    // Print message indicating that the link is displayed
                    System.out.println("SearchTermslink  link is displayed successfully.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "SearchTermslink  link is displayed successfully");
                } else {
                    // Print message indicating that the link is not displayed
                    System.out.println("SearchTermslink  link failed to be displayed.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "SearchTermslink  link failed to be displayed");
                    // Quit driver
                    driver.quit();
                }*/
                // Pause execution for 2 seconds to allow any necessary actions
                Thread.sleep(1000);
                // Capture screenshot of the webpage with the message "Website opened successfully."
                ScreenshotAction.Screenshot(driver, "Website opened successfully.");
                
            }
        } catch (NoSuchElementException e) {
            // Print message indicating that the website did not open as expected
            System.out.println("Website did not open as expected. Element not found on the landing page.");
            // Close the WebDriver session
            driver.close();
        }
    }
}
		

