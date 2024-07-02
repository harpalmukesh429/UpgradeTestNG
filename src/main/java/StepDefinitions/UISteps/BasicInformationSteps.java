package StepDefinitions.UISteps;


import Pages.BasicInformationPage;
import org.testng.Assert;

public class BasicInformationSteps {
    private final BasicInformationPage basicInformationPage;

    // Constructor
    public BasicInformationSteps() {
        basicInformationPage = new BasicInformationPage();
    }

    // Method to verify if the home page is displayed
    public boolean basicInformationPageIsDisplayed() {
        return basicInformationPage.basicInformationPageLoaded();
    }

    public void enterBasicInformation(String firstName, String lastName, String street, String state, String city, String zipcode, String DOB) {
        basicInformationPage.enterborrowerFirstName(firstName).enterborrowerLastName(lastName)
                .enterborrowerStreet(street)
                .enterborrowerState(state)
                .enterborrowerCity(city)
                .enterborrowerZipCode(zipcode)
                .enterborrowerDateOfBirth(DOB);
    }

    public void submitBasicInformation() {
        basicInformationPage.clickContinueButton();
    }

    public void validateDOBError(String errorMessage) {
        System.out.println("The expected Error Message: " + errorMessage
                + "\n Actual Error Message: " + basicInformationPage.getDOBError());
        Assert.assertEquals(basicInformationPage.getDOBError(), errorMessage);
    }
}
