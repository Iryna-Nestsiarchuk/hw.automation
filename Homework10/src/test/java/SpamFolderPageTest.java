import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.InboxPage;
import pages.LoginPage;
import pages.SpamFolderPage;

public class SpamFolderPageTest {
    private static InboxPage inboxPage;
    private static LoginPage loginPage;
    private static SpamFolderPage spamFolder;
    private static WebDriver driver;

    @BeforeClass
    public static void before() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nestsiarchuk_IV\\Desktop\\Automation\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://mail.ru");
        inboxPage = new InboxPage(driver);
        loginPage = new LoginPage(driver);
        spamFolder = new SpamFolderPage(driver);
        loginPage.login("irina.nesterch", "ihearyounow17031996");
        driver.manage().window().maximize();
    }

    @Test
    public void moveFromSpamTest()  {
        inboxPage.navigateToSpamFolder();
        spamFolder.extractEmailFromSpam();
        driver.navigate().refresh();
        int actualResult = spamFolder.getSpamEmailsCount();
        int expectedResult = 0;
        Assert.assertEquals(expectedResult, actualResult);
    }
}
