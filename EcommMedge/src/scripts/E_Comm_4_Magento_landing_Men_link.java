package scripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class E_Comm_4_Magento_landing_Men_link {
	@Test
	public static void TC4() {
		// Initialize ChromeDriver
		  WebDriver  driver = new ChromeDriver();
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		//Pre requisites for the scripts
		  try {
			  E_Comm_3_Navigate_to_website.navigateToWebsite(driver, wait);
			  verifyMenLink(driver, wait);
			  driver.quit();
		} catch (InterruptedException e) {
			e.printStackTrace();
			driver.quit();
		}
		 
		}
	public static void verifyMenLink(WebDriver driver,WebDriverWait wait) {
        try {
        	Actions actions = new Actions(driver);
        	// Locate the "Men" Link and hover over 
            WebElement MenLink = wait.until(ExpectedConditions.visibilityOfElementLocated(Variables.MenLink));
            if(MenLink.isDisplayed()) {
            	System.out.println("Men Link is Displayed successfully");
            	ScreenshotAction.Screenshot(driver, "Men Link is Displayed successfully");
            	actions.moveToElement(MenLink).perform();
                WebElement topsLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui-id-17")));
                WebElement bottomsLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui-id-18")));
                if(topsLabel.isDisplayed() && bottomsLabel.isDisplayed()) {
                	System.out.println("Tops and Bottoms Link is Displayed successfully");
                	ScreenshotAction.Screenshot(driver, "Tops and Bottoms Link is Displayed successfully");
                }else {
                	System.out.println("Hover over failed");
                	ScreenshotAction.Screenshot(driver, "Hover over failed");
                	driver.quit();
                }
            }else {
            	System.out.println("Men Link failed to be displayed");
            	ScreenshotAction.Screenshot(driver, "Men Link failed to be displayed");
            }
            MenLink.click();
            //find and read the page heading to confirm if Men link is clicked on not
            WebElement MenHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[2]/main[1]/div[1]/h1[1]/span[1]")));
            if(MenHeading.isDisplayed() && MenHeading.getText().equals("Men")) {
            	System.out.println("Men Link clicked successfully");
            	ScreenshotAction.Screenshot(driver, "Men Link clicked successfully");
            }else {
            	System.out.println("Men Link failed to be clicked");
            	ScreenshotAction.Screenshot(driver, "Men Link failed to be clicked");
            	driver.quit();
            }
            //find and read the Tops link and the presence of the number of tops
            WebElement TopsLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Tops')]")));
            if(TopsLink.isDisplayed() && TopsLink.getText().equals("Tops")) {
            	System.out.println("Tops link displayed successfully");
            	ScreenshotAction.Screenshot(driver, "Tops link displayed successfully");
                WebElement TopsCount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'48')]")));
                if(TopsCount.isDisplayed() && TopsCount.getText().equals("48")) {
                	System.out.println("Tops count displayed successfully");
                	ScreenshotAction.Screenshot(driver, "Tops count displayed successfully");
                }else {
                	System.out.println("Tops count failed to be displayed");
                	ScreenshotAction.Screenshot(driver, "Tops count failed top be displayed");
                	driver.quit();
                }
            }else {
            	System.out.println("Tops Link failed to be displayed");
            	ScreenshotAction.Screenshot(driver, "Tops Link failed to be displayed");
            	driver.quit();
            }
            
            //find and read the Bottoms link and the presence of the number of tops
            WebElement BottomsLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Bottoms')]")));
            if(BottomsLink.isDisplayed() && BottomsLink.getText().equals("Bottoms")) {
            	System.out.println("Bottoms link displayed successfully");
            	ScreenshotAction.Screenshot(driver, "Bottoms link displayed successfully");
                WebElement BottomsCount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'24')]")));
                if(BottomsCount.isDisplayed() && BottomsCount.getText().equals("24")) {
                	System.out.println("Bottoms count displayed successfully");
                	ScreenshotAction.Screenshot(driver, "bottoms count displayed successfully");
                }else {
                	System.out.println("Bottoms count failed to be displayed");
                	ScreenshotAction.Screenshot(driver, "Bottoms count failed top be displayed");
                	driver.quit();
                }
            }else {
            	System.out.println("Bottoms Link failed to be displayed");
            	ScreenshotAction.Screenshot(driver, "Bottoms Link failed to be displayed");
            	driver.quit();
            }
            //find and read the Tops heading and the four link texts
            WebElement TopsHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(Variables.Tops));
            if(TopsHeading.isDisplayed()) {
            	System.out.println("Tops Heading displayed successfully");
            	ScreenshotAction.Screenshot(driver, "Tops Heading link displayed successfully");
            	//find and read the hoodies and sweats shirts link
                WebElement HoodiesLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Hoodies & Sweatshirts')]")));
                if(HoodiesLink.isDisplayed() && HoodiesLink.getText().equals("Hoodies & Sweatshirts")) {
                	System.out.println("Hoodies Link displayed successfully");
                	ScreenshotAction.Screenshot(driver, "Hoodies Link displayed successfully");
                }else {
                	System.out.println("Hoodies Link failed to be displayed");
                	ScreenshotAction.Screenshot(driver, "Hoodies Link failed top be displayed");
                	driver.quit();
                }
                //find and read the Jackets link
                WebElement JacketsLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Jackets')]")));
                if(JacketsLink.isDisplayed() && JacketsLink.getText().equals("Jackets")) {
                	System.out.println("Jackets Link displayed successfully");
                	ScreenshotAction.Screenshot(driver, "Jackets Link displayed successfully");
                }else {
                	System.out.println("Jackets Link failed to be displayed");
                	ScreenshotAction.Screenshot(driver, "Jackets Link failed top be displayed");
                	driver.quit();
                }
                //find and read the Tees link
                WebElement TeesLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Tees')]")));
                if(TeesLink.isDisplayed() && TeesLink.getText().equals("Tees")) {
                	System.out.println("Tees Link displayed successfully");
                	ScreenshotAction.Screenshot(driver, "Tees Link displayed successfully");
                }else {
                	System.out.println("Tees Link failed to be displayed");
                	ScreenshotAction.Screenshot(driver, "Tees Link failed top be displayed");
                	driver.quit();
                }
                //find and read the Tanks link
                WebElement TanksLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Tanks')]")));
                if(TanksLink.isDisplayed() && TanksLink.getText().equals("Tanks")) {
                	System.out.println("Tanks Link displayed successfully");
                	ScreenshotAction.Screenshot(driver, "Tanks Link displayed successfully");
                }else {
                	System.out.println("Tanks Link failed to be displayed");
                	ScreenshotAction.Screenshot(driver, "Tanks Link failed top be displayed");
                	driver.quit();
                }
            }else {
            	System.out.println("Tops Heading failed to be displayed");
            	ScreenshotAction.Screenshot(driver, "Tops Heading failed to be displayed");
            	driver.quit();
            }
            //find and read the Bottoms heading and the Two link texts
            WebElement BottomsHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(Variables.Bottoms));
            if(BottomsHeading.isDisplayed()) {
            	System.out.println("Bottoms Heading displayed successfully");
            	ScreenshotAction.Screenshot(driver, "Bottoms Heading link displayed successfully");
            	//find and read the Pants link
                WebElement PantsLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Pants')]")));
                if(PantsLink.isDisplayed() && PantsLink.getText().equals("Pants")) {
                	System.out.println("Pants Link displayed successfully");
                	ScreenshotAction.Screenshot(driver, "Pants Link displayed successfully");
                }else {
                	System.out.println("Pants Link failed to be displayed");
                	ScreenshotAction.Screenshot(driver, "Pants Link failed top be displayed");
                	driver.quit();
                }
                //find and read the Jackets link
                WebElement ShortsLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Shorts')]")));
                if(ShortsLink.isDisplayed() && ShortsLink.getText().equals("Shorts")) {
                	System.out.println("Shorts Link displayed successfully");
                	ScreenshotAction.Screenshot(driver, "Shorts Link displayed successfully");
                }else {
                	System.out.println("Shorts Link failed to be displayed");
                	ScreenshotAction.Screenshot(driver, "Shorts Link failed top be displayed");
                	driver.quit();
                }
                
            }else {
            	System.out.println("Bottoms Heading failed to be displayed");
            	ScreenshotAction.Screenshot(driver, "Bottoms Heading failed to be displayed");
            	driver.quit();
            }
            //find and read the compare products heading and the word displayed
            WebElement CompareProductsHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[@id='block-compare-heading']")));
            if(CompareProductsHeading.isDisplayed() && CompareProductsHeading.getText().equals("Compare Products")) {
            	System.out.println("Compare Products Heading displayed successfully");
            	ScreenshotAction.Screenshot(driver, "Compare Products Heading link displayed successfully");
            	//find and read the Pants link
                WebElement DisplayedWords = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'You have no items to compare.')]")));
                if(DisplayedWords.isDisplayed() && DisplayedWords.getText().equals("You have no items to compare.")) {
                	System.out.println("Displayed Words match successfully");
                	ScreenshotAction.Screenshot(driver, "Displayed Words match successfully");
                }else {
                	System.out.println("Words failed to be displayed");
                	ScreenshotAction.Screenshot(driver, "Words failed top be displayed");
                	driver.quit();
                }
              
                
            }else {
            	System.out.println("Compare Products Heading failed to be displayed");
            	ScreenshotAction.Screenshot(driver, "Compare Products Heading failed to be displayed");
            	driver.quit();
            }
            ScrollHelper.scrollToElement(driver,CompareProductsHeading);
            //find and read the My wish list heading and the word displayed
            WebElement MyWishListHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(Variables.MyWsihList));
            if(MyWishListHeading.isDisplayed() && MyWishListHeading.getText().equals("Compare Products")) {
            	System.out.println("Compare Products Heading displayed successfully");
            	ScreenshotAction.Screenshot(driver, "Compare Products Heading link displayed successfully");
            	//find and read the Pants link
                WebElement DisplayedWords = wait.until(ExpectedConditions.visibilityOfElementLocated(Variables.MyWsihListwords));
                if(DisplayedWords.isDisplayed() && DisplayedWords.getText().equals("You have no items to compare.")) {
                	System.out.println("My wish list Displayed Words match successfully");
                	ScreenshotAction.Screenshot(driver, "my wish list Displayed Words match successfully");
                }else {
                	System.out.println("my wish list Words failed to be displayed");
                	ScreenshotAction.Screenshot(driver, " my wish list Words failed top be displayed");
                	driver.quit();
                }
              
                
            }else {
            	System.out.println("My Wish List Heading failed to be displayed");
            	ScreenshotAction.Screenshot(driver, "My Wish list Heading failed to be displayed");
            	driver.quit();
            }
            //find and read the Image and its texts
            WebElement Image = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[2]/main[1]/div[4]/div[1]/div[1]/div[1]/a[1]/img[1]")));
            if(Image.isDisplayed()) {
            	System.out.println("Image displayed successfully");
            	ScreenshotAction.Screenshot(driver, "Image displayed successfully");
            	//find and read the description
                WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[contains(text(),'Going the extra mile just got extra comfortable')]")));
                if(description.isDisplayed() && description.getText().equals("Going the extra mile just got extra comfortable")) {
                	System.out.println("description Displayed Words match successfully");
                	ScreenshotAction.Screenshot(driver, "description Displayed Words match successfully");
                }else {
                	System.out.println("description Words failed to be displayed");
                	ScreenshotAction.Screenshot(driver, "description Words failed top be displayed");
                	driver.quit();
                }
                //find the button and read the text
                WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Shop Performance')]")));
                if(button.isDisplayed() && button.getText().equals("Shop Performance")) {
                	System.out.println("button Displayed Words match successfully");
                	ScreenshotAction.Screenshot(driver, "button Displayed Words match successfully");
                }else {
                	System.out.println("button Words failed to be displayed");
                	ScreenshotAction.Screenshot(driver, "button Words failed top be displayed");
                	driver.quit();
                }
            }else {
            	System.out.println("Image failed to be displayed");
            	ScreenshotAction.Screenshot(driver, "Image failed to be displayed");
            	driver.quit();
            }
            //find and read the Image and its texts
            WebElement Image2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[2]/main[1]/div[4]/div[1]/div[1]/div[1]/div[1]/a[2]/img[1]")));
            if(Image2.isDisplayed()) {
            	System.out.println("Shop Pants Image displayed successfully");
            	ScreenshotAction.Screenshot(driver, "Shop Pants Image displayed successfully");
            	//find and read the description
                WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[2]/main[1]/div[4]/div[1]/div[1]/div[1]/div[1]/a[2]/span[1]/strong[1]")));
                if(description.isDisplayed()) {
                	System.out.println("Shop Pants description Displayed successfully");
                	ScreenshotAction.Screenshot(driver, "Shop Pants description Displayed successfully");
                }else {
                	System.out.println("Shop Pants description failed to be displayed");
                	ScreenshotAction.Screenshot(driver, "Shop Pants description failed top be displayed");
                	driver.quit();
                }
                //find the button and read the text
                WebElement textLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Shop Pants')]")));
                if(textLink.isDisplayed() && textLink.getText().equals("Shop Pants")) {
                	System.out.println("Shop Pants Link Displayed Words match successfully");
                	ScreenshotAction.Screenshot(driver, "Shop Pants Link Displayed Words match successfully");
                }else {
                	System.out.println("Shop Pants Link Words failed to be displayed");
                	ScreenshotAction.Screenshot(driver, "Shop Pants Link Words failed top be displayed");
                	driver.quit();
                }
            }else {
            	System.out.println("Shop Pants Image failed to be displayed");
            	ScreenshotAction.Screenshot(driver, "Shop Pants Image failed to be displayed");
            	driver.quit();
            }
            //find and read the Image and its texts
            WebElement Image3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[2]/main[1]/div[4]/div[1]/div[1]/div[1]/div[2]/a[1]/span[2]/img[1]")));
            if(Image3.isDisplayed()) {
            	System.out.println("Shot Image displayed successfully");
            	ScreenshotAction.Screenshot(driver, "shot Image displayed successfully");
            	//find and read the description
                WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[contains(text(),'Luma shorts')]")));
                if(description.isDisplayed() && description.getText().equals("Luma shorts")) {
                	System.out.println("shot image description Displayed successfully");
                	ScreenshotAction.Screenshot(driver, "shot image description Displayed successfully");
                }else {
                	System.out.println("shot image description failed to be displayed");
                	ScreenshotAction.Screenshot(driver, "shot image description failed top be displayed");
                	driver.quit();
                }
                //find the text link and read the text
                WebElement textLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Shop Shorts')]")));
                if(textLink.isDisplayed() && textLink.getText().equals("Shop Shorts")) {
                	System.out.println("Shop Shorts Link Displayed Words match successfully");
                	ScreenshotAction.Screenshot(driver, "Shop Shorts Link Displayed Words match successfully");
                }else {
                	System.out.println("Shop Shorts Link Words failed to be displayed");
                	ScreenshotAction.Screenshot(driver, "Shop Shorts Link Words failed top be displayed");
                	driver.quit();
                }
            }else {
            	System.out.println("Shop Shorts Image failed to be displayed");
            	ScreenshotAction.Screenshot(driver, "Shop Shorts Image failed to be displayed");
            	driver.quit();
            }
          //find and read the Image and its texts
            WebElement Image4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[2]/main[1]/div[4]/div[1]/div[1]/div[1]/div[2]/a[2]/span[2]/img[1]")));
            if(Image4.isDisplayed()) {
            	System.out.println("Tees Image displayed successfully");
            	ScreenshotAction.Screenshot(driver, "Tess Image displayed successfully");
            	//find and read the description
                WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[contains(text(),'Luma tees')]")));
                if(description.isDisplayed() && description.getText().equals("Luma tees")) {
                	System.out.println("Luma tees image description Displayed successfully");
                	ScreenshotAction.Screenshot(driver, "shot image description Displayed successfully");
                }else {
                	System.out.println("Luma tees image description failed to be displayed");
                	ScreenshotAction.Screenshot(driver, "Luma tees image description failed top be displayed");
                	driver.quit();
                }
                //find the text link and read the text
                WebElement textLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[2]/main[1]/div[4]/div[1]/div[1]/div[1]/div[2]/a[2]/span[1]/span[2]")));
                if(textLink.isDisplayed() && textLink.getText().equals("Shop Tees")) {
                	System.out.println("Shop Tees Link Displayed Words match successfully");
                	ScreenshotAction.Screenshot(driver, "Shop Tees Link Displayed Words match successfully");
                }else {
                	System.out.println("Shop Tees Link Words failed to be displayed");
                	ScreenshotAction.Screenshot(driver, "Shop Tees Link Words failed top be displayed");
                	driver.quit();
                }
            }else {
            	System.out.println("Shop Tees Image failed to be displayed");
            	ScreenshotAction.Screenshot(driver, "Shop Tees Image failed to be displayed");
            	driver.quit();
            }
          //find and read the Image and its texts
            WebElement Image5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[2]/main[1]/div[4]/div[1]/div[1]/div[1]/div[2]/a[3]/span[2]/img[1]")));
            if(Image5.isDisplayed()) {
            	System.out.println("Luma hoodies Image displayed successfully");
            	ScreenshotAction.Screenshot(driver, "Luma hoodies Image displayed successfully");
            	//find and read the description
                WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[contains(text(),'Luma hoodies')]")));
                if(description.isDisplayed() && description.getText().equals("Luma hoodies")) {
                	System.out.println("Luma hoodies image description Displayed successfully");
                	ScreenshotAction.Screenshot(driver, "shot image description Displayed successfully");
                }else {
                	System.out.println("Luma hoodies image description failed to be displayed");
                	ScreenshotAction.Screenshot(driver, "Luma hoodies image description failed top be displayed");
                	driver.quit();
                }
                //find the text link and read the text
                WebElement textLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Shop Hoodies')]")));
                if(textLink.isDisplayed() && textLink.getText().equals("Shop Hoodies")) {
                	System.out.println("Shop Hoodies Link Displayed Words match successfully");
                	ScreenshotAction.Screenshot(driver, "Shop Hoodies Link Displayed Words match successfully");
                }else {
                	System.out.println("Shop Hoodies Link Words failed to be displayed");
                	ScreenshotAction.Screenshot(driver, "Shop Hoodies Link Words failed top be displayed");
                	driver.quit();
                }
            }else {
            	System.out.println("Luma hoodies Image failed to be displayed");
            	ScreenshotAction.Screenshot(driver, "Luma hoodies Image failed to be displayed");
            	driver.quit();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("catch executed: "+e);
        	ScreenshotAction.Screenshot(driver, "catch executed");
            driver.quit();
        }
    }
}








