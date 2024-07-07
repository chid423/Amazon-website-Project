package stepDefinition;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import library.Constants;
import pages.PageObject;

public class Samsung_Page {

    private static Logger log = LogManager.getLogger(Samsung_Page.class);
    public WebDriver driver;
    public PageObject po;

    @Given("user is on simfree landing page {string}")
    public void user_is_on_simfree_landing_page(String url) {
        driver = library.Browsers.launchBrowser("firefox");
        po = new PageObject(driver);
        driver.get(Constants.URL2);
        log.info(url + " is opened");
    }

    @When("user filter the brand to {string}")
    public void user_filter_the_brand_to(String brand) {
        if (brand.equals("Samsung")) {
            po.clickSamsung();
            log.info(brand + " brand is selected");
        }
        
    }

    @When("user filter the camera resolution to {string}")
    public void user_filter_the_camera_resolution_to(String cameraResolution) {
        if (cameraResolution.equals("£20 MP and above")) {
            po.click20MpAndAbove();
            log.info(cameraResolution + " is selected");
        }
        
    }

    @When("user filter the model year to {string}")
    public void user_filter_the_model_year_to(String stringModelYear) {
        Integer modelYear = Integer.parseInt(stringModelYear);
        if (modelYear == 2023) 
            po.clickYear2023();
            log.info("Year " + modelYear + " is selected");
     
    }

    @When("user filter the price range to between {int} and {int}")
    public void user_filter_the_price_range_to_between(Integer minPrice, Integer maxPrice) {
        po.adjustSlider(minPrice, maxPrice);
        log.info("Price range between £" + minPrice + " and £" + maxPrice + " is selected");
    }

    @Then("user should see a list of {string} phones that match the criteria")
    public void user_should_see_a_list_of_phones_that_match_the_criteria(String brand) {
        boolean isNoMatchingRecord = Constants.MIN_PRICE <= Constants.LOWER && Constants.MAX_PRICE <= Constants.UPPER;
        if (isNoMatchingRecord) {
            System.out.println("There is no matching record");
            log.info("No matching record found");
        } else {
            List<String> availablePhones = po.getAvailablePhones();
            System.out.println("List of available " + brand + " phones that match the criteria:");
            availablePhones.forEach(System.out::println);
            log.info("List of available phones displayed");
        }
    }
}
