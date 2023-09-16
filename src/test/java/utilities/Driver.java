package utilities;

import config.BaseConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {


    private Driver() {

    }

    static WebDriver driver;

    static ChromeOptions ops = new ChromeOptions();

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (BaseConfig.getInstance().getBrowser()) {
                case "chrome":
                    ops.addArguments("--remote-allow-origins=*");
                    if (BaseConfig.getInstance().getHeadless()) ops.addArguments("--headless");
                    WebDriverManager.chromedriver().clearDriverCache().setup();
                    driver = new ChromeDriver(ops);
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    ops.addArguments("--remote-allow-origins=*");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(ops);
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }
}
