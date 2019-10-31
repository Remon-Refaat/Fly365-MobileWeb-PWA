package step_definition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ContactUsTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 15);

    By fullNameTXT = By.xpath("//input[@aria-label='Full name']");
    By emailTXT = By.xpath("//input[@aria-label='Email']");
    By messageTXT = By.xpath("//textarea[@aria-label='Message']");
    By categoryDDL = By.xpath("//input[@aria-label='Category']/parent::div");
    By sendBTN = By.xpath("//div[text()='Send']/parent::button");


    @And("^Add \"(.*)\" to the Full Name field$")
    public void addToTheFullNameField(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(fullNameTXT));
        driver.findElement(fullNameTXT).sendKeys(name);

    }

    @And("^Add \"(.*)\" to the Email field$")
    public void addToTheEmailField(String email) {
        driver.findElement(emailTXT).sendKeys(email);

    }

    @And("^Choose a Category \"(.*)\"$")
    public void chooseACategory(String category)  {
        driver.findElement(categoryDDL).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='"+category+"']")));
        driver.findElement(By.xpath("//div[text()='"+category+"']")).click();

    }

    @And("^Add a message$")
    public void addAMessage() {
        driver.findElement(messageTXT).sendKeys("I want to ask about my airline reference");
    }

    @And("^Click on Send$")
    public void clickOnSend() {
        driver.findElement(sendBTN).click();

    }

    @Then("^\"(.*)\" message will be displayed$")
    public void successfullyMessageWillBeDisplayed(String message) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=\""+message+"\"]")));
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()=\""+message+"\"]")).isDisplayed());
    }

}
