package StepDefinitions.UISteps;

import Pages.UI.HomePage;
import org.testng.Assert;


public class HomePageSteps {
    private final HomePage homePage;

    // Constructor
    public HomePageSteps() {
        homePage = new HomePage();
    }

    // Method to verify if the home page is displayed
    public boolean homePageIsDisplayed() {
        return homePage.pageIsDisplayed();
    }

    // Method to select a product on the home page
    public void selectProductOnHomePage(String menuName, String menuItem) {
        if (homePageIsDisplayed()) {
            homePage.clickMainMenu(menuName)
                    .clickMainMenuDropDown(menuItem);
        }
        else {
                Assert.fail("Home page is not displayed.");
            }
    }
    public void selectLoanAmountAndPurpose(String amount, String purpose) {
    homePage.setLoanAmount(amount).selectLoanPurpose(purpose);
    }
    public void enterCheckYourRateInfo(String amount, String purpose) {
        homePage.setLoanAmount(amount).selectLoanPurpose(purpose).clickcheckYourRate();
    }
    // Method to set loan amount
    public void setLoanAmount(String amount) {
        homePage.setLoanAmount(amount);
    }

    // Method to select loan purpose
    public void selectLoanPurpose(String purpose) {
        homePage.selectLoanPurpose(purpose);
    }
    public void clickcheckYourRate() {
        homePage.clickcheckYourRate();
    }
}
