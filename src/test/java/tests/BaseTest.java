package tests;

import common.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;


public class BaseTest {

    public AppiumDriver mobileDriver;

    @BeforeTest
    public void beforeTest() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "MacOSX");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability("newCommandTimeout", 2000);
        mobileDriver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @BeforeTest
    public void launchBrowser() {
        mobileDriver.get(Constants.URL);
        Assert.assertEquals(mobileDriver.getCurrentUrl(), Constants.URL, "URL Mismatch");
    }

    @AfterTest
    public void afterTest() {
        mobileDriver.quit();
    }
}