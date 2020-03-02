package junitcucumber;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"C:\\Users\\Nestsiarchuk_IV\\Desktop\\Automation\\InClass\\12\\src\\test\\java\\junitcucumber\\1Login.feature",
        "C:\\Users\\Nestsiarchuk_IV\\Desktop\\Automation\\InClass\\12\\src\\test\\java\\junitcucumber\\2Inbox.feature"}, tags = {"@all"})
public class MailRuTest {
}

