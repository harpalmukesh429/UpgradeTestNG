package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Browser {
    private static Browser instance = null;
    private WebDriver driver;

    protected Browser() {
        // Protected constructor to prevent instantiation
    }

    public static Browser getInstance() {
        if (instance == null) {
            instance = new Browser();
        }
        return instance;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void openBrowser(String browserName, String url) {
        if (driver == null) {
            if (browserName != null) {
                switch (browserName.toLowerCase()) {
                    case "chrome":
                        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
                        driver = new ChromeDriver();
                        break;
                    case "firefox":
                        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
                        driver = new FirefoxDriver();
                        break;
                    case "safari":
                        driver = new SafariDriver();
                        break;
                    default:
                        System.out.println("Invalid Browser Name");
                        return;
                }
            }
            if (driver != null) {
                driver.get(url);
                driver.manage().deleteAllCookies();
                driver.manage().window().maximize();
            } else {
                System.out.println("Driver is not initialized. Check the browser name.");
            }
        } else {
            System.out.println("Browser name is null.");
        }
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.close();
            driver.quit();
            driver = null;
        }
    }
}
