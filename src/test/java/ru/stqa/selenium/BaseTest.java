package ru.stqa.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class BaseTest {

        public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
        public WebDriver driver;
        public WebDriverWait wait;

        @Before
        public void start() {

/*            if (tlDriver.get() != null) {
                driver = tlDriver.get();
                wait = new WebDriverWait(driver, 10);
                return;
            }
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(FirefoxDriver.MARIONETTE, false);
            driver = new ChromeDriver(caps);
            tlDriver.set(driver);
            System.out.println(((HasCapabilities) driver).getCapabilities());
            wait = new WebDriverWait(driver, 10);

            Runtime.getRuntime().addShutdownHook(
                    new Thread(() -> { driver.quit(); driver = null; }));
*/
            driver = new ChromeDriver();
            //driver = new FirefoxDriver();
            //driver = new InternetExplorerDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            wait = new WebDriverWait(driver, 10);
        }

        @After
        public void stop() {
            driver.quit();
            //driver = null;
        }
}
