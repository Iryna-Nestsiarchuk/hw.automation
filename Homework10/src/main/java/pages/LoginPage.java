package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    @FindBy(id = "mailbox:login")
    private WebElement loginField;

    @FindBy(id = "mailbox:password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@value='Ввести пароль']")
    private WebElement nextButton;

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String login, String password) {
        loginField.sendKeys(login);
        nextButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        passwordField.sendKeys(password);
        nextButton.click();
    }
}
