package step_definition;

import cucumber.api.java.en.And;
import helper.TestBase;
import org.openqa.selenium.By;

public class ManageMyBookingTest extends TestBase {


    By manageMyBookingEmailTXT = By.xpath("//input[@aria-label='Email']");
    By FindBookingBTN = By.xpath("//div[text()='Find booking']/parent::button");

    @And("^Add a valid email address \"(.*)\"$")
    public void addAValidEmailAddress(String findMyBookingEmailAddress) {
        driver.findElement(manageMyBookingEmailTXT).sendKeys(findMyBookingEmailAddress);
    }

    @And("^Press Find Booking$")
    public void pressFindBooking() {

        driver.findElement(FindBookingBTN).click();
    }
}
