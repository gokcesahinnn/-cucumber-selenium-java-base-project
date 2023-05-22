package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;

import java.time.Duration;

public class BasePage {

    public WebDriverWait webDriverWait;
    protected WebDriver webDriver;

    @Deprecated
    protected BasePage(WebDriver webDriver, long timeoutInSeconds) {
        this(webDriver, Duration.ofSeconds(timeoutInSeconds));
        new WebDriverWait(webDriver, Duration.ofSeconds(1));
    }

    public BasePage(WebDriver webDriver, Duration ofSeconds) {
    }

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void HomePage(){
        String url = System.getProperty("base.url") != null ? System.getProperty("base.url") : ConfigReader.getProperty("url");
        webDriver.navigate().to(url);
    }

}