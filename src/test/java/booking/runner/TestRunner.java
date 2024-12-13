package booking.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//plugin = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"},

@CucumberOptions(
        features = {"src/test/resources/features/"},
        glue = {"booking.steps", "booking.framework.cucumber"},
        plugin = {"json:target/cucumber-reports/cucumber.json","html:target/cucumber-reports/cucumber-pretty"},
        tags = "@HappyPath"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}