package helper;

import cucumber.api.java.After;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hooks extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 15);

    @After
    public void clearTheCash(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.localStorage.clear();");
        driver.manage().deleteAllCookies();
    }

    @After("@Sign_Out")
    public void signout(){
        String newUrl = driver.getCurrentUrl().replaceAll("(?<=en\\/).*","").concat("account");
        driver.navigate().to(newUrl);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Logout']/parent::div")));
        driver.findElement(By.xpath("//span[text()='Logout']/parent::div")).click();
    }

}
