package junitcucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class InboxPage extends Page {
    @FindAll({@FindBy(xpath = "//a[contains(@class,'letter')]//span[contains(@class,'checkbox__wrapper')]")})
    private List<WebElement> emailCheckboxList;

    @FindAll({@FindBy(xpath = "//button[contains(@class,'is-active')]//label")})
    private List<WebElement> checkedEmailsList;

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

    @FindBy(xpath = "//span[@title ='Спам']//span[text()='Спам']")
    private WebElement toSpamIcon;

    @FindBy(xpath = "//div[text()='Спам']")
    private WebElement spamFolder;

    WebDriver driver;

    public InboxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkEmails(int numberOfEmails) {
        driver.navigate().refresh();
        Actions action = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(ELEMENT_PRESENSE_TIMEOUT, TimeUnit.SECONDS);
        for (int i = 0; i < numberOfEmails; i++) {
            WebElement checkbox = emailCheckboxList.get(i);
            action.moveToElement(checkbox).build().perform();
            checkbox.click();
        }
    }

    public int getCheckedEmailsCount() {
        return checkedEmailsList.size();
    }

    public void uncheckAllCheckedEmails() {
        for (WebElement checkbox : checkedEmailsList
        ) {
            checkbox.click();
        }
    }

    public void clickWriteEmailButton() {
        writeEmailButton.click();
    }

    public void fillEmailFields(String receiver, String subject, String text) {
        receiverInput.sendKeys(receiver);
        subjectInput.sendKeys(subject);
        textEmailInput.sendKeys(text);
    }

    public void clickSendEmailButton() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new WebDriverWait(driver, ELEMENT_PRESENSE_TIMEOUT).until(ExpectedConditions.elementToBeClickable(sendEmailButton)).click();
    }

    public void moveToSpam(int numberOfSpamEmails) {
        checkEmails(numberOfSpamEmails);
        toSpamIcon.click();
    }

    public void navigateToSpamFolder() {
        new WebDriverWait(driver, ELEMENT_PRESENSE_TIMEOUT).until(ExpectedConditions.elementToBeClickable(spamFolder)).click();
    }

    public Boolean sentEmailNotificationPresents() {
        return (new WebDriverWait(driver, ELEMENT_PRESENSE_TIMEOUT)).until(ExpectedConditions.visibilityOf(emailIsSentMessage))
                .isDisplayed();
    }
}
