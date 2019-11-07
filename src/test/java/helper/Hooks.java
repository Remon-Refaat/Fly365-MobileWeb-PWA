package helper;

import cucumber.api.java.After;
import org.openqa.selenium.JavascriptExecutor;

public class Hooks extends TestBase {

    @After
    public void clearTheCash(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.localStorage.clear();");
        driver.manage().deleteAllCookies();
    }


}
