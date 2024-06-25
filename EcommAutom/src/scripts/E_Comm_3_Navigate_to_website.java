
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

import java.util.NoSuchElementException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

//script to open website
public class E_Comm_3_Navigate_to_website {
	public static void main(String[] args) throws InterruptedException {
		 // Initialize ChromeDriver
  	  WebDriver  driver = new ChromeDriver();
  	  navigateToWebsite(driver);
        driver.quit();
	}
	@Test
	public void TC3() throws InterruptedException {
		 WebDriver  driver = new ChromeDriver();
	  	  navigateToWebsite(driver);
	        driver.quit();
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
	
    public static void navigateToWebsite(WebDriver driver) throws InterruptedException {
       
        // Assigning a URL from the object to a new URL in this class
        String url = Variables.URL();
        try {
            // Access the website
            driver.get(url);
            // Maximizing the browser window to fill the whole screen
            driver.manage().window().maximize();
            // Pause execution for 2 seconds to allow any necessary actions
            Thread.sleep(2000);
            // Validate if the website is open
            // Locate the "What's New" section that gets displayed only when you navigate to the website
            WebElement whatsNewSection = driver.findElement(Variables.whatsNewSection);

            // Check if the unique section is displayed on the webpage
            if (whatsNewSection.isDisplayed()) {
            	System.out.println("Verifying step 1");
                // Print message indicating successful opening of the website
                System.out.println("Landing page opens successfully.");
                
                System.out.println("Verifying step 2");
                // Locate and verify the header
                WebElement header = driver.findElement(Variables.header);
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
                WebElement lumaLogo = driver.findElement(By.className("logo"));
                if (lumaLogo.isDisplayed()) {
                    System.out.println("LUMA logo is displayed successfully.");
                 // Capture screenshot of the webpage with the message "Website opened successfully."
                    ScreenshotAction.Screenshot(driver, "logo is displayed successfully.");
                } else {
                    System.out.println("LUMA logo failed to display");
                 // Capture screenshot of the webpage with the message "Website opened successfully."
                    ScreenshotAction.Screenshot(driver, "logo failed to be displayed");
                    driver.quit();
                }

                // Locate and verify the menu bar
                WebElement menuBar = driver.findElement(By.cssSelector("nav.navigation"));
                if (menuBar.isDisplayed()) {
                    System.out.println("Menu bar is displayed.");
                 // Capture screenshot of the webpage with the message "Website opened successfully."
                    ScreenshotAction.Screenshot(driver, "menu navigation displayed");
                } else {
                    System.out.println("Menu bar is NOT displayed. step 2 failed");
                 // Capture screenshot of the webpage with the message "Website opened successfully."
                    ScreenshotAction.Screenshot(driver, "menu navigation failed to be displayed");
                    driver.quit();
                }

                // Locate and verify the search icon
                WebElement searchIcon = driver.findElement(Variables.searchIcon);
                if (searchIcon.isDisplayed()) {
                    System.out.println("Search icon is displayed.");
                 // Capture screenshot of the webpage with the message "Website opened successfully."
                    ScreenshotAction.Screenshot(driver, "search icon is displayed");
                } else {
                    System.out.println("Search icon failed to be displayed.");
                 // Capture screenshot of the webpage with the message "Website opened successfully."
                    ScreenshotAction.Screenshot(driver, "search icon failed to be displayed");
                    driver.quit();
                }

                // Locate and verify the cart icon
                WebElement cartIcon = driver.findElement(By.cssSelector("a.action.showcart"));
                if (cartIcon.isDisplayed()) {
                    System.out.println("Cart icon is displayed successfully.");
                 // Capture screenshot of the webpage with the message "Website opened successfully."
                    ScreenshotAction.Screenshot(driver, "cart is displayed successfully");
                } else {
                    System.out.println("Cart icon failed to be displayed.");
                 // Capture screenshot of the webpage with the message "Website opened successfully."
                    ScreenshotAction.Screenshot(driver, "cart failed to be displayed");
                    driver.quit();
                }
                System.out.println("Verifying step 3");
                // Short code to locate and verify the 'Support This Project' link
                WebElement supportThisProjectLink = driver.findElement(Variables.supportThisProjectLink);
                // Check if the 'Support This Project' link is displayed
                if (supportThisProjectLink.isDisplayed()) {
                    // Print message indicating that the 'Support This Project' link is displayed
                    System.out.println("Support This Project link is displayed successfully.");
                    // Capture screenshot of the webpage with the message "'Support This Project' link is displayed."
                    ScreenshotAction.Screenshot(driver, "Support This Project link is displayed successfully");
                } else {
                    // Print message indicating that the 'Support This Project' link is not displayed
                    System.out.println("Support This Project link is failed to be displayed.");
                    // Capture screenshot of the webpage with the message "'Support This Project' link is NOT displayed."
                    ScreenshotAction.Screenshot(driver, "Support This Project link failed to be displayed.");
                }

                // Short code to locate and verify the 'Sign In' link
                WebElement signInLink = driver.findElement(Variables.signInLink);
                // Check if the 'Sign In' link is displayed
                if (signInLink.isDisplayed()) {
                    // Print message indicating that the 'Sign In' link is displayed
                    System.out.println("Sign In link is displayed successfully.");
                    // Capture screenshot of the webpage with the message "'Sign In' link is displayed."
                    ScreenshotAction.Screenshot(driver, "Sign In link is displayed successfully.");
                } else {
                    // Print message indicating that the 'Sign In' link is not displayed
                    System.out.println("Sign In link failed to be displayed.");
                    // Capture screenshot of the webpage with the message "'Sign In' link is NOT displayed."
                    ScreenshotAction.Screenshot(driver, "Sign In link failed to be displayed.");
                }

                // Short code to locate and verify the 'Create An Account' link
                WebElement createAnAccountLink = driver.findElement(Variables.createAnAccountLink);
                // Check if the 'Create An Account' link is displayed
                if (createAnAccountLink.isDisplayed()) {
                    // Print message indicating that the 'Create An Account' link is displayed
                    System.out.println("Create An Account link is displayed successfully.");
                    // Capture screenshot of the webpage with the message "'Create An Account' link is displayed."
                    ScreenshotAction.Screenshot(driver, "Create An Account link is displayed successfully.");
                } else {
                    // Print message indicating that the 'Create An Account' link is not displayed
                    System.out.println("Create An Account link failed to be displayed.");
                    // Capture screenshot of the webpage with the message "'Create An Account' link is NOT displayed."
                    ScreenshotAction.Screenshot(driver, "Create An Account link failed to be displayed");
                }
                System.out.println("Verifying step 4");
                // Locate and verify the 'What's New' tab
                WebElement whatsNewTab = driver.findElement(Variables.whatsNewTab);
                if (whatsNewTab.isDisplayed()) {
                    // Print message indicating that the 'What's New' tab is displayed
                    System.out.println("What's New link is displayed successfully.");
                    // Capture screenshot of the webpage with the message "'What's New' tab is displayed."
                    ScreenshotAction.Screenshot(driver, "What's New link is displayed successfully");
                } else {
                    // Print message indicating that the 'What's New' tab is not displayed
                    System.out.println("What's New link failed to be displayed.");
                    // Capture screenshot of the webpage with the message "'What's New' tab is NOT displayed."
                    ScreenshotAction.Screenshot(driver, "What's New link failed to be displayed");
                    // Close the browser
                    driver.quit();
                }

                // Locate and verify the 'Women' tab
                WebElement womenTab = driver.findElement(Variables.womenTab);
                if (womenTab.isDisplayed()) {
                    System.out.println("Women link is displayed successfully.");
                    ScreenshotAction.Screenshot(driver, "Women link is displayed successfully");
                } else {
                    System.out.println("Women link failed to be displayed.");
                    ScreenshotAction.Screenshot(driver, "Women link failed to be displayed");
                    driver.quit();
                }

                // Locate and verify the 'Men' tab
                WebElement menTab = driver.findElement(Variables.menTab);
                if (menTab.isDisplayed()) {
                    System.out.println("Men link is displayed successfully.");
                    ScreenshotAction.Screenshot(driver, "Men link is displayed successfully");
                } else {
                    System.out.println("Men link failed to be displayed.");
                    ScreenshotAction.Screenshot(driver, "Men link failed to be displayed");
                    driver.quit();
                }

                // Locate and verify the 'Gear' tab
                WebElement gearTab = driver.findElement(Variables.gearTab);
                if (gearTab.isDisplayed()) {
                    System.out.println("Gear link is displayed successfully.");
                    ScreenshotAction.Screenshot(driver, "Gear link is displayed successfully");
                } else {
                    System.out.println("Gear link failed to be displayed.");
                    ScreenshotAction.Screenshot(driver, "Gear link failed to be displayed");
                    driver.quit();
                }

                // Locate and verify the 'Training' tab
                WebElement trainingTab = driver.findElement(Variables.trainingTab);
                if (trainingTab.isDisplayed()) {
                    System.out.println("Training link is displayed successfully.");
                    ScreenshotAction.Screenshot(driver, "Training link is displayed successfully");
                } else {
                    System.out.println("Training link failed to be displayed.");
                    ScreenshotAction.Screenshot(driver, "Training link failed to be displayed");
                    driver.quit();
                }

                // Locate and verify the 'Sale' tab
                WebElement saleTab = driver.findElement(Variables.saleTab);
                if (saleTab.isDisplayed()) {
                    System.out.println("Sale link is displayed successfully.");
                    ScreenshotAction.Screenshot(driver, "Sale is displayed successfully.");
                } else {
                    System.out.println("Sale link failed to be displayed.");
                    ScreenshotAction.Screenshot(driver, "Sale link failed to be displayed");
                    driver.quit();
                }
                
                System.out.println("Verifying step 6");
                // Locate and verify the 'Hoodies & Sweatshirts' link in the "New in Women's" section
                WebElement hoodiesAndSweatshirtsLink = driver.findElement(By.linkText("Hoodies & Sweatshirts"));
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

                // Locate and verify the 'Jackets' link in the "New in Women's" section
                WebElement jacketsLink = driver.findElement(By.linkText("Jackets"));
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
                // Locate and verify the 'Tees' link in the "New in Women's" section
                WebElement teesLink = driver.findElement(By.linkText("Tees"));
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

                // Locate and verify the 'Bras & Tanks' link in the "New in Women's" section
                WebElement brasAndTanksLink = driver.findElement(By.linkText("Bras & Tanks"));
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

                // Locate and verify the 'Pants' link in the "New in Women's" section
                WebElement pantsLink = driver.findElement(By.linkText("Pants"));
                if (pantsLink.isDisplayed()) {
                    System.out.println("'Pants' link in the 'New in Women's' section is displayed successfully.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "'Pants' link in the 'New in Women's' section is displayed successfully.");
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
                WebElement mensHoodiesAndSweatshirtsLink = driver.findElement(By.linkText("Hoodies & Sweatshirts"));
                if (mensHoodiesAndSweatshirtsLink.isDisplayed()) {
                    System.out.println("'Hoodies & Sweatshirts' link in the 'New in Men's' section is displayed successfully.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "'Hoodies & Sweatshirts' link in the 'New in Men's' section is displayed successfully.");
                } else {
                    System.out.println("'Hoodies & Sweatshirts' link in the 'New in Men's' section failed to be displayed.");
                    // Capture screenshot
                    ScreenshotAction.Screenshot(driver, "'Hoodies & Sweatshirts' link in the 'New in Men's' section fialed to be displayed");
                    // Quit browser
                    driver.quit();
                }

                // Locate and verify the 'Jackets' link in the "New in Men's" section
                WebElement mensJacketsLink = driver.findElement(By.linkText("Jackets"));
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
                // Locate and verify the 'Tees' link in the "New in Men's" section
                WebElement mensTeesLink = driver.findElement(By.linkText("Tees"));
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

                // Locate and verify the 'Tanks' link in the "New in Men's" section
                WebElement mensTanksLink = driver.findElement(By.linkText("Tanks"));
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

                // Locate and verify the 'Pants' link in the "New in Men's" section
                WebElement mensPantsLink = driver.findElement(By.linkText("Pants"));
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
                WebElement mensShortsLink = driver.findElement(By.linkText("Shorts"));
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
                // Scroll to "Luma's Latest" section
                System.out.println("scroll to elements.");
                WebElement lumasLatestSection = driver.findElement(Variables.lumasLatestSection);
                Actions actions = new Actions(driver);
                actions.moveToElement(lumasLatestSection).perform();
                Thread.sleep(2000);
               
                if (lumasLatestSection.isDisplayed()) {
                    System.out.println("'Just In Time For The New Season' section is displayed successfully.");
                    ScreenshotAction.Screenshot(driver, "Just in Time tittle displayed successfully");
                } else {
                    System.out.println("'Just In Time For The New Season' section failed to be displayed.");
                    ScreenshotAction.Screenshot(driver, "Just in Time tittle failed to be displayed");
                }
             // Verify product image under "Luma's Latest"
                WebElement productImage = driver.findElement(By.cssSelector(".product-item-photo"));
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

                // Verify product description under "Luma's Latest"
                WebElement productDescription = driver.findElement(By.cssSelector(".product-item-link"));
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
                WebElement productPrice = driver.findElement(By.cssSelector(".price"));
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
                // Locate and verify the New Luma Yoga Collection description
                WebElement newLumaYogaDescription = driver.findElement(Variables.newLumaYogaDescription);
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

                // Locate and verify the Shop New Yoga button
                WebElement shopNewYogaButton = driver.findElement(Variables.shopNewYogaButton);
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
                // Locate and verify the Whatever day brings description
                WebElement whateverDayBringsDescription = driver.findElement(Variables.whateverDayBringsDescription);
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

                // Verify presence of "Performance fabrics" text link
                WebElement performanceFabricsLink = driver.findElement(Variables.performanceFabricsLink);
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
                // Locate and verify the A sense of renewal description
                WebElement senseOfRenewalDescription = driver.findElement(Variables.senseOfRenewalDescription);
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
                WebElement shopEcoFriendlyLink = driver.findElement(Variables.shopEcoFriendlyLink);
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
                // Locate the notes text link
                WebElement noteslink = driver.findElement(Variables.noteslink);
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
                WebElement APITestlink = driver.findElement(Variables.APITestlink);
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
                WebElement WriteUslink = driver.findElement(Variables.WriteUslink);
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
                WebElement OrderReturnlink = driver.findElement(Variables.OrderReturnlink);
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
                WebElement SearchTermslink = driver.findElement(Variables.SearchTermslink);
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
                }
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
		

