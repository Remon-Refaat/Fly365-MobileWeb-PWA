package step_definition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 15);

    By emailAddressTXT = By.xpath("//input[@aria-label='Your Email']");
    By passwordTXT = By.xpath("//input[@aria-label='Password']");
    By signInBTN = By.xpath("//div[text()='Sign in']/parent::button");

    @And("^Add the email \"(.*)\" to the email field$")
    public void addTheEmailToTheEmailField(String emailAddress) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailAddressTXT));
        driver.findElement(emailAddressTXT).sendKeys(emailAddress);
    }

    @And("^Add the password \"([^\"]*)\" to the password field$")
    public void addThePasswordToThePasswordField(String password) {
        driver.findElement(passwordTXT).sendKeys(password);
    }

    @When("^Press on Sign In button$")
    public void pressOnSignInButton() {
        driver.hideKeyboard();
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInBTN));
        driver.findElement(signInBTN).click();
    }
}
