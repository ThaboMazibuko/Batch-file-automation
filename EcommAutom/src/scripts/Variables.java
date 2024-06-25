package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Variables {
	public static String URL() {
		String url = readData.readLinkFromFile();
		return url;
		
	}
	public static By whatsNewSection = By.xpath("//body/div[2]/main[1]/div[1]/h1[1]/span[1]");
	public static By header = By.cssSelector("header.page-header");
	public static By lumaLogo = By.className("logo");
	public static By menuBar = By.cssSelector("nav.navigation");
	public static By searchIcon = By.cssSelector("div.search");
	public static By cartIcon = By.cssSelector("a.action.showcart");
	public static By cartSubTotal = By.xpath("/html[1]/body[1]/div[2]/header[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/span[1]/span[1]");
	public static By supportThisProjectLink = By.cssSelector("body.page-products.categorypath-what-is-new.category-what-is-new.catalog-category-view.page-layout-2columns-left:nth-child(2) div.page-wrapper:nth-child(5) main.page-main div.page-title-wrapper:nth-child(2) h1.page-title > span.base");
	public static By signInLink = By.xpath("//body/div[2]/main[1]/div[1]/h1[1]/span[1]");
	public static By createAnAccountLink = By.xpath("//body/div[2]/main[1]/div[1]/h1[1]/span[1]");
	public static By whatsNewTab = By.xpath("//body[1]/div[2]/main[1]/div[1]/h1[1]/span[1]");
	public static By womenTab = By.xpath("//body/div[2]/main[1]/div[1]/h1[1]/span[1]");
	public static By menTab = By.xpath("//body/div[2]/main[1]/div[1]/h1[1]/span[1]");
	public static By gearTab = By.xpath("//body/div[2]/main[1]/div[1]/h1[1]/span[1]");
	public static By trainingTab = By.xpath("//body/div[2]/main[1]/div[1]/h1[1]/span[1]");
	public static By shippingItemPrice = By.xpath("//body/div[2]/main[1]/div[2]/div[1]/div[2]/aside[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ol[1]/li[1]/div[1]/div[1]/div[1]/div[2]/span[1]/span[1]/span[1]");
	public static By saleTab = By.xpath("//body/div[2]/main[1]/div[1]/h1[1]/span[1]");
	public static By hoodiesAndSweatshirtsLink = By.xpath("//body/div[2]/main[1]/div[4]/div[2]/div[1]/div[1]/ul[1]/li[1]/a[1]");
	public static By jacketsLink = By.xpath("//body/div[2]/main[1]/div[4]/div[2]/div[1]/div[1]/ul[1]/li[2]/a[1]");
	public static By teesLink = By.xpath("//body/div[2]/main[1]/div[4]/div[2]/div[1]/div[1]/ul[1]/li[3]");
	public static By brasAndTanksLink = By.xpath("//a[contains(text(),'Bras & Tanks')]");
	public static By pantsLink = By.xpath("//body/div[2]/main[1]/div[4]/div[2]/div[1]/div[1]/ul[1]/li[5]/a[1]");
	public static By lumasLatestSection = By.xpath("//body/div[2]/main[1]/div[4]/div[2]/div[1]/div[1]/ul[1]/li[5]/a[1]");
	public static By newLumaYogaDescription = By.xpath("//body/div[2]/main[1]/div[4]/div[2]/div[1]/div[1]/ul[1]/li[5]/a[1]");
	public static By shopNewYogaButton = By.xpath("//body/div[2]/main[1]/div[4]/div[2]/div[1]/div[1]/ul[1]/li[5]/a[1]");
	public static By whateverDayBringsDescription = By.xpath("//body/div[2]/main[1]/div[4]/div[2]/div[1]/div[1]/ul[1]/li[5]/a[1]");
	public static By performanceFabricsLink = By.xpath("//body/div[2]/main[1]/div[4]/div[2]/div[1]/div[1]/ul[1]/li[5]/a[1]");
	public static By senseOfRenewalDescription = By.xpath("//body/div[2]/main[1]/div[4]/div[2]/div[1]/div[1]/ul[1]/li[5]/a[1]");
	public static By shopEcoFriendlyLink = By.xpath("//body/div[2]/main[1]/div[4]/div[2]/div[1]/div[1]/ul[1]/li[5]/a[1]");
	public static By noteslink = By.xpath("//body/div[2]/main[1]/div[4]/div[2]/div[1]/div[1]/ul[1]/li[5]/a[1]");
	public static By APITestlink = By.xpath("//body/div[2]/main[1]/div[4]/div[2]/div[1]/div[1]/ul[1]/li[5]/a[1]");
	public static By WriteUslink = By.xpath("//body/div[2]/main[1]/div[4]/div[2]/div[1]/div[1]/ul[1]/li[5]/a[1]");
	public static By OrderReturnlink = By.xpath("//body/div[2]/main[1]/div[4]/div[2]/div[1]/div[1]/ul[1]/li[5]/a[1]");
	public static By SearchTermslink = By.xpath("//body/div[2]/main[1]/div[4]/div[2]/div[1]/div[1]/ul[1]/li[5]/a[1]");
	public static By cartQTY = By.xpath("/html[1]/body[1]/div[2]/header[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/span[1]/span[1]");
	public static By ShippingorderQTY = By.xpath("//body/div[2]/main[1]/div[2]/div[1]/div[2]/aside[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ol[1]/li[1]/div[1]/div[1]/div[1]/div[2]/span[1]/span[1]/span[1]");
	public static By ShippingMethod = By.xpath("//tbody/tr[1]/td[1]/input[1]");


	
	
	
	
	
	
	
}
