package junitcucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends Page{
    @FindBy(id = "mailbox:login")
    private WebElement loginField;

    @FindBy(id = "mailbox:password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@value='Ввести пароль']")
    private WebElement nextButton;

    @FindBy(xpath = "//*[@id='PH_logoutLink']")
    private WebElement logoutLink;
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String login, String password) {
        loginField.sendKeys(login);
        nextButton.click();
        new WebDriverWait(driver, ELEMENT_PRESENSE_TIMEOUT).until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
        nextButton.click();
    }

    public boolean logoutLinkPresents() {
        return (new WebDriverWait(driver, ELEMENT_PRESENSE_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(logoutLink))
                .isDisplayed();
    }
}
