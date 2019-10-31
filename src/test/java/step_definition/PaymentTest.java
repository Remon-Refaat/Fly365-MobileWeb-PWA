package step_definition;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class PaymentTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 15);

    By cardHolderNameTXT = By.xpath("//input[@aria-label='Name on card']");
    By cardNumberTXT = By.xpath("//input[@aria-label='Card number']");
    By cardExpireDateTXT = By.xpath("//input[@aria-label='Card expiry date']");
    By cardCVVTXT = By.xpath("//input[@aria-label='CVV']");
    By acknowledgeBOX = By.xpath("//*[@id='rules-policy']/div/div[1]//input/parent::div");
    By fareRulesBOX = By.xpath("//*[@id='rules-policy']/div/div[2]//input/parent::div");
    By payNowBTN = By.xpath("//div[text()='pay now']/parent::button");

    @And("^Add a valid data for the credit card$")
    public void addAValidDataForTheCreditCard(DataTable paymentCardData) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(cardHolderNameTXT));

        for (Map<String, String> paymentCardDetails : paymentCardData.asMaps(String.class, String.class)) {
            driver.findElement(cardHolderNameTXT).sendKeys(paymentCardDetails.get("Card Holder Number"));
            driver.findElement(cardNumberTXT).sendKeys(paymentCardDetails.get("Card Number"));
            driver.findElement(cardExpireDateTXT).sendKeys(paymentCardDetails.get("Card Expire Date"));
            driver.findElement(cardCVVTXT).sendKeys(paymentCardDetails.get("Card CVV"));
        }


    }


    @And("^Select the passenger name as passport acknowledgment$")
    public void selectThePassengerNameAsPassportAcknowledgment() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(acknowledgeBOX));
        driver.findElement(acknowledgeBOX).click();
    }

    @And("^Select the Fare Rules and Terms and Conditions$")
    public void selectTheFareRulesAndTermsAndConditions() {
        driver.findElement(fareRulesBOX).click();

    }


    @And("^Press on Pay button$")
    public void pressOnPayButton()  {
        driver.findElement(payNowBTN).click();
    }

}
