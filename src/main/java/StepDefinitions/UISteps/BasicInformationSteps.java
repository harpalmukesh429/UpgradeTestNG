package StepDefinitions.UISteps;


import Pages.UI.BasicInformationPage;
import org.testng.Assert;
import utilities.ScreenshotUtil;

public class BasicInformationSteps {
    private final BasicInformationPage basicInformationPage;
    private ScreenshotUtil screenshotUtil= ScreenshotUtil.getInstance();
    // Constructor
    public BasicInformationSteps() {

        basicInformationPage = new BasicInformationPage();
    }

    // Method to verify if the home page is displayed
    public boolean basicInformationPageIsDisplayed() {
        screenshotUtil.takeScreenshot("Test");
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
