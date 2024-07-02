package Pages;


import org.openqa.selenium.By;

public class HomePage extends BasePage<HomePage> {
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
        return click(we_HomePage);
    }

    public HomePage clickMainMenu(String menuName) {
        return click(getMainMenu(menuName));
    }

    public HomePage clickMainMenuDropDown(String menuItem) {
        return click(getMainMenuDropDown(menuItem));
    }

    public HomePage setLoanAmount(String amount) {
        return sendKeys(input_loanAmount, amount);
    }

    public HomePage selectLoanPurpose(String purpose) {
        return selectFromDropdown(select_LoanPurpose, purpose);
    }
    public void clickcheckYourRate() {
        click(btn_checkYourRate);
    }
}
