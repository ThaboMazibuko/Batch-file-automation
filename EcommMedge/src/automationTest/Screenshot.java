
/*
!Function Name		: Webdriver
'!Purpose			: Verifies the viewing period of the device of the customer who is created on the same day with IP day as creation day
'!Input 			: None
'!Output 	  		: Takes screenshots for all verifications	 
'!Developed By	 	: Sibusiso Prince Phakathi
'!Date	 		  	: 10/06/24

*/


package automationTest;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
    public static void takeScreenshot(WebDriver driver, String fileName) {
        try {
            // Ensure the directory exists or create it
            File screenshotDir = new File("C:/Users/SibusisoPrincePhakat/OneDrive - Linkfields innovations/Documents/test screenshot/");
            if (!screenshotDir.exists()) {
                screenshotDir.mkdirs();
            }

            Date dt = new Date();
            DateFormat df = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

            // Take screenshot
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            BufferedImage image = ImageIO.read(screenshotFile);
            Graphics2D graphics = image.createGraphics();
            graphics.setColor(Color.RED);
            graphics.setFont(new Font("Arial", Font.PLAIN, 40));
            graphics.drawString("The test was executed at " + df.format(dt), 150, 120);

            // Construct the full file path
            File outputFile = new File(screenshotDir, fileName);
            ImageIO.write(image, "png", outputFile);

            System.out.println("Screenshot captured and saved as: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Failed to capture screenshot with text: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error while taking screenshot: " + e.getMessage());
        }
    }
}
