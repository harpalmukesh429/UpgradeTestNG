package Pages;


import org.openqa.selenium.By;

public class IncomeInformationPage extends BasePage<IncomeInformationPage> {

	private final By pg_Header = By.xpath("//h1[contains(text(),'How much money do you make in a year?')]");
	private final By input_borrowerIncome = By.name("borrowerIncome");
	private final By input_borrowerAdditionalIncome = By.name("borrowerAdditionalIncome");

	private final By btn_continue = By.xpath("//button[@data-auto='continuePersonalInfo']");
	// Constructor
	public IncomeInformationPage() {
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

	public Boolean incomeinformationPageLoaded() {
	    return isDisplayed(pg_Header);
	}
	public IncomeInformationPage enterborrowerIncome(String value) {
		return sendKeys(input_borrowerIncome,value);
	}
	public IncomeInformationPage enterAdditionalIncome(String value) {
		return sendKeys(input_borrowerAdditionalIncome,value);
	}



	public void clickContinueButton() {
		click(btn_continue);
	}

	}
	

