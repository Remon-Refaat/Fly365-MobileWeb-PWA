package step_definition;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Map;

public class MyPaymentTest extends TestBase {

    public static String cardNumber;
    public static String cardHolder;
    WebDriverWait wait = new WebDriverWait(driver, 15);

    By addCardBTN = By.xpath("//h2[text()='My cards']/parent::div//*[local-name() = 'svg']");
    By cardHolderTXT = By.xpath("//input[@aria-label='Name on card']");
    By cardNumberTXT = By.xpath("//input[@aria-label='Card number']");
    By expiryDateTXT = By.xpath("//input[@aria-label='Card expiry date']");
    By cvvTXT = By.xpath("//input[@aria-label='CVV']");
    By SaveBTN = By.xpath("//div[text()='Save']/parent::button/parent::div");

    @And("^Press on add payment button$")
    public void pressOnAddPaymentButton()  {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addCardBTN));
        driver.findElement(addCardBTN).click();
    }

    @And("^Add the following payment card details$")
    public void addTheFollowingPaymentCardDetails(DataTable paymentDetails) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardHolderTXT));

        for (Map<String, String> paymentData : paymentDetails.asMaps(String.class, String.class)) {

            driver.findElement(cardHolderTXT).sendKeys(paymentData.get("Holder Name"));
            driver.findElement(cardNumberTXT).sendKeys(paymentData.get("Card Number"));
            driver.findElement(expiryDateTXT).sendKeys(paymentData.get("Expiry Date"));
            driver.findElement(cvvTXT).sendKeys(paymentData.get("CVV"));

            cardNumber = paymentData.get("Card Number");
            cardHolder = paymentData.get("Holder Name");
        }
    }

    @And("^Click Save button$")
    public void clickSaveBuuton() {
        driver.findElement(SaveBTN).click();
    }

    @And("^Card is added successfully$")
    public void cardIsAddedSuccessfully() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='"+cardHolder+"']/following-sibling::span")));
        String actualNumber = driver.findElement(By.xpath("//h3[text()='"+cardHolder+"']/following-sibling::span")).getText();
        Assert.assertEquals(actualNumber.substring(actualNumber.length()-4), cardNumber.substring(cardNumber.length()-4));
    }


}
