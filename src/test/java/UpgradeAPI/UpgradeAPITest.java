package UpgradeAPI;

import Pages.API.UpgradeAPI;
import StepDefinitions.API.UpgradeAPISteps;
import StepDefinitions.UISteps.BasicInformationSteps;
import StepDefinitions.UISteps.HomePageSteps;
import StepDefinitions.UISteps.IncomeInformationSteps;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.*;

public class UpgradeAPITest {
    private HomePageSteps homePageSteps;
    private BasicInformationSteps basicInformationSteps;
    private IncomeInformationSteps incomeInformationSteps;
    private
    Browser browser = Browser.getInstance();
    private static final Logger logger = LogManager.getLogger(UpgradeAPITest.class);

    private UpgradeAPISteps upgradeAPISteps;

    @BeforeClass
    public void setup() {
        upgradeAPISteps = new UpgradeAPISteps();
    }

    @Test(dataProvider = "getUsersAPIValidDetails", dataProviderClass = DataProviderUtils.class, enabled = false)
    public void testGetUserByIdValidDetails(String userId, String StatusCode, String TestID) {
        upgradeAPISteps.getUserById(userId);
        upgradeAPISteps.validateStatusCode(StatusCode);
    }

    @Test
    @Parameters({"name", "job", "StatusCode", "TestID"})
    public void testPostUsersAPIValidDetails(String name, String job, String StatusCode, String TestID) {
        logger.info(TestID + "The test case started");
        upgradeAPISteps.postCreateUsers(name, job);
        upgradeAPISteps.validateStatusCode(StatusCode);
    }

//    @Test(dataProvider="getUsersAPI", dataProviderClass = DataProviderUtils.class)
//    public void testGetUserByIdInvalidDetails(String userId, int StatusCode,String TestID) {
//        upgradeAPISteps.getUserById(userId);
//        upgradeAPISteps.validateStatusCode(StatusCode);
//        upgradeAPISteps.getUserDetails(userId);
//    }
}
