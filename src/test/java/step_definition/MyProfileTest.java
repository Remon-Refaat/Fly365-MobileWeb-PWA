package step_definition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MyProfileTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 15);

    By paymentLINK = By.xpath("//span[text()='Payment']/parent::div");
    By travellerLINK = By.xpath("//span[text()='Travellers']/parent::div");
    By myProfileHDR = By.xpath("//*[@id='app']/div/main/div/div/a/div[1]/div[2]/span/div");


    @Then("^The user profile of \"(.*)\" is opened successfully$")
    public void theUserProfileOfIsOpenedSuccessfully(String profileName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(myProfileHDR));
        Assert.assertEquals(driver.findElement(myProfileHDR).getText().toUpperCase(), profileName.toUpperCase());
    }

    @And("^Press on payment tab$")
    public void pressOnPaymentTab() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentLINK));
        driver.findElement(paymentLINK).click();
    }

    @And("^Press on traveller tab$")
    public void pressOnTravellerTab() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(travellerLINK));
        driver.findElement(travellerLINK).click();
    }
}
