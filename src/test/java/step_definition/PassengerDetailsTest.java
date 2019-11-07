package step_definition;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import helper.GeneralMethods;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class PassengerDetailsTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 15);

    GeneralMethods gmObject = new GeneralMethods();

    By passengerFNTXT = By.xpath("//div[contains(@class,'passenger-form')]//input[@aria-label='First name']");
    By passengerMNTXT = By.xpath("//div[contains(@class,'passenger-form')]//input[@aria-label='Middle name (optional)']");
    By passengerLNTXT = By.xpath("//div[contains(@class,'passenger-form')]//input[@aria-label='Family name']");
    By passengerDayDDL = By.xpath("//div[contains(@class,'passenger-form')]//select[@placeholder='day']");
    By passengerMonthDDL = By.xpath("//div[contains(@class,'passenger-form')]//select[@placeholder='Month']");
    By passengerYearDDL = By.xpath("//div[contains(@class,'passenger-form')]//select[@placeholder='Year']");
    By saveBTN = By.xpath("//div[text()='Save']/parent::button");
    By contactFirstNameTXT = By.xpath("//form[@id='contactDetails']//input[@aria-label='First name']");
    By contactLastNameTXT = By.xpath("//form[@id='contactDetails']//input[@aria-label='Family name']");
    By contactEmailAddressTXT = By.xpath("//form[@id='contactDetails']//input[@aria-label='Email']");
    By contactPhoneNumberTXT = By.xpath("//form[@id='contactDetails']//input[@aria-label='Phone number']");
    By contactPhoneCountryTXT = By.xpath("//input[@aria-label='Code']");
    By contactPhoneCountrySearchTXT = By.xpath("//input[@aria-label='search for code']");
    By nextStepBTN = By.xpath("//button/child::div[text()='Next Step']");


    @And("^Add the following data in the passenger Details$")
    public void addTheFollowingDataInThePassengerDetails(DataTable passengerData) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passengerFNTXT));


        int i = 1;

        for (Map<String, String> passengerDetails : passengerData.asMaps(String.class, String.class)) {

            if (HomeTest.totalPassengersNumber > 1) {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='passengers']/div/div/div[" + i + "]")));
                driver.findElement(By.xpath("//*[@id='passengers']/div/div/div[" + i + "]")).click();

            }

            wait.until(ExpectedConditions.visibilityOfElementLocated(passengerFNTXT));
            driver.findElement(passengerFNTXT).sendKeys(passengerDetails.get("First Name"));
            driver.findElement(By.xpath("//div[contains(@class,'passenger-form')]//input[@aria-label='" + passengerDetails.get("Title") + "']/parent::div")).click();
            driver.findElement(passengerMNTXT).sendKeys(passengerDetails.get("Middle Name"));
            driver.findElement(passengerLNTXT).sendKeys(passengerDetails.get("Last Name"));
            gmObject.selectDateFromDDL(passengerDayDDL, passengerDetails.get("Day"));
            driver.findElement(passengerMonthDDL).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'passenger-form')]//select[@placeholder='Month']/option[@label='" + passengerDetails.get("Month") + "']")));
            driver.findElement(By.xpath("//div[contains(@class,'passenger-form')]//select[@placeholder='Month']/option[@label='" + passengerDetails.get("Month") + "']")).click();
            gmObject.selectDateFromDDL(passengerYearDDL, passengerDetails.get("Year"));

            if (HomeTest.totalPassengersNumber > 1) {
                driver.findElement(saveBTN).click();

            }

            i++;

        }


    }

    @And("^Add the following data in the Contact Details$")
    public void addTheFollowingDataInTheContactDetails(DataTable contactData) {

        for (Map<String, String> contactDetails : contactData.asMaps(String.class, String.class)) {

            driver.findElement(contactFirstNameTXT).sendKeys(contactDetails.get("First Name"));
            driver.findElement(By.xpath("//form[@id='contactDetails']//label[text()='" + contactDetails.get("Title") + "']/preceding-sibling::div")).click();
            driver.findElement(contactLastNameTXT).sendKeys(contactDetails.get("Last Name"));
            driver.findElement(contactEmailAddressTXT).sendKeys(contactDetails.get("Email"));
            driver.findElement(contactPhoneCountryTXT).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(contactPhoneCountrySearchTXT));
            driver.findElement(contactPhoneCountrySearchTXT).sendKeys(contactDetails.get("Phone Country"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + contactDetails.get("Phone Country") + "']")));
            driver.findElement(By.xpath("//span[text()='" + contactDetails.get("Phone Country") + "']")).click();
            driver.findElement(contactPhoneNumberTXT).sendKeys(contactDetails.get("Phone Number"));

        }
    }


    @And("^Click on Next Step$")
    public void clickOnNextStep() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nextStepBTN));
        driver.findElement(nextStepBTN).click();
    }


}
