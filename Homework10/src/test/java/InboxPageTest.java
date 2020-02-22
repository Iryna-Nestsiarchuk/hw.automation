import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.InboxPage;
import pages.LoginPage;
import pages.SpamFolderPage;

import java.util.concurrent.TimeUnit;

public class InboxPageTest {
    private static InboxPage inboxPage;
    private static LoginPage loginPage;
    private static SpamFolderPage spamFolder;
    private static WebDriver driver;

    @BeforeClass
    public static void before() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nestsiarchuk_IV\\Desktop\\Automation\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://mail.ru");
        driver.manage().window().maximize();
        inboxPage = new InboxPage(driver);
        loginPage = new LoginPage(driver);
        spamFolder = new SpamFolderPage(driver);
        loginPage.login("irina.nesterch", "ihearyounow17031996");
    }

    @Test
    public void moveToSpamTest() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        inboxPage.moveToSpam(1);
        inboxPage.navigateToSpamFolder();
        int expectedResult = 1;
        int actualResult = spamFolder.getSpamEmailsCount();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void sendEmailTest() {
        inboxPage.sendLetter("irina.nesterch@gmail.com palkanov.vlad@gmail.com", "Subject", "Text");
        String expectedResult = "Письмо";
        String actualResult = inboxPage.getSentEmailNotification();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void checkboxEmailsTest() {
        inboxPage.checkEmails(3);
        int expectedResult = 3;
        int actualResult = inboxPage.getCheckedEmailsCount();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void uncheckAllCheckedEmailsTest() {
        inboxPage.checkEmails(2);
        inboxPage.uncheckAllCheckedEmails();
        int actualResult = inboxPage.getCheckedEmailsCount();
        int expectedResult = 0;
        Assert.assertEquals(expectedResult, actualResult);
    }
}

