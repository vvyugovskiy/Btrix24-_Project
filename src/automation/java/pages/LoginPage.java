package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

public class LoginPage extends AbstractBasePage {

    @FindBy(name = "USER_LOGIN")
    private WebElement username;
//    public WebElement username2 = Driver.getDriver().findElement(By.id("prependedInput"));

    @FindBy(name = "USER_PASSWORD")
    private WebElement password;

    @FindBy(className = "login-btn")
    private WebElement submit;

    public LoginPage() {
        //to connect our webdriver, page class and page factory
        //PageFactory - used to use @FindBy annotations
        //PageFactory - helps to find elements easier
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void login(String usernameValue, String passwordValue) {
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(3);
    }

    /**
     * Method to login, version #2
     * Login as a default user
     * Credentials will be retrieved from configuration.properties file
     */
    public void login() {
        username.sendKeys(ConfigurationReader.getProperty("username"));
        BrowserUtils.wait(3);
        password.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.wait(3);
        submit.click();

        BrowserUtils.wait(3);
    }
}
