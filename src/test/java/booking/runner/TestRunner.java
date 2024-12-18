package booking.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/"},
        glue = {"booking.steps", "booking.framework.cucumber"},
        plugin = {"json:target/cucumber-reports/cucumber.json","html:target/cucumber-reports/cucumber-pretty"},
        tags = "@smokeTest"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}