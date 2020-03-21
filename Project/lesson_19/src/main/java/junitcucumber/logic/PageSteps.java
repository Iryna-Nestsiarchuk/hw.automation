package junitcucumber.logic;

import core.browser.DriverManager;
import core.browser.DriverManagerFactory;
import core.configuration.Configuration;
import core.dbconnection.DBGetter;
import core.ui.Screenshot;
import junitcucumber.pages.Page;
import org.openqa.selenium.WebDriver;

public abstract class PageSteps {
    public static final String LOGIN = DBGetter.getUsers().get(0).getLogin();
    public static final String PASSWORD = DBGetter.getUsers().get(0).getPassword();
    public static final String MAIN_URL = Configuration.getMainUrl();
    protected Screenshot screenshot;

}
