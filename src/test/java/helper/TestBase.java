package helper;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;


public class TestBase extends AbstractTestNGCucumberTests {

    public static AndroidDriver<WebElement> driver;

    @BeforeSuite()
    public void startDriver() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"5.1");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"OPPO F1s");
//        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"9");
//        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 3 XL 2");
        caps.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);
        driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"),caps);
        driver.navigate().to("https://www.fly365stage.com/m/en/");


    }
}
