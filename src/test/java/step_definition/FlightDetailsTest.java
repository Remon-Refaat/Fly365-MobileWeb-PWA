package step_definition;

import cucumber.api.java.en.And;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetailsTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 15);

    By continueBTN = By.xpath("//button/child::div[text()='Continue']");

    @And("^Press on Continue Button")
    public void pressonContinueButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueBTN));
        driver.findElement(continueBTN).click();
    }
}
