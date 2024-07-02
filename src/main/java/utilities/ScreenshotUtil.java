package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
    private static ScreenshotUtil instance;
    private WebDriver driver;

    public ScreenshotUtil() {
        this.driver = Browser.getInstance().getDriver();
    }
    public static ScreenshotUtil getInstance() {
        if (instance == null) {
            instance = new ScreenshotUtil();
        }
        return instance;
    }
    public void takeScreenshot(String screenshotName) {
        // Create a unique name for the screenshot based on the current date and time
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String fileName = screenshotName + "_" + timestamp + ".png";

        // Capture the screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Define the destination path
        String filePath = System.getProperty("user.dir") + "/screenshots/" + fileName;

        try {
            // Copy the screenshot to the destination path
            FileUtils.copyFile(screenshot, new File(filePath));
            System.out.println("Screenshot saved at: " + filePath);
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}

