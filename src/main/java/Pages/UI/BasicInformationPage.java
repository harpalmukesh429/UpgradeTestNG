package Pages.UI;


import org.openqa.selenium.By;

public class BasicInformationPage extends BasePage {
public static BasicInformationPage instance;
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
    public static BasicInformationPage getInstance() {
        if(instance==null) {
            instance = new BasicInformationPage();
        }
        return  instance;
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
        sendKeys(input_borrowerFirstName, value);
        return this;
    }

    public BasicInformationPage enterborrowerLastName(String value) {
        sendKeys(input_borrowerLastName, value);
        return this;
    }

    public BasicInformationPage enterborrowerStreet(String value) {
        sendKeys(input_borrowerStreet, value);
        return this;
    }

    public BasicInformationPage enterborrowerCity(String value) {
        sendKeys(input_borrowerCity, value);
        return this;
    }

    public BasicInformationPage enterborrowerState(String value) {
         sendKeys(input_borrowerState, value);
        return this;
    }

    public BasicInformationPage enterborrowerZipCode(String value) {
        sendKeys(input_borrowerZipCode, value);
        return this;
    }

    public BasicInformationPage enterborrowerDateOfBirth(String value) {
        sendKeys(input_borrowerDateOfBirth, value);
        return this;
    }

    public String getDOBError() {
        return getText(err_borrowerDateOfBirth);
    }

    public BasicInformationPage  clickContinueButton() {
        click(btn_continue);
        return this;
    }

}
	

