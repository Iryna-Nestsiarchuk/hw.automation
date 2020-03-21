package core.configuration;

import core.browser.DriverType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    private static final String RESOURCES_PATH = "src\\main\\resources\\";
    private static Properties properties;

    public static void readProperties() {
        if (properties == null) {
            properties = new Properties();
        }
        try {
            properties.load(new FileReader(new File(RESOURCES_PATH, "env.properties")));
            properties.load(new FileReader(new File(RESOURCES_PATH, "chrome.properties")));
            properties.load(new FileReader(new File(RESOURCES_PATH, "browser.properties")));
            properties.load(new FileReader(new File(RESOURCES_PATH, "applitools.properties")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getProperty(String property) {
        if (properties == null) {
            readProperties();
        }
        return properties.getProperty(property);
    }

    public static DriverType getDriverType() {
        return DriverType.valueOf(getProperty("browserType"));
    }

    public static String getMainUrl() {
        return getProperty("mainUrl");
    }

    public static Boolean getHeadlessChromeOption() {
        return Boolean.valueOf(getProperty("headless"));
    }

    public static String getYahooUrl() {
        return getProperty("yahooURL");
    }

    public static String getApplitoolsAPIKey(){
        return getProperty("APIKey");
    }

    public static String getApplitoolsAppName(){
        return getProperty("AppName");
    }

    public static String getApplitoolsTestName(){
        return getProperty("TestName");
    }

    public static String getVKAccessToken(){
        return getProperty("accessToken");
    }

    public static String getVKWallOwner(){
        return getProperty("wallOwner");
    }
}
