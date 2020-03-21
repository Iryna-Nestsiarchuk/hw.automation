package junitcucumber.logic;

import core.browser.ScenarioContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junitcucumber.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSteps extends PageSteps {
    private LoginPage loginPage;
    WebDriver driver;

    public LoginSteps() {
        driver = ScenarioContext.getInstanceOfScenarioContextClass().getWebDriver();
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
    }

    @Given("^I am on main application page$")
    public void loadMainPage() {
        driver.get(MAIN_URL);
    }

    @When("^I login as correct user$")
    public void loginAsCorrectUser() {
        loginPage.login(LOGIN, PASSWORD);
    }

    @Then("^I see logout link$")
    public void seeLogoutLink() {
        Assert.assertTrue(loginPage.logoutLinkPresents());
    }

}
