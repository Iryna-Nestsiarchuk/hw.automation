import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BookingTask1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nestsiarchuk_IV\\Desktop\\Automation\\chromedriver.exe");//your own path
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.booking.com");

        WebElement searchBar = driver.findElement(By.xpath("//input[@type='search']"));
        searchBar.sendKeys("Москва");

        WebElement submitButton = driver.findElement(By.xpath("//button[contains(@class, 'searchbox')]"));
        submitButton.click();

        List<WebElement> hotelList = driver.findElements(By.xpath("//a[contains(@class, 'hotel_name')]"));
        System.out.println((hotelList.size() > 0) ? "There are available hotels in Moscow on entered dates" :
                "No hotels in Moscow on entered dates");
    }
}
