package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;


public class BaseTest {

    public WebDriver driver;

    @BeforeTest
    public void beforeTest() {

        String browser = System.getProperty("browser");

        if (browser != null) {
            if (browser.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", "." + File.separator + "drivers" + File.separator + "chromedriver");
                driver = new ChromeDriver();
            } else if (browser.equals("firefox")) {
                System.setProperty("webdriver.firefox.driver", "." + File.separator + "drivers" + File.separator + "geckodriver");
                driver = new FirefoxDriver();
            } else {
                throw new RuntimeException("Does not support browser + " + browser);
            }
        }
        else {
            System.setProperty("webdriver.chrome.driver", "." + File.separator + "drivers" + File.separator + "chromedriver");
            driver = new ChromeDriver();
        }
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }


}