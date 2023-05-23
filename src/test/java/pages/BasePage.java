package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;


public class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void HomePage(){
        String url = System.getProperty("base.url") != null ? System.getProperty("base.url") : ConfigReader.getProperty("url");
        Driver.getDriver().get(url);
    }

}