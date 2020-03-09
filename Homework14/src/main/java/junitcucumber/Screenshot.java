package junitcucumber;

import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.WebDriver;

public class Screenshot {
    private static Screenshot screenshot;
    private Eyes eyes;
    EyesRunner runner;
    private final String API_KEY = "O8y9CxElA106swZB111JdpP3H68b106Wp4IqNHPzlPMaUr3to110";
    private final String APP_NAME = "Homework13";
    private final String TEST_NAME = "junitcucumber.SendEmail";
    private WebDriver webDriver = ScenarioContext.getInstanceOfScenarioContextClass().getWebDriver();

    private Screenshot() {
        runner = new ClassicRunner();
        eyes = new Eyes(runner);
        eyes.setApiKey(API_KEY);
        eyes.open(webDriver, APP_NAME, TEST_NAME);
        eyes.setMatchLevel(MatchLevel.LAYOUT);
    }

    public static Screenshot getInstanceOfScreenshotClass() {
        if (screenshot == null) {
            screenshot = new Screenshot();
        }
        return screenshot;
    }

    public Eyes getEyes() {
        return eyes;
    }

    public void takeScreenshotOfWindow(String windowName) {
        eyes.checkWindow();
    }

    public TestResultsSummary getAllTestResults() {
        return runner.getAllTestResults();
    }
}