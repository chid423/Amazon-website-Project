package stepDefinition;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import library.Constants;
import pages.PageObject;

public class Samsung_Page {

    private static final Logger log = LogManager.getLogger(Samsung_Page.class);
    private WebDriver driver;
    private PageObject po;

    @Given("user is on simfree landing page {string}")
    public void user_is_on_simfree_landing_page(String url) {
        driver = library.Browsers.launchBrowser("firefox");
        po = new PageObject(driver);
        driver.get(Constants.URL2);
        log.info(url + " is opened");
    }

    @When("user filter the brand to {string}")
    public void user_filter_the_brand_to(String brand) {
        if ("Samsung".equals(brand)) {
            po.clickSamsung();
            log.info(brand + " brand is selected");
        } else {
            log.warn("Brand " + brand + " is not recognized.");
        }
    }

    @When("user filter the camera resolution to {string}")
    public void user_filter_the_camera_resolution_to(String cameraResolution) {
        if ("20 MP and above".equals(cameraResolution)) {
            po.click20MpAndAbove();
            log.info(cameraResolution + " is selected");
        } else {
            log.warn("Camera resolution " + cameraResolution + " is not recognized.");
        }
    }

    @When("user filter the model year to {string}")
    public void user_filter_the_model_year_to(String stringModelYear) {
        try {
            int modelYear = Integer.parseInt(stringModelYear);
            po.getWebElement();
            log.info("Year " + modelYear + " is selected");
        } catch (NumberFormatException e) {
            log.error("Invalid model year: " + stringModelYear, e);
        }
    }
    
    @When("user filter the price range to between {int} and {int}")
    public void user_filter_the_price_range_to_between(Integer minPrice, Integer maxPrice) {
        po.adjustSlider(minPrice, maxPrice);
        log.info("Price range between £" + minPrice + " and £" + maxPrice + " is selected");
    }
    
    
    
    @Then("user should see a list of {string} phones that match the criteria")
    public List<WebElement> user_should_see_a_list_of_phones_that_match_the_criteria(String brand) {
        List<WebElement> valuess = po.getAvailablePhones();
        
        if (valuess.isEmpty()) {
            System.out.println("No matching records found");
            log.info("No matching records found");
        } else {
            for (WebElement ell : valuess) {
                String values3 = ell.getText();
                System.out.println(values3);
                log.info("Matching record found: " + values3);
            }
        }
        
        return valuess;
    }
    	
    	
}		
    	
