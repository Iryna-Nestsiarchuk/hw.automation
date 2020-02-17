import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingTask2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nestsiarchuk_IV\\Desktop\\Automation\\chromedriver.exe");//your own path
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.booking.com");

        WebElement searchBar = driver.findElement(By.xpath("//input[@type='search']"));
        searchBar.sendKeys("Москва");

        WebElement submitButton = driver.findElement(By.xpath("//button[contains(@class, 'searchbox')]"));
        submitButton.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement sortingList = driver.findElement(By.xpath("//a[contains(text(),'Star rating')]"));
        sortingList.click();

        WebElement sortMaxRating = driver.findElement(By.xpath("//a[contains(text(),'5 to 1')]"));
        sortMaxRating.click();

        WebDriverWait waiter = new WebDriverWait(driver, 10);
        WebElement scoreMaxElement = waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[contains(@class,'badge')]")));
        Double scoreMax = Double.parseDouble(scoreMaxElement.getText());
        System.out.println("The first hotel on the page rating is " + scoreMax);
        System.out.println(scoreMax >= 9.0 ? "Rating of the first hotel on page >= 9" :
                "Rating of the first hotel on page < 9");
    }
}
