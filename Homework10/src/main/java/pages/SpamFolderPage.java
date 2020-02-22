package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SpamFolderPage {
    @FindAll({@FindBy(xpath = "//a[contains(@class,'letter')]//span[contains(@class,'checkbox__wrapper')]")})
    private List<WebElement> spamEmailListCheckbox;

    @FindBy(xpath = "//span[@title='Не спам']")
    private WebElement notSpamIcon;

    private WebDriver driver;

    public SpamFolderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int getSpamEmailsCount() {
        return spamEmailListCheckbox.size();
    }

    public void extractEmailFromSpam() {
        Actions action = new Actions(driver);
        WebElement checkbox = spamEmailListCheckbox.get(0);
        action.moveToElement(checkbox).build().perform();
        checkbox.click();
        notSpamIcon.click();
    }
}
