package testsZ;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.ProfilesIni;

import java.util.concurrent.TimeUnit;

public class BaseTestSuit {
    public WebDriver driver;

    @Before
    public void openDriver(){

        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        // Found driver file "geckodriver".

        ProfilesIni profileini = new ProfilesIni();
        FirefoxOptions options = new FirefoxOptions();

        options.setCapability("marionette", false);

        options.setProfile(profileini.getProfile("newSelenium"));
        // https://stackoverflow.com/questions/65293093/keep-me-login-in-geckodriver-selenium-java

        // Options to driver Created.

        driver = new FirefoxDriver(options);
        // New firefox instance.

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Delay until accepting a timeout.
    }

    @After
    public void closeDriver() {

        driver.quit();
        // Close window, driver shutdown.
    }
}
