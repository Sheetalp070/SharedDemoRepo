package com.Amazon.Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;


public class BaseTestAZ {
public  static WebDriver driver;
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    

    @BeforeClass
    public void initDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.amazon.com/");
    }
    
    public void clickonAmaxonLink(WebElement element)
	{
		wait.until(ExpectedConditions.visibilityOf(element)).click(); 
	}

    @AfterClass(alwaysRun = true)
    public void tearDown()
    {
        if (driver != null) {
            driver.quit();
        }        
        
    }
    public WebDriver getDriver() {
        return driver;
    }


}
