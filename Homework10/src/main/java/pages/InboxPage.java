package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class InboxPage {
    @FindAll({@FindBy(xpath = "//a[contains(@class,'letter')]//span[contains(@class,'checkbox__wrapper')]")})
    private List<WebElement> emailCheckboxList;

    @FindAll({@FindBy(xpath = "//button[contains(@class,'is-active')]//label")})
    private List<WebElement> checkedEmailsList;

    @FindBy(xpath = "//span[@title ='Спам']//span[text()='Спам']")
    private WebElement toSpamIcon;

    @FindBy(xpath = "//div[text()='Спам']")
    private WebElement spamFolder;

    @FindBy(xpath = "//span[@title='Написать письмо']")
    private WebElement writeLetterButton;

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

    private WebDriver driver;

    public InboxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkEmails(int numberOfEmails) {
        Actions action = new Actions(driver);
        for (int i = 0; i < numberOfEmails; i++) {
            WebElement checkbox = emailCheckboxList.get(i);
            action.moveToElement(checkbox).build().perform();
            checkbox.click();
        }
    }

    public void moveToSpam(int numberOfSpamEmails) {
        checkEmails(numberOfSpamEmails);
        toSpamIcon.click();
    }

    public void navigateToSpamFolder() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(spamFolder)).click();
    }

    public void sendLetter(String receiver, String subject, String text) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        writeLetterButton.click();
        receiverInput.sendKeys(receiver);
        subjectInput.sendKeys(subject);
        textEmailInput.sendKeys(text);
        sendEmailButton.click();
    }

    public int getCheckedEmailsCount() {
        return checkedEmailsList.size();
    }

    public String getSentEmailNotification() {
        return emailIsSentMessage.getText();
    }

    public void uncheckAllCheckedEmails() {
        for (WebElement checkbox : checkedEmailsList
        ) {
            checkbox.click();
        }
    }
}

