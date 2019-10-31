package step_definition;

import cucumber.api.java.en.Then;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ConfirmationTest extends TestBase {
    WebDriverWait wait = new WebDriverWait(driver, 20);

    By bookingConfirmationSuccessfulMSG = By.xpath("//p[contains(text(),'Thank')]");

    @Then("^'Thank you for booking with Fly365' message is displayed$")
    public void thankYouForBookingWithFlyMessageIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bookingConfirmationSuccessfulMSG));
        Assert.assertTrue(driver.findElement(bookingConfirmationSuccessfulMSG).isDisplayed());
    }

}
