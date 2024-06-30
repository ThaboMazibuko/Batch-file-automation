package luma;

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

public class screenshot {
	 public static void takeScreenshot(WebDriver driver, String fileName) {
		 Date dt = new Date(); // Current date and time
		 DateFormat df = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss"); // Define a date format for formatting the date


	    	try {
	            // Capture screenshot method if it passsed
	            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	 
	            // Load the captured screenshot
	            BufferedImage image = ImageIO.read(screenshotFile);
	            // Write text on the screenshot
	            Graphics2D graphics = image.createGraphics();
	            graphics.setColor(Color.RED);
	            graphics.setFont(new Font("Arial", Font.PLAIN, 40));
	            graphics.drawString("user successfully clicked the button and navigated to next page", 150, 120);
	 
	            // Save the modified screenshot
	            File outputFile = new File("C:/Users/MutshidziMukwevho-LF/OneDrive - Linkfields innovations/Pictures/Screenshots" + fileName);
	            ImageIO.write(image, "png", outputFile);
	        // write the text on the screenshot
	            System.out.println("Screenshot captured written a  text and saved as: " + fileName);
	        } catch (IOException e) {
	            System.out.println("Failed to capture screenshot with text: " + e.getMessage());
	        }
	    	
	    }
	 
	    public static void takeScreenshotF(WebDriver driver, String fileName) {
	    	try {
	    		// Capture screenshot method if it passsed
	           
	            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	 
	            // Load the captured screenshot
	            BufferedImage image = ImageIO.read(screenshotFile);
	 
	            // Write text on the screenshot
	            
	            Graphics2D graphics = image.createGraphics();
	            graphics.setColor(Color.RED);
	            graphics.setFont(new Font("Arial", Font.PLAIN, 56));
	            graphics.drawString("user unsuccessfully clicked the button and not navigated to next page ", 150, 100); // Adjust position as needed
	 
	            // Save the modified screenshot on my PC folders
	            File outputFile = new File("C:/Users/MutshidziMukwevho-LF/OneDrive - Linkfields innovations/Pictures/Screenshots"+ fileName);
	           // "C:\Users\MutshidziMukwevho-LF\OneDrive - Linkfields innovations\Documents\Chizi"
	            ImageIO.write(image, "png", outputFile);
	 
	            System.out.println("1.Screenshot captured with text and saved as: " + fileName);
	        } catch (IOException e) {
	            System.out.println("1.Failed to capture screenshot with text: " + e.getMessage());
	            
	            driver.quit();
	           
	        }
	    }
}
