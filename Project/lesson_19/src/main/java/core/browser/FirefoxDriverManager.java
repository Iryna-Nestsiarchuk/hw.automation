package core.browser;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class FirefoxDriverManager extends DriverManager {

    private GeckoDriverService geckoDriverService;

    @Override
    public void startService() {
        if (null == geckoDriverService) {
            try {
                geckoDriverService = new GeckoDriverService.Builder()
                        .usingAnyFreePort()
                        .build();
                geckoDriverService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void stopService() {
        if (null != geckoDriverService && geckoDriverService.isRunning())
            geckoDriverService.stop();
    }

    @Override
    public void createDriver() {
        driver = new FirefoxDriver(geckoDriverService);
    }
}