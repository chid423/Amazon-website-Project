package stepDefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.BaseUtil;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Hooks extends BaseUtil {
    private static Logger log = LogManager.getLogger(Hooks.class);

    private BaseUtil base;

    public Hooks(BaseUtil base) {
        this.base = base;
    }

    ExtentReports extent;
    ExtentTest test;
    ExtentHtmlReporter htmlReporter;

    @Before
    public void setup(Scenario scenario) {
        // Initialize ExtentReports and attach the reporter
        htmlReporter = new ExtentHtmlReporter("C:\\ExtentReport\\Report.html");
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Test Report");
        htmlReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // Start test logging for the scenario
        test = extent.createTest(scenario.getName());

        WebDriverManager.firefoxdriver().setup();
        base.driver = new FirefoxDriver();
        base.driver.manage().window().maximize();
        log = Logger.getLogger("AutomationExecise");
        PropertyConfigurator.configure("Log4j.properties");
    }

    @AfterStep
    public void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take screenshot
            TakesScreenshot ts = (TakesScreenshot) base.driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            // Define the destination path for the screenshot
            File destination = new File("/AutomationExecise/test-output/" + scenario.getName() + ".png");
            try {
                // Copy the screenshot to the destination path
                FileHandler.copy(source, destination);
                test.fail("Scenario failed: " + scenario.getName(), 
                          MediaEntityBuilder.createScreenCaptureFromPath(destination.getAbsolutePath()).build());
                System.out.println("Screenshot taken for failed scenario: " + scenario.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            test.pass("Scenario passed: " + scenario.getName());
        }
    }

    @After
    public void teardown() {
        if (base.driver != null) {
            base.driver.quit();
        }
        log.info("Browser closed");

        // Save and flush the report
        extent.flush();
    }
}
