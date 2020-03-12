package junitcucumber;

import DBModel.DBGetter;
import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindCinemaSteps {
    private static final String MAIN_URL = "https://yandex.by/";
    private static final String SEARCH_QUERY = DBGetter.getDBFilm().get(0).getName();
    private final String API_KEY = "O8y9CxElA106swZB111JdpP3H68b106Wp4IqNHPzlPMaUr3to110";
    private final String APP_NAME = "Individual work";
    private final String TEST_NAME = "Find Cinema";
    private FindCinema findCinema;
    private WebDriver driver;
    private Eyes eyes;
    private ClassicRunner runner;

    public FindCinemaSteps() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nestsiarchuk_IV\\Desktop\\Automation\\chromedriver.exe");
        driver = new ChromeDriver();
        findCinema = new FindCinema(driver);
        runner = new ClassicRunner();
        eyes = new Eyes(runner);
        eyes.setApiKey(API_KEY);
        eyes.open(driver, APP_NAME, TEST_NAME);
        eyes.setMatchLevel(MatchLevel.LAYOUT);
    }

    @Given("^I am on the main application page$")
    public void getApplication() {
        driver.get(MAIN_URL);
        driver.manage().window().maximize();
    }

    @When("^I search in post category of yandex for a film$")
    public void searchFilm() {
        findCinema.navigateToPoster();
        findCinema.switchToOpenedWindow();
        findCinema.searchFilm(SEARCH_QUERY);
    }

    @And("^choose the founded film$")
    public void chooseFilm() {
        findCinema.clickFoundedResult();
    }

    @And("^select today's evening$")
    public void selectTime() {
        findCinema.selectTime();
    }

    @And("^take screenshot$")
    public void takeScreenshot() {
        eyes.checkWindow("Result");
    }

    @Then("^I see at least one founded cinema$")
    public void checkQueryResult() {
        Assert.assertTrue(findCinema.isAnyCinemas());
    }

    @And("^Screenshot the same as in the baseline$")
    public void checkScreenshot() {
        eyes.closeAsync();
        TestResultsSummary allTestResults = runner.getAllTestResults();
        Assert.assertTrue(allTestResults.getAllResults()[0].getTestResults().isPassed());
    }

    @After
    public void after() {
        driver.quit();
        eyes.abortIfNotClosed();
    }
}
