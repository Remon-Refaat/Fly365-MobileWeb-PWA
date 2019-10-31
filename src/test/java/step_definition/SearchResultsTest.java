package step_definition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class SearchResultsTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 15);

    By firstTripBTN = By.xpath("//*[@id='search-results']/div[3]//div[1]/div[2]/div/div/div[2]//button");

    @And("^Choose a trip$")
    public void chooseATrip() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstTripBTN));
        driver.findElement(firstTripBTN).click();
    }


}
