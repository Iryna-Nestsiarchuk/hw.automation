package junitcucumber.logic;

import core.browser.ScenarioContext;
import core.parser.getter.XMLGetter;
import core.ui.Screenshot;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junitcucumber.pages.InboxPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class InboxSteps extends PageSteps {
    public static final int NUMBER_OF_EMAILS = 2;
    public static final String SUBJECT = XMLGetter.getEmails().get(0).getSubject();
    public static final String RECEIVER = XMLGetter.getEmails().get(0).getReceiver();
    public static final String TEXT = XMLGetter.getEmails().get(0).getText();
    private WebDriver driver;
    private Screenshot screenshot;
    private InboxPage inboxPage;
    private SpamPage spamPage;

    public InboxSteps() {
        driver = ScenarioContext.getInstanceOfScenarioContextClass().getWebDriver();
        inboxPage = new InboxPage(driver);
        spamPage = new SpamPage(driver);
    }

    @Given("^I am in the inbox page$")
    public void getInboxPage() {
        driver.get("https://e.mail.ru/inbox/?back=1");
    }

    @When("^I click the checkbox$")
    public void checkEmails() {
        inboxPage.checkEmails(NUMBER_OF_EMAILS);
    }

    @Then("^Checkmarks next to emails are displayed$")
    public void displayCheckmarks() {
        int expectedResult = NUMBER_OF_EMAILS;
        int actualResult = inboxPage.getCheckedEmailsCount();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @When("^I click the checked checkbox$")
    public void uncheckEmails() {
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
        inboxPage.fillEmailFields(RECEIVER, SUBJECT, TEXT);

    }

    @When("^Click 'Отправить' button$")
    public void clickSendEmailButton() {
        inboxPage.clickSendEmailButton();
    }

    @Then("^\"Письмо отправлено\" notification appears$")
    public void seeSentEmailNotification() {
        Assert.assertTrue(inboxPage.sentEmailNotificationPresents());
    }

    @When("^I move email to spam folder$")
    public void checkEmail() {
        inboxPage.moveToSpam(1);
    }

    @Then("^Email appears in spam folder$")
    public void emailIsInSpam() {
        inboxPage.navigateToSpamFolder();
        int expectedResult = 1;
        int actualResult = spamPage.getSpamEmailsCount();
        Assert.assertEquals(expectedResult, actualResult);
    }
}
