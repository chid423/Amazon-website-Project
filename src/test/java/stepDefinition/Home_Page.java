package stepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import org.openqa.selenium.WebDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import library.Constants;
import pages.PageObject;

public class Home_Page  {
	 private static  Logger log = LogManager.getLogger(Home_Page .class);
	public WebDriver driver;
    public PageObject po;

    @Given("user am on the Amazon home page {string}")
    public void user_am_on_the_amazon_home_page(String string) {
    	
        driver = library.Browsers.launchBrowser("firefox");
        po = new PageObject(driver);
        driver.get(Constants.URL);
        log.info("URL is opened");
		
    }
    @When("user click on All")
    public void user_click_on_all() {
        po.clickMenu();
        log.info("All is click");
    }


    @When("user navigate to the Electronics and Computers section")
    public void user_navigate_to_the_electronics_and_computers_section() {
        po.clickElectronicsComputer();
        log.info("Electronics and Computer is clicked");
    }

    @When("user navigate to the Phones and Accessories section")
    public void user_navigate_to_the_phones_and_accessories_section() {
        po.clickPhoneAndAccessories();
        log.info("Phone and Accessories is opened");
    }
    @When("user is on page and Accessories home page {string}")
    public void user_is_on_page_and_accessories_home_page(String string) {
        driver.getCurrentUrl();
        driver.getTitle();
     
        Assert.assertEquals(Constants.TITLE, driver.getTitle());
        log.info("TITLE is true");
    }

    
    
    
}
	

	
	




