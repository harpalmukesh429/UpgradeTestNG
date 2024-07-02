package StepDefinitions.UISteps;

import Pages.UI.IncomeInformationPage;

public class IncomeInformationSteps {
    private final IncomeInformationPage incomeInformationPage;

    // Constructor
    public IncomeInformationSteps() {
        incomeInformationPage = new IncomeInformationPage();
    }

    // Method to verify if the home page is displayed
    public boolean incomeInformationPageIsDisplayed() {
        return incomeInformationPage.incomeinformationPageLoaded();
    }

    // Method to select a product on the home page

}
