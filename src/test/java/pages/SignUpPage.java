package pages;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.PageHelper;

public class SignUpPage extends BasePage {

    Faker faker = new Faker();
    Actions actions = new Actions(Driver.getDriver());

    public SignUpPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//h2[text()='New User Signup!']")
    public WebElement newUserSingUpText;

    @FindBy(css = "input[data-qa='signup-name']")
    public WebElement nameBox;

    @FindBy(css = "input[data-qa='signup-email']")
    public WebElement email;

    @FindBy(css = "button[data-qa='signup-button']")
    public WebElement singupButton;

    @FindBy(css = "#uniform-id_gender1")
    public WebElement genderText;

    @FindBy(css = "input[id='password']")
    public WebElement passwordBox;

    @FindBy(css = "select[id='days']")
    public WebElement days;

    @FindBy(css = "select[id='months']")
    public WebElement month;

    @FindBy(css = "select[id='years']")
    public WebElement year;

    @FindBy(css = "label[for='newsletter']")
    public WebElement newsLetterButton;

    @FindBy(css = "label[for='optin']")
    public WebElement partnersButton;

    @FindBy(css = "input[id='first_name']")
    public WebElement firstNameBox;

    @FindBy(css = "button[data-qa='create-account']")
    public WebElement createAccount;

    @FindBy(xpath = "//*[text()='Account Created!']")
    public WebElement accountCreatedText;

    public void verifyUserSignUpText() {
        Assert.assertTrue(newUserSingUpText.isDisplayed());
    }

    public void fillNameAndEmail() {
        nameBox.sendKeys(ConfigReader.getProperty("name"));
        email.sendKeys(faker.internet().emailAddress());
    }

    public void clickSignUpButton() {
        singupButton.click();
    }

    public void fillUserInformation() {
        genderText.click();
        passwordBox.sendKeys(faker.internet().password());
        PageHelper.pageDown();
        days.sendKeys(ConfigReader.getProperty("birthday"));
        month.sendKeys(ConfigReader.getProperty("birthMonth"));
        year.sendKeys(ConfigReader.getProperty("birthYear"));
    }

    public void selectAllCheckBox() {
        newsLetterButton.click();
        partnersButton.click();
    }

    public void fillUserAddressInformation() {
        actions = new Actions(Driver.getDriver());
        actions.click(firstNameBox).sendKeys(ConfigReader.getProperty("name")).sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("lastname")).sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("company")).sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("address")).sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("address2")).sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("country")).sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("state")).sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("city")).sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("zipCode")).sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("mobileNumber")).perform();
    }

    public void clickCreateAccountButton() {
        createAccount.click();
    }

    public void verifyCreateAccountText() {
        Assert.assertTrue(accountCreatedText.isDisplayed());
    }
}
