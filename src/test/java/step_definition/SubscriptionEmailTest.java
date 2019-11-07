package step_definition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SubscriptionEmailTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 15);

    By subscriptionEmailTXT = By.xpath("//input[@aria-label='Your email']");
    By subscribeBTN = By.xpath("//div[text()='subscribe']/parent::button/parent::div");

    @And("^Add the email address \"(.*)\" to Subscription Email field$")
    public void addTheEmailAddressToSubscriptionEmailField(String emailAddress) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(subscriptionEmailTXT));
        driver.findElement(subscriptionEmailTXT).sendKeys(emailAddress);
    }

    @When("^Press on Subscribe Button$")
    public void pressOnSubscribeButton() {
        driver.findElement(subscribeBTN).click();
    }

}
