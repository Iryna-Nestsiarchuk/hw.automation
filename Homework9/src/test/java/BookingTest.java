import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BookingTest {
    private static WebDriver driver;
    private static LocalDate checkInDate;
    private static LocalDate checkOutDate;
    private static Integer daysUntilTrip;
    private static Integer daysInTrip;

    @BeforeClass
    public static void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nestsiarchuk_IV\\Desktop\\Automation\\chromedriver.exe");//your own path
        driver = new ChromeDriver();
        driver.get("https://www.booking.com");
        daysUntilTrip = 3;
        daysInTrip = 7;
        checkInDate = LocalDate.now().plusDays(daysUntilTrip);
        checkOutDate = checkInDate.plusDays(daysInTrip);
    }

    @AfterClass
    public static void afterTest() {
        driver.quit();
    }

    @Test
    public void bestHotelFromCheapestTest() {
        chooseCityAndDate();
        WebElement searchButton = driver.findElement(By.xpath("//button[contains(@class, 'searchbox')]"));
        searchButton.click();
        WebElement cheapestCheckBox = driver.findElement(By.xpath("//a[contains(@class, 'filter')]//label[@class='bui-checkbox']"));
        cheapestCheckBox.click();
        List<WebElement> hotels = driver.findElements(By.xpath(".//div[@data-score]"));
        Assert.assertTrue(isHigher(hotels.size(), 0));
        Double maxRating = findMaxByAttributeFromList("data-score", hotels);
        WebElement bestHotelPriceElement = driver.findElement(By.xpath(String.format
                ("//div[@data-score='%s']//div[@class='bui-price-display__value prco-inline-block-maker-helper']", maxRating)));
        Integer highestBound = extractBound("//a[@data-id='pri-1']");
        Integer expectedResult = highestBound * daysInTrip;
        Integer actualResult = extractPrice(bestHotelPriceElement);
        Assert.assertTrue(isLower(actualResult, expectedResult));
        driver.close();
    }

    @Test
    public void cheapestFromExpensiveTest() {
        chooseCityAndDate();
        WebElement guestsRoomsCount = driver.findElement(By.xpath("//span[contains(@class,'guests')]"));
        guestsRoomsCount.click();
        WebElement addAdults = driver.findElement(By.xpath("//button[@aria-label='Increase number of Adults']"));
        clickElementMultipleTimes(addAdults, 2);
        WebElement addRooms = driver.findElement(By.xpath("//button[@aria-label='Increase number of Rooms']"));
        addRooms.click();
        WebElement searchButton = driver.findElement(By.xpath("//button[contains(@class, 'searchbox')]"));
        searchButton.click();
        WebElement expensiveCheckBox = driver.findElement(By.xpath("(//a[contains(@class, 'filter')]//label[@class='bui-checkbox'])[5]"));
        expensiveCheckBox.click();
        WebElement sortPrice = driver.findElement(By.xpath("//a[contains(text(),'Price (lowest first)')]"));
        sortPrice.click();
        WebElement cheapestHotelPriceElement = driver.findElement(By.xpath("//div[contains(@class, 'bui-price-display__value')]"));
        Integer lowestBound = extractBound("//a[@data-id='pri-4']");
        Integer cheapestHotelPrice = extractPrice(cheapestHotelPriceElement);
        Integer priceBound = lowestBound * daysInTrip;
        Assert.assertTrue(isHigher(cheapestHotelPrice, priceBound));
    }

    @Test
    public void bookHotelTest() {
        new BookingTest().cheapestFromExpensiveTest();
        WebElement cheapestHotel = driver.findElement(By.xpath("//span[contains(@class, 'hotel__name')]"));
        cheapestHotel.click();
        switchToChildWindow();
        WebElement reservationButton = driver.findElement(By.xpath("//button[contains(@class, 'book_now')]"));
        reservationButton.click();
        WebElement roomNumber = driver.findElement(By.xpath("//*[@class='hprt-nos-select']"));
        Select selectNumberRooms = new Select(roomNumber);
        selectNumberRooms.selectByIndex(1);
        WebElement submit = driver.findElement(By.xpath("//button[contains(@class, 'reservation-button')]"));
        submit.click();
        WebElement bookerTitle = driver.findElement(By.name("booker_title"));
        Select selectBookerTitle = new Select(bookerTitle);
        selectBookerTitle.selectByIndex(2);
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Iryna");
        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Nestsiarchuk");
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("inesterch@mail.ru");
        WebElement emailConfirm = driver.findElement(By.name("email_confirm"));
        emailConfirm.sendKeys("inesterch@mail.ru");
        WebElement bookButton = driver.findElement(By.name("book"));
        bookButton.click();
        WebElement address = driver.findElement(By.name("address1"));
        address.sendKeys("Belarus");
        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("Minsk");
        WebElement zip = driver.findElement(By.name("zip"));
        zip.sendKeys("12345");
        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("123456789");
        WebElement cardType = driver.findElement(By.name("cc_type"));
        Select selectCardType = new Select(cardType);
        selectCardType.selectByIndex(2);
        WebElement cardNumber = driver.findElement(By.name("cc_number"));
        cardNumber.sendKeys("4242 4242 4242 4242");
        WebElement cardMonth = driver.findElement(By.name("cc_month"));
        Select selectCardMonth = new Select(cardMonth);
        selectCardMonth.selectByIndex(5);
        WebElement cardYear = driver.findElement(By.name("cc_year"));
        Select selectCardYear = new Select(cardYear);
        selectCardYear.selectByIndex(5);
        WebElement cardCvc = driver.findElement(By.name("cc_cvc"));
        cardCvc.sendKeys("111");
        WebElement completeButton = driver.findElement(By.xpath("//button[contains(@class,'book')]"));
        completeButton.click();
        String expectedResult = "Your booking in Paris is confirmed.";
        String actualResult = driver.findElement(By.xpath("//h1[contains(text(),'Your booking in Paris is confirmed.')]")).getText();
        Assert.assertEquals(expectedResult, actualResult);
        driver.close();
    }

    public void chooseCityAndDate() {
        WebElement searchBar = driver.findElement(By.xpath("//input[@type='search']"));
        searchBar.sendKeys("Paris");
        WebElement dateField = driver.findElement(By.xpath("//div[contains(@class, 'dates-inner')]"));
        dateField.click();
        WebElement checkIn = driver.findElement(By.xpath(String.format("//td[@data-date='%s']", checkInDate)));
        checkIn.click();
        WebElement checkOut = driver.findElement(By.xpath(String.format("//td[@data-date='%s']", checkOutDate)));
        checkOut.click();
    }

    public Double findMaxByAttributeFromList(String attribute, List<WebElement> elements) {
        Double maxAttribute = Double.parseDouble(elements.get(0).getAttribute(attribute));
        for (int i = 0; i < elements.size(); i++) {
            String dataScore = elements.get(i).getAttribute(attribute);
            Double currentAttribute = ((dataScore == null || dataScore.isEmpty() ? 0 : Double.parseDouble(elements.get(i).getAttribute(attribute))));
            if (maxAttribute < currentAttribute) {
                maxAttribute = currentAttribute;
            }
        }
        return maxAttribute;
    }

    public boolean isHigher(int price, int bound) {
        return price >= bound;
    }

    public boolean isLower(int price, int bound) {
        return price <= bound;
    }

    public void clickElementMultipleTimes(WebElement element, int times) {
        for (int i = 0; i < times; i++) {
            element.click();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        }
    }

    public Integer extractPrice(WebElement element) {
        Integer price = Integer.parseInt(element.getText().replaceAll("[^\\d]", ""));
        return price;
    }

    public Integer extractBound(String xpath) {
        String boundElement = driver.findElement(By.xpath(xpath)).getAttribute("data-value");
        Integer bound = Integer.parseInt(boundElement);
        return bound;
    }

    public void switchToChildWindow() {
        for (String childHandle : driver.getWindowHandles()) {
            String parentHandle = driver.getWindowHandle();
            if (!childHandle.equals(parentHandle)) {
                driver.switchTo().window(childHandle);
            }
        }
    }
}
