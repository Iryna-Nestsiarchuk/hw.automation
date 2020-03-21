package core.ui;

import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;
import core.browser.DriverManager;
import core.browser.DriverManagerFactory;
import core.browser.ScenarioContext;
import core.configuration.Configuration;
import org.openqa.selenium.WebDriver;

public class Screenshot {
    private static Screenshot screenshot;
    private Eyes eyes;
    private EyesRunner runner;
    private WebDriver driver = ScenarioContext.getInstanceOfScenarioContextClass().getWebDriver();

    private Screenshot() {
        runner = new ClassicRunner();
        eyes = new Eyes(runner);
        eyes.setApiKey(Configuration.getApplitoolsAPIKey());
        eyes.open(driver, Configuration.getApplitoolsAppName(), Configuration.getApplitoolsTestName());
        eyes.setMatchLevel(MatchLevel.LAYOUT);
    }

    public static Screenshot getInstanceOfScreenshotClass() {
        if (screenshot == null) {
            screenshot = new Screenshot();
        }
        return screenshot;
    }

    public void close() {
        getEyes().closeAsync();
        getEyes().abortIfNotClosed();
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
