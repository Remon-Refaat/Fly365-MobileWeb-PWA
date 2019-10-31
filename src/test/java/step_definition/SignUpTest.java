package step_definition;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class SignUpTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 15);

    By signInRegisterBTN = By.xpath("//aside//button");
    By registerTAB = By.xpath("//a[text()='Register']");
    By firstNameTXT = By.xpath("//input[@aria-label='First Name']");
    By lastNameTXT = By.xpath("//input[@aria-label='Family Name']");
    By emailTXT = By.xpath("//input[@aria-label='Your Email']");
    By passwordTXT = By.xpath("//input[@aria-label='Password']");
    By registerBTN = By.xpath("//div[text()='Register']");




    @And("^Press on Sign in or register now button$")
    public void pressOnSignInOrRegisterNowButton() {
        driver.findElement(signInRegisterBTN).click();
    }

    @And("^Click on Register Link$")
    public void clickOnRegisterLink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerTAB));
        driver.findElement(registerTAB).click();
    }

    @And("^Fill the following required data$")
    public void fillTheFollowingRequiredData(DataTable usersData) {
        for (Map<String, String> userData : usersData.asMaps(String.class, String.class)) {
            driver.findElement(firstNameTXT).sendKeys(userData.get("First Name"));
            driver.findElement(lastNameTXT).sendKeys(userData.get("Last Name"));
            driver.findElement(emailTXT).sendKeys(userData.get("Email Address"));
            driver.findElement(passwordTXT).sendKeys(userData.get("Password"));
        }
    }

    @And("^Click on Register button$")
    public void clickOnRegisterButton()  {
        driver.findElement(registerBTN).click();
    }



}
