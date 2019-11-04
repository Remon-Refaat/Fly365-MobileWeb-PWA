package step_definition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import helper.APIUtility;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ManageMyBookingTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 15);

    APITest apiTestObject = new APITest();

    By manageMyBookingEmailTXT = By.xpath("//input[@aria-label='Email']");
    By manageMyBookingRefTXT = By.xpath("//input[@aria-label='Fly365 Reference']");
    By FindBookingBTN = By.xpath("//div[text()='Find booking']/parent::button");
    By flyReferenceHDR = By.xpath("//strong[text()='Fly365 Ref.']");
    By flyReferenceNumberHDR = By.xpath("//strong[text()='Fly365 Ref.']/following-sibling::span");

    @And("^Add a valid email address \"(.*)\"$")
    public void addAValidEmailAddress(String findMyBookingEmailAddress) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(manageMyBookingEmailTXT));
        driver.findElement(manageMyBookingEmailTXT).sendKeys(findMyBookingEmailAddress);
    }

    @And("^Add a valid Fly365 Reference$")
    public void addAValidFly365Reference()  {
        driver.findElement(manageMyBookingRefTXT).sendKeys(apiTestObject.fly365Reference);
    }

    @And("^Press Find Booking$")
    public void pressFindBooking() {

        driver.findElement(FindBookingBTN).click();
    }


    @Then("^The system will retrieve the details of the Booking Correctly$")
    public void theSystemWillRetrieveTheDetailsOfTheBookingForThis()  {
        wait.until(ExpectedConditions.visibilityOfElementLocated(flyReferenceHDR));
        String actualNumber = driver.findElement(flyReferenceNumberHDR).getText();
        Assert.assertEquals(actualNumber, apiTestObject.fly365Reference);
    }
}
