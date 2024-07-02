package Pages;


import org.openqa.selenium.By;

public class BasicInformationPage extends BasePage<BasicInformationPage> {

    private final By pg_Header = By.xpath("//h1[contains(text(),'basic information')]");
    private final By input_borrowerFirstName = By.name("borrowerFirstName");
    private final By input_borrowerLastName = By.name("borrowerLastName");
    private final By input_borrowerStreet = By.name("borrowerStreet");
    private final By input_borrowerCity = By.name("borrowerCity");
    private final By input_borrowerState = By.name("borrowerState");
    private final By input_borrowerZipCode = By.name("borrowerZipCode");
    private final By input_borrowerDateOfBirth = By.name("borrowerDateOfBirth");
    private final By btn_continue = By.xpath("//button[@data-auto='continuePersonalInfo']");
    private final By err_borrowerDateOfBirth = By.xpath("//div[contains(@id,'borrowerDateOfBirth') and  @data-error]");

    // Constructor
    public BasicInformationPage() {
        super();
    }

    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }

    @Override
    public boolean pageIsDisplayed() {
        return false;
    }

    public Boolean basicInformationPageLoaded() {
        return isDisplayed(pg_Header);
    }

    public BasicInformationPage enterborrowerFirstName(String value) {
        return sendKeys(input_borrowerFirstName, value);
    }

    public BasicInformationPage enterborrowerLastName(String value) {
        return sendKeys(input_borrowerLastName, value);
    }

    public BasicInformationPage enterborrowerStreet(String value) {
        return sendKeys(input_borrowerStreet, value);
    }

    public BasicInformationPage enterborrowerCity(String value) {
        return sendKeys(input_borrowerCity, value);
    }

    public BasicInformationPage enterborrowerState(String value) {
        return sendKeys(input_borrowerState, value);
    }

    public BasicInformationPage enterborrowerZipCode(String value) {
        return sendKeys(input_borrowerZipCode, value);
    }

    public BasicInformationPage enterborrowerDateOfBirth(String value) {
        return sendKeys(input_borrowerDateOfBirth, value);
    }

    public String getDOBError() {
        return getText(err_borrowerDateOfBirth);
    }

    public void clickContinueButton() {
        click(btn_continue);
    }

}
	

