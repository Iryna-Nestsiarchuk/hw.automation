package junitcucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScenarioContext {
    private static ScenarioContext scenarioContext;
    private WebDriver webDriver;

    private ScenarioContext() {
        webDriver = new ChromeDriver();
    }

    public static ScenarioContext getInstanceOfScenarioContextClass() {
        if (scenarioContext == null) {
            scenarioContext = new ScenarioContext();
        }
        return scenarioContext;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}

