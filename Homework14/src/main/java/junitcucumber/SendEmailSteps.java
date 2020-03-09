package junitcucumber;

import com.applitools.eyes.TestResultContainer;
import com.applitools.eyes.TestResultsSummary;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public class SendEmailSteps {
    private static final String MAIN_URL = "http://mail.ru";
    private static final String LOGIN = "irina.nesterch";
    private static final String PASSWORD = "ihearyounow17031996";
    private LoginPage loginPage;
    private SendEmail sendEmail;
    private Screenshot screenshot;
    private WebDriver webDriver;

    public SendEmailSteps() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nestsiarchuk_IV\\Desktop\\Automation\\chromedriver.exe");
        loginPage = new LoginPage();
        sendEmail = new SendEmail();
        webDriver = ScenarioContext.getInstanceOfScenarioContextClass().getWebDriver();
        screenshot = Screenshot.getInstanceOfScreenshotClass();
    }

    @Given("^I logged in the mailbox$")
    public void logIntoInbox() {
        webDriver.get(MAIN_URL);
        webDriver.manage().window().maximize();
        loginPage.loginIntoMailbox(LOGIN, PASSWORD);
        screenshot.takeScreenshotOfWindow("Inbox page");
    }

    @When("^I click 'Написать письмо' button$")
    public void clickWriteEmailButton() throws InterruptedException {
        sendEmail.clickWriteEmailButton();
        sendEmail.resizeWindow();
        screenshot.takeScreenshotOfWindow("Empty email form");
    }

    @When("^fill 'Кому' field$")
    public void fillReceiverField() {
        sendEmail.fillReceiverField("irina.nesterch@gmail.com");
        sendEmail.resizeWindow();
        screenshot.takeScreenshotOfWindow("Email form filled with receiver");
    }

    @When("^fill 'Тема' field$")
    public void fillSubjectField() {
        sendEmail.fillSubjectField("subject");
        sendEmail.resizeWindow();
        screenshot.takeScreenshotOfWindow("Email form filled with subject");;
    }

    @When("^fill text field$")
    public void fillTextField() throws InterruptedException {
        sendEmail.fillTextField("Text");
        sendEmail.resizeWindow();
        screenshot.takeScreenshotOfWindow("Email form filled with text");
    }

    @When("^click 'Отправить' button$")
    public void clickSendEmailButton() {
        sendEmail.clickSendEmailButton();
        screenshot.takeScreenshotOfWindow("Email is sent notification");
    }

    @Then("^The screenshots are like the ones in the baseline$")
    public void seeSentEmailNotification() {
        TestResultsSummary testResults = screenshot.getAllTestResults();
        for (TestResultContainer result: testResults
             ) {
            Assert.assertTrue(result.getTestResults().isPassed());
        }
    }
    @After
    public void afterClass() {
        screenshot.getEyes().closeAsync();
        webDriver.quit();
        screenshot.getEyes().abortIfNotClosed();
    }
}

