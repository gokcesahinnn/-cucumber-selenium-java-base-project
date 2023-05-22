package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import stepDefinitions.Hooks;
import utilities.ConfigReader;

public class HomeSteps {

    private WebDriver webDriver = Hooks.webDriver;
    HomePage homePage = new HomePage(webDriver);

    public HomeSteps() {
    }

    @Then("verify that home page is visible successfully")
    public void verify_that_home_page_is_visible_successfully() {
        String expectedUrl = webDriver.getCurrentUrl();
        String actualUrl = ConfigReader.getProperty("url");
        Assert.assertEquals(expectedUrl, actualUrl);
    }

    @When("click on sign up or login button")
    public void clickOnBlogMenuOnHomepage() {
        homePage.clickSignUpButton();
    }
}
