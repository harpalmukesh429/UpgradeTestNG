package UpgradeUI;

import StepDefinitions.UISteps.BasicInformationSteps;
import StepDefinitions.UISteps.HomePageSteps;
import utilities.TestInitializer;

import utilities.Browser;
import utilities.TestProperty;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class UpgradeUI {
    private HomePageSteps homePageSteps;
    private BasicInformationSteps basicInformationSteps;

    private
    Browser browser = Browser.getInstance();

    @BeforeSuite
    public void loadProperties() {
        // Load the main properties file
        TestInitializer.setUp();
        // Load additional properties files if needed
    }

    @BeforeClass
    public void setUp() {
        String browserName = TestProperty.getInstance().getProperty("browser");
        String url = TestProperty.getInstance().getProperty("url");
        browser.openBrowser(browserName, url);
        homePageSteps = new HomePageSteps();
        basicInformationSteps = new BasicInformationSteps();
    }

    @Test
    public void OpenAccount() {
        if (homePageSteps.homePageIsDisplayed()) {
            homePageSteps.selectProductOnHomePage("Personal Loans", "Debt Consolidation");
            homePageSteps.selectLoanAmountAndPurpose("1000","DEBT_CONSOLIDATION");
        } else {
            Assert.fail("Home page is not displayed.");
        }
        homePageSteps.clickcheckYourRate();
    }
    @Test
    public void testBasicInformationPage() {
        navigateToPersonalLoans();
        homePageSteps.enterCheckYourRateInfo("1000", "DEBT_CONSOLIDATION");
        if (basicInformationSteps.basicInformationPageIsDisplayed()) {
            basicInformationSteps.enterBasicInformation(
                    "Harpal", "Singh", "2 North Central",
                    "Arizona", "Phoenix", "85004", "12/7/1980"
            );
        } else {
            Assert.fail("Basic Information page is not displayed.");
        }
    }

    private void navigateToPersonalLoans() {
        if (homePageSteps.homePageIsDisplayed()) {
            homePageSteps.selectProductOnHomePage("Personal Loans", "Debt Consolidation");
        } else {
            Assert.fail("Home page is not displayed.");
        }
    }

    @AfterClass
    public void tearDown() {
        browser.closeBrowser();
    }
}
