package Pages.UI;

import utilities.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected static WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        Browser browser = Browser.getInstance();
        this.driver = browser.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public abstract String getPageTitle();

    public abstract boolean pageIsDisplayed();

    public BasePage waitForPageTitle(String pageTitle) {
        wait.until(ExpectedConditions.titleIs(pageTitle));
        return this;
    }

    public WebElement waitForElement(By locator) {
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (TimeoutException e) {
            throw new RuntimeException("Element not found within the wait time: " + locator, e);
        } catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred while waiting for element: " + locator, e);
        }
    }
    public WebElement waitForElement(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            throw new RuntimeException("Element not found within the wait time: " + element, e);
        } catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred while waiting for element: " + element, e);
        }
    }
    public WebElement waitForElementToBeEnabled(By locator) {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (TimeoutException e) {
            throw new RuntimeException("Element not clickable within the wait time: " + locator, e);
        } catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred while waiting for element to be clickable: " + locator, e);
        }
    }

    public WebElement waitForElementToBeEnabled(WebElement element) {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e) {
            throw new RuntimeException("Element not clickable within the wait time: " + element, e);
        } catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred while waiting for element to be clickable: " + element, e);
        }
    }
    public BasePage click(By locator) {
        waitForElement(locator).click();
        return this;
    }
    public BasePage click(WebElement element) {
        waitForElement(element).click();
        return this;
    }
    public boolean isDisplayed(By locator) {
        try {
            return waitForElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isDisplayed(WebElement element) {
        try {
            return waitForElement(element).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getText(By locator) {
        try {
            return waitForElement(locator).getText();
        } catch (Exception e) {
            return null;
        }
    }

    public BasePage sendKeys(By locator, String text) {
        waitForElementToBeEnabled(locator).sendKeys(text);
        return this;
    }

    public BasePage selectFromDropdown(By locator, String value) {
        getDropdown(locator).selectByValue(value);
        return this;
    }
    public BasePage selectFromDropdownByValue(By locator, String value) {
        getDropdown(locator).selectByValue(value);
        return this;
    }

    public BasePage selectFromDropdownByIndex(By locator, int index) {
        getDropdown(locator).selectByIndex(index);
        return this;
    }

    public BasePage selectFromDropdownByVisibleText(By locator, String text) {
        getDropdown(locator).selectByVisibleText(text);
        return this;
    }
    public Select getDropdown(By locator) {
        waitForElementToBeEnabled(locator);
        return new Select(waitForElement(locator));
    }
}
