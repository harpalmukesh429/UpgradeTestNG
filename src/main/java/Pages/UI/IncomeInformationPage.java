package Pages.UI;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IncomeInformationPage extends BasePage {
	private static IncomeInformationPage instance;

	@FindBy(xpath = "//h1[contains(text(),'How much money do you make in a year?')]")
	private WebElement pg_Header;

	@FindBy(name = "borrowerIncome")
	private WebElement input_borrowerIncome;

	@FindBy(name = "borrowerAdditionalIncome")
	private WebElement input_borrowerAdditionalIncome;

	@FindBy(xpath = "//button[@data-auto='continuePersonalInfo']")
	private WebElement btn_continue;

	// Constructor
	public IncomeInformationPage() {
        super();
		PageFactory.initElements(driver, this);
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
	public IncomeInformationPage clickContinueButton() {
		click(btn_continue);
		return this;
	}

	}


