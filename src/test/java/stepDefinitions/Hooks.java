package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.Driver;

import java.time.Duration;

import static utilities.Driver.getDriver;

public class Hooks {

    public static WebDriver webDriver;

    @Before
    public void openBrowser() {
        System.out.println("Opening Browser");
        webDriver = Driver.getDriver();
        webDriver.manage().deleteAllCookies();
        webDriver.manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario) {

        final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
        if (scenario.isFailed()) {
            scenario.attach(screenshot, "image/png", "screenshots");
        }
        Driver.closeDriver();


    }
}
