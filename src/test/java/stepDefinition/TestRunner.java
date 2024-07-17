package stepDefinition;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src\\test\\resources\\feature\\home_page.feature"}, 
    glue = {"stepDefinition"},
    dryRun = false,
    plugin = {
        "pretty",
        "html:target/cucumberReport/test-output.html",
        "json:target/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    },
    monochrome = true,
    tags = "@tag1"
)
public class TestRunner {
}


