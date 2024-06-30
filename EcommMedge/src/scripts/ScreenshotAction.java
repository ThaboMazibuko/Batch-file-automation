package scripts;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotAction {
	
 // Method to take a screenshot with success message
    public static void Screenshot(WebDriver driver, String fileName) {
        try {
            // Capture screenshot method if it passed
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            
            // Get the current date and time
            SimpleDateFormat folderdateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat shotdateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
            Date currentDate = new Date();
            String folderName = "Screenshots"+ "_" + folderdateFormat.format(currentDate);

            // Create folder if not exists
            File folder = new File(folderName);
            if (!folder.exists()) {
                folder.mkdirs();
            }
            

            // Load the captured screenshot
            BufferedImage image = ImageIO.read(screenshotFile);

            // Write text on the screenshot
            Graphics2D graphics = image.createGraphics();
            graphics.setColor(Color.BLACK);
            graphics.setFont(new Font("Arial", Font.ITALIC, 30));
            graphics.drawString(fileName, 150, 120);

            // Save the modified screenshot in the folder
            String shot = folderName + "/" + fileName + shotdateFormat.format(currentDate)+ ".png";
            File outputFile = new File(shot);
            ImageIO.write(image, "png", outputFile);

            System.out.println("Screenshot captured and saved as: " + fileName);
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }

    

}


