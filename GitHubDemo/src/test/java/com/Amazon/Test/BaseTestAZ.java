package com.Amazon.Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;


public class BaseTestAZ {
public  static WebDriver driver;
    
    

    @BeforeClass
    public void initDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.amazon.com/");
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
