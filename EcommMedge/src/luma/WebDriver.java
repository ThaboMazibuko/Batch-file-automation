package luma;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
 
public class WebDriver {
    protected static EdgeDriver driver;
 
    public EdgeDriver getDriver() {
        if (driver == null) {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }
 
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

	public WebElement findElement(By xpath) {
		// TODO Auto-generated method stub
		return null;
	}
}

