package stepDefinitions;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class BaseSteps {

    private WebDriver webDriver = Hooks.webDriver;
    BasePage basePage = new BasePage(webDriver);

    public BaseSteps() {
    }

    @When("user on the homepage")
    public void openHomePage() {
        basePage.HomePage();
    }
}
