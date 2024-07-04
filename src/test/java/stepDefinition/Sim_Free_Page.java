package stepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import library.Constants;
import pages.PageObject;

public class Sim_Free_Page {
    private static  Logger log = LogManager.getLogger(Sim_Free_Page.class); 
    private WebDriver driver; 
    private PageObject po;


    @Given("user navigate to the Mobile Phones page {string}")
    public void user_navigate_to_the_mobile_phones_page(String string) {
    	driver = library.Browsers.launchBrowser("firefox");
        po = new PageObject(driver);
        driver.get(Constants.URL1);
        System.out.println("url: " + driver.getCurrentUrl());
        log.info("URL1 is opened");
    }

    @When("user click on simFree")
    public void user_click_on_sim_free() {
        po.clickSimFreeSamsung();
        log.info("Sim Free is clicked");
    }

    @Then("user should see landing page")
    public void user_should_see_landing_page() {
        String title = driver.getTitle();
        System.out.println("Title: " + title);
        log.info("Title is true: " + title);
    }
}
