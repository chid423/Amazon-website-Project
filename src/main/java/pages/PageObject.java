package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {
    public WebDriver driver;

    public PageObject(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(id = "nav-hamburger-menu")
    @CacheLookup
    WebElement menu;
    
    
    @FindBy (xpath = "//ul[@class='hmenu hmenu-visible']//li[20]//a[1]")
    @CacheLookup
    WebElement electronicsAndComputer;

    @FindBy(xpath = "//*[@id=\"hmenu-content\"]/ul[13]/li[8]")
    @CacheLookup
    WebElement phoneAndAccessories;

    @FindBy(xpath = "//a[normalize-space()='Samsung']")
    @CacheLookup
    WebElement samsungButton;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/ul[2]/li[1]/a[1]")
    WebElement simFreeSamsung;

    @FindBy(xpath = "//li[@id='p_123/46655']//i[@class='a-icon a-icon-checkbox']")
    WebElement samsung;

    @FindBy(xpath = "//*[@id=\"filters\"]/ul[1]/span/span[2]")
    WebElement year;

    @FindBy(xpath = "//span[contains(text(),'20 MP & above')]")
    WebElement resolution;
    
    @FindBy (xpath = "//input[@id='p_36/range-slider_slider-item_upper-bound-slider']")
    WebElement upperSlider;

    @FindBy(xpath = "//input[@id='p_36/range-slider_slider-item_lower-bound-slider']']")
    WebElement lowerSlider;

    @FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]")
    WebElement result;

    private List<WebElement> phoneElements;
    
 

    public void clickMenu() {
        handleAlert();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", menu);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", menu);
        menu.click();
        System.out.println("Title: " + driver.getTitle());
        System.out.println("url: " + driver.getCurrentUrl());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void clickElectronicsComputer() {
        handleAlert();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().forward();
        driver.navigate().back();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement electronicsAndComputer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='hmenu hmenu-visible']//li[20]//a[1]")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", electronicsAndComputer);
        wait.until(ExpectedConditions.elementToBeClickable(electronicsAndComputer)).click();

        
        driver.getTitle();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    public void clickPhoneAndAccessories() {
        handleAlert();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.navigate().back();
        driver.navigate().forward();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", phoneAndAccessories);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", phoneAndAccessories);
    }

    public void clickSamsungButton() {
        handleAlert();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", samsungButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", samsungButton);
        samsungButton.click();
    }

    public void clickSimFreeSamsung() {
        handleAlert();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", simFreeSamsung);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", simFreeSamsung);
        simFreeSamsung.click();
    }

    public void clickSamsung() {
        handleAlert();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", samsung);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", samsung);
        samsung.click();
    }

    public void clickYear2023() {
        handleAlert();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", year);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", year);
        year.click();
    }

    public void click20MpAndAbove() {
        handleAlert();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", resolution);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", resolution);
        resolution.click();
        
    }

    public void adjustSlider(int minPrice, int maxPrice) {
        handleAlert();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", upperSlider);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", upperSlider);
        Actions act = new Actions(driver);
        act.moveToElement(upperSlider).dragAndDropBy(upperSlider, maxPrice, minPrice).build().perform();
    }
   
    
    
    
    public List<WebElement> getWebElement() {
    	
    	List <WebElement>values= driver.findElements(By.xpath("//*[@id=\"filters\"]/ul[1]/span/span[2]"));
    	//boolean status= false;
    	for(WebElement ele : values) {
    	String value = ele.getText();
    	System.out.println(value);
    		
    	}
    	return values;
    	}

    	
    
    
    public List<WebElement> getAvailablePhones() {
        handleAlert();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", result);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", result);
      
        List <WebElement>values1= driver.findElements(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]"));
    	//boolean status= false;
    	for(WebElement ele : values1) {
    	String value = ele.getText();
    	System.out.println(value);
        }
        return values1;
    }
    
    public String getTitle() {
        handleAlert();
        return driver.getTitle();
    }

    private void handleAlert() {
        try {
            driver.switchTo().alert().dismiss();
        } catch (NoAlertPresentException e) {
            
        }
    }
}
