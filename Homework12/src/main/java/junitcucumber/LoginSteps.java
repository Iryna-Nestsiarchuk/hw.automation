package junitcucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    private static final String MAIN_URL = "http://mail.ru";
    private static final String LOGIN = "irina.nesterch";
    private static final String PASSWORD = "ihearyounow17031996";
    private LoginPage loginPage;
    private WebDriver webDriver;

    public LoginSteps() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nestsiarchuk_IV\\Desktop\\Automation\\chromedriver.exe");
        loginPage = new LoginPage();
        webDriver = ScenarioContext.getInstanceOfScenarioContextClass().getWebDriver();
        webDriver.manage().window().maximize();
    }

    @Given("^I am on main application page$")
    public void loadMainPage() {
        webDriver.get(MAIN_URL);
    }

    @When("^I login as correct user$")
    public void loginAsCorrectUser() {
        loginPage.enterLogin(LOGIN);
        loginPage.enterPassword(PASSWORD);
    }

    @Then("^I see logout link$")
    public void seeLogoutLink() {
        Assert.assertTrue(loginPage.logoutLinkPresents());
    }
}
