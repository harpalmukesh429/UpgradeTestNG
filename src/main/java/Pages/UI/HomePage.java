package Pages.UI;


import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private static final By we_HomePage = By.xpath("(//header//a[@aria-label='Homepage'])[1]");
    private static final String we_MainMenu = "//span[text()='%s']";
    private static final String link_MainMenuDropDown = "//span[text()='%s']";
    private static final By input_loanAmount = By.name("desiredAmount");
    private static final By select_LoanPurpose = By.name("loan-purpose");
    private static final By btn_checkYourRate = By.id("pl-loan-form-submit");

    public HomePage() {
        super();
    }

    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }

    @Override
    public boolean pageIsDisplayed() {
        return isDisplayed(we_HomePage);
    }

    public By getHomePage() {
        return we_HomePage;
    }

    public By getMainMenu(String menuName) {
        return By.xpath(String.format(we_MainMenu, menuName));
    }

    public By getMainMenuDropDown(String menuItem) {
        return By.xpath(String.format(link_MainMenuDropDown, menuItem));
    }

    public By getInputLoanAmount() {
        return input_loanAmount;
    }

    public By getSelectLoanPurpose() {
        return select_LoanPurpose;
    }

    public String getPageTitle(String title) {
        return getPageTitle();
    }

    public HomePage clickHomePage() {
        click(we_HomePage);
        return this;
    }

    public HomePage clickMainMenu(String menuName) {
         click(getMainMenu(menuName));
        return this;
    }

    public HomePage clickMainMenuDropDown(String menuItem) {
         click(getMainMenuDropDown(menuItem));
        return this;
    }

    public HomePage setLoanAmount(String amount) {
         sendKeys(input_loanAmount, amount);
        return this;
    }

    public HomePage selectLoanPurpose(String purpose) {
        selectFromDropdown(select_LoanPurpose, purpose);
        return this;
    }
    public HomePage clickcheckYourRate() {
        click(btn_checkYourRate);
        return this;
    }
}
