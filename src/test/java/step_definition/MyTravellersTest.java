package step_definition;

import cucumber.api.java.en.And;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MyTravellersTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 15);

    By addTravellerBTN = By.xpath("//h2[text()='My travellers']/parent::div//*[local-name() = 'svg']");
    By addedTravellerHDR = By.xpath("//*[@id='account-travellers']//span");

    @And("^Press on add traveller button$")
    public void pressOnAddTravellerButton()  {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addTravellerBTN));
        driver.findElement(addTravellerBTN).click();
    }

    @And("^Traveller \"(.*)\" is added successfully$")
    public void travellerIsAddedSuccessfully(String travellerName) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(addedTravellerHDR));
            Assert.assertEquals(driver.findElement(addedTravellerHDR).getText(), travellerName);
    }
}
