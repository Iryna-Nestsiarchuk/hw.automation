package junitcucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private static final int ELEMENT_PRESENSE_TIMEOUT = 10;

    @FindBy(id = "mailbox:login")
    private WebElement loginField;

    @FindBy(id = "mailbox:password")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='mailbox:submit']/input")
    private WebElement buttonEnter;

    @FindBy(xpath = "//*[@id='PH_logoutLink']")
    private WebElement logoutLink;

    @FindBy(xpath = "//span[@title='Написать письмо']")
    private WebElement writeEmailButton;

    ScenarioContext scenarioContext = ScenarioContext.getInstanceOfScenarioContextClass();
    private WebDriver webDriver;

    public LoginPage() {
        this.webDriver = scenarioContext.getWebDriver();
        PageFactory.initElements(webDriver, this);
    }

    public void enterLogin(String login) {
        loginField.clear();
        loginField.sendKeys(login);
        buttonEnter.click();
    }

    public void enterPassword(String password) {
        new WebDriverWait(webDriver, ELEMENT_PRESENSE_TIMEOUT).until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
        buttonEnter.click();
    }

    public void loginIntoMailbox(String login, String password) {
        enterLogin(login);
        enterPassword(password);
        new WebDriverWait(webDriver, ELEMENT_PRESENSE_TIMEOUT).until(ExpectedConditions.visibilityOf(writeEmailButton));
    }


}
