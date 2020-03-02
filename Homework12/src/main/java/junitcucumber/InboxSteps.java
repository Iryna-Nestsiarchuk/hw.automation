package junitcucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class InboxSteps {
    private WebDriver webDriver;
    private InboxPage inboxPage;
    private static int NUMBER_OF_EMAILS = 2;

    public InboxSteps() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nestsiarchuk_IV\\Desktop\\Automation\\chromedriver.exe");
        inboxPage = new InboxPage();
        webDriver = ScenarioContext.getInstanceOfScenarioContextClass().getWebDriver();
    }

    @When("^I click the checkbox$")
    public void checkEmails() {
        inboxPage.checkEmails(NUMBER_OF_EMAILS);
    }

    @Then("^Checkmarks next to emails are displayed$")
    public void checkmarksAreDisplayed() {
        int expectedResult = NUMBER_OF_EMAILS;
        int actualResult = inboxPage.getCheckedEmailsCount();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @When("^I click the checked checkbox$")
    public void uncheckAllCheckedEmails() {
        inboxPage.uncheckAllCheckedEmails();
    }

    @Then("^Checkmarks next to emails are not displayed$")
    public void checkmarksAreNotDisplayed() {
        int expectedResult = 0;
        int actualResult = inboxPage.getCheckedEmailsCount();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @When("^I click the \"Написать письмо\" button$")
    public void clickWriteEmailButton() {
        inboxPage.clickWriteEmailButton();
    }

    @When("^Fill the \"Кому\", \"Тема\" and text fields with valid data$")
    public void fillEmailFields() {
        inboxPage.fillEmailFields("irina.nesterch@gmail.com palkanov.vlad@gmail.com", "Test", "Test");
    }

    @When("^Click \"Отправить\" button$")
    public void clickSendEmailButton() {
        inboxPage.clickSendEmailButton();
    }

    @Then("^\"Письмо отправлено\" notification appears$")
    public void seeSentEmailNotification() {
        Assert.assertTrue(inboxPage.sentEmailNotificationPresents());
    }

    @After
    public void afterClass() {
        webDriver.quit();
    }
}
