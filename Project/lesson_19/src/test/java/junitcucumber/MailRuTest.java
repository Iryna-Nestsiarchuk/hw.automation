package junitcucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/junitcucumber/01_Login.feature", "src/test/java/junitcucumber/02_Inbox.feature"})
public class MailRuTest {
}

