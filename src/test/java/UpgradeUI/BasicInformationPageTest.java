package UpgradeUI;

import StepDefinitions.UISteps.BasicInformationSteps;
import StepDefinitions.UISteps.HomePageSteps;
import StepDefinitions.UISteps.IncomeInformationSteps;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utilities.*;

import org.testng.Assert;
import org.testng.annotations.*;

public class BasicInformationPageTest {
    private HomePageSteps homePageSteps;
    private BasicInformationSteps basicInformationSteps;
    private IncomeInformationSteps incomeInformationSteps;
    private
    Browser browser = Browser.getInstance();
    private static final Logger logger = LogManager.getLogger(TestListener.class);

    @BeforeSuite
    public void loadProperties() {
        // Load the main properties file
        TestInitializer.setUp();
        // Load additional properties files if needed
    }

    @BeforeClass
    public void setUp() {


    }

    @BeforeMethod
    public void navigateToBasicInformationPage() {
        String browserName = TestProperty.getInstance().getProperty("browser");
        String url = TestProperty.getInstance().getProperty("url");
        // Navigate to the Basic Information Page before each test
        browser.openBrowser(browserName, url);
        homePageSteps = new HomePageSteps();
        basicInformationSteps = new BasicInformationSteps();
        incomeInformationSteps = new IncomeInformationSteps();
        homePageSteps.selectProductOnHomePage("Personal Loans", "Debt Consolidation");
        homePageSteps.enterCheckYourRateInfo("1000", "DEBT_CONSOLIDATION");
    }

    @Test(dataProvider = "validDOB", dataProviderClass = DataProviderUtils.class)
    public void testValidBasicInformation(String firstName, String lastName,
             String street, String state, String city, String zipcode, String DOB, String TestID) {
        if (basicInformationSteps.basicInformationPageIsDisplayed()) {
            basicInformationSteps.enterBasicInformation(
                    firstName, lastName, street,
                    state, city, zipcode, DOB
            );
            basicInformationSteps.submitBasicInformation();
        } else {
            Assert.fail("Basic Information page is not displayed.");
        }

        Assert.assertTrue(incomeInformationSteps.incomeInformationPageIsDisplayed(),
                "user successfully navigated to Income Information Page");
        logger.info("user successfully navigated to Income Information Page");
    }
    @Test(dataProvider = "invalidDOBdata", dataProviderClass = DataProviderUtils.class)
    public void testInValidDOB
            (String firstName, String lastName,
             String street, String state, String city, String zipcode,
             String DOB, String expectedError, String TestID) {
        if (basicInformationSteps.basicInformationPageIsDisplayed()) {
            basicInformationSteps.enterBasicInformation(
                    firstName, lastName, street,
                    state, city, zipcode, DOB
            );
            basicInformationSteps.submitBasicInformation();
        } else {
            Assert.fail("Basic Information page is not displayed.");
        }
        Assert.assertTrue(basicInformationSteps.basicInformationPageIsDisplayed(),
                "user stays on basic Information Page");
        basicInformationSteps.validateDOBError(expectedError);
        logger.info("user successfully validates error message on Basic Information Page");
    }
    @AfterMethod
    public void cleanUp() {
        // Clean up browser state between tests
        browser.closeBrowser();
    }
    @AfterClass
    public void tearDown() {
        browser.closeBrowser();

    }
}
