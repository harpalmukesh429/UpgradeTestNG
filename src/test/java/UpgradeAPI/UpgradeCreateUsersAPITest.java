package UpgradeAPI;

import StepDefinitions.API.UpgradeAPISteps;
import StepDefinitions.UISteps.BasicInformationSteps;
import StepDefinitions.UISteps.HomePageSteps;
import StepDefinitions.UISteps.IncomeInformationSteps;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.Browser;
import utilities.DataProviderUtils;

public class UpgradeCreateUsersAPITest {
    private HomePageSteps homePageSteps;
    private BasicInformationSteps basicInformationSteps;
    private IncomeInformationSteps incomeInformationSteps;
    private
    Browser browser = Browser.getInstance();
    private static final Logger logger = LogManager.getLogger(UpgradeCreateUsersAPITest.class);

    private UpgradeAPISteps upgradeAPISteps;

    @BeforeClass
    public void setup() {
        upgradeAPISteps = new UpgradeAPISteps();
    }

    @Test
    public void testPostUsersAPIValidDetailsDataProvider(String name, String job, String StatusCode, String TestID) {
        logger.info(TestID + "The test case started");
        upgradeAPISteps.postCreateUsers(name, job);
        upgradeAPISteps.validateStatusCode(StatusCode);

    }
    @Test
    @Parameters({"name", "job", "StatusCode", "TestID"})
    public void testPostUsersAPIValidDetailsParameter(String name, String job, String StatusCode, String TestID) {
        logger.info(TestID + "The test case started");
        upgradeAPISteps.postCreateUsers(name, job);
        upgradeAPISteps.validateStatusCode(StatusCode);
        // Validate the response body
        upgradeAPISteps.validateResponseBody(name, job);
    }


}
