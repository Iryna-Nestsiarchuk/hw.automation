package junitcucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendEmail {
    private static final int ELEMENT_PRESENSE_TIMEOUT = 15;

    @FindBy(xpath = "//span[@title='Написать письмо']")
    private WebElement writeEmailButton;

    @FindBy(xpath = "//div[contains(@class, 'contacts')]//input")
    private WebElement receiverInput;

    @FindBy(xpath = "//div[contains(@class, 'subject')]//input")
    private WebElement subjectInput;

    @FindBy(xpath = "//div[@role='textbox']//div")
    private WebElement textEmailInput;

    @FindBy(xpath = "//span[text()='Отправить']")
    private WebElement sendEmailButton;

    @FindBy(xpath = "//a[text()='Письмо']")
    private WebElement emailIsSentMessage;

    @FindBy(xpath = "//button[@title='Увеличить']")
    private WebElement expandEmailForm;

    @FindBy(xpath = "//button[@title='Уменьшить']")
    private WebElement reduceEmailForm;

    ScenarioContext scenarioContext = ScenarioContext.getInstanceOfScenarioContextClass();
    private WebDriver webDriver;

    public SendEmail() {
        this.webDriver = scenarioContext.getWebDriver();
        PageFactory.initElements(webDriver, this);
    }

    public void clickWriteEmailButton() {
        new WebDriverWait(webDriver, ELEMENT_PRESENSE_TIMEOUT).until(ExpectedConditions.elementToBeClickable(writeEmailButton)).click();
    }

    public void fillReceiverField(String receiver) {
        new WebDriverWait(webDriver, ELEMENT_PRESENSE_TIMEOUT).until(ExpectedConditions.elementToBeClickable(receiverInput));
        receiverInput.sendKeys(receiver);
    }

    public void fillSubjectField(String subject) {
        subjectInput.sendKeys(subject);
    }

    public void fillTextField(String text) {
        textEmailInput.sendKeys(text);
    }

    public void clickSendEmailButton() {
        sendEmailButton.click();
    }

    public void resizeWindow() {
        new WebDriverWait(webDriver, ELEMENT_PRESENSE_TIMEOUT).until(ExpectedConditions.elementToBeClickable(expandEmailForm)).click();
        new WebDriverWait(webDriver, ELEMENT_PRESENSE_TIMEOUT).until(ExpectedConditions.elementToBeClickable(reduceEmailForm)).click();
    }

}
