package junitcucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Set;

public class FindCinema {
    private static final int ELEMENT_PRESENSE_TIMEOUT = 10;

    @FindBy(xpath = "//a[text() = 'Афиша']")
    private WebElement poster;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchBar;

    @FindBy(xpath = "//a[@tabindex='0']")
    private WebElement queryResult;

    @FindBy(xpath = "(//button[@role='listbox'])[2]")
    private WebElement selectTime;

    @FindBy(xpath = "(//span[text()='Вечер'])[1]")
    private WebElement evening;

    @FindAll({@FindBy(xpath = "//div[contains(@class, 'event-schedule')]")})
    private List<WebElement> cinemasList;

    private WebDriver driver;

    public FindCinema(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToPoster() {
        poster.click();
    }

    public void switchToOpenedWindow() {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String window : windowHandles) {
            driver.switchTo().window(window);
        }
    }

    public void clickFoundedResult() {
        queryResult.click();
    }

    public void searchFilm(String filmName) {
        searchBar.sendKeys(filmName);
        searchBar.submit();
    }

    public void selectTime() {
        selectTime.click();
        evening.click();
    }

    public boolean isAnyCinemas() {
        return (cinemasList.size() > 0);
    }
}
