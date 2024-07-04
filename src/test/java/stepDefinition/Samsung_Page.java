package stepDefinition;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import library.Constants;
import pages.PageObject;


public class Samsung_Page {
	

	private static  Logger log  = LogManager.getLogger(Samsung_Page .class);
    public WebDriver driver;
    public PageObject po;
    
    @Given("user is on simfree landing page {string}")
    public void user_is_on_simfree_landing_page(String string) {
        driver = library.Browsers.launchBrowser("firefox");
        po = new PageObject(driver);
        driver.get(Constants.URL2);
        log.info("URL2 is opened");
    }

    @When("user filter the brand to Samsung")
    public void user_filter_the_brand_to_samsung() {
        po.clickSamsung();
        log.info("Samsung brand is opened");
    }

    @When("user filter the camera resolution to {int} MP and above")
    public void user_filter_the_camera_resolution_to_mp_and_above(Integer int1) {
        po.click20MpAndAbove();
        log.info("20 Mp  is selected");
    }

    @When("user filter the model year to {int}")
    public void user_filter_the_model_year_to(Integer int1) {
        po.clickYear2023();
        log.info("Year 2023 is selected");
    }

    
    @When("user filter the price range to between £{int} and £{int}")
    public void user_filter_the_price_range_to_between_£_and_£(Integer int1, Integer int2) {
        po.adjustSlider();
        
        log.info("Price is selected");
    }
    
    @Then("user should see a list of Samsung phones that match the criteria")
    public void user_should_see_a_list_of_samsung_phones_that_match_the_criteria() {
        boolean isNoMatchingRecord = Constants.LOWER <= Constants.LOWER1 && Constants.UPPER <= Constants.UPPER1;
        if (isNoMatchingRecord) {
            System.out.println("There is no matching record");
        } else {
            // Assuming that po.getAvailablePhones() returns a list of available phones
            System.out.println("List of available Samsung phones that match the criteria:");
            po.getAvailablePhones().forEach(System.out::println);
            log.info("No record matched");
        }
    }
}