package step_definition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainMenuTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 15);

    By mainMenuBTN = By.xpath("//div[@class='navigation-menu']");

    @Given("^Open the main menu$")
    public void openTheMainMenu() {
        driver.findElement(mainMenuBTN).click();

    }

    @And("^Press on \"(.*)\"$")
    public void pressOn(String linkName)  {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='"+linkName+"']/ancestor::a")));
        driver.findElement(By.xpath("//p[text()='"+linkName+"']")).click();

    }

}
