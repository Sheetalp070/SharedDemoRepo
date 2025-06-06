package com.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	
	public static WebDriver createBrowserInstance(String browserName)
	{
		WebDriver driver =null;
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			 WebDriverManager.chromedriver().setup();
	            ChromeOptions options = new ChromeOptions();
	            options.addArguments("--incognito");
	            options.addArguments("--start-maximized");
		
			driver=new ChromeDriver(options);
		}
		else if(browserName.equalsIgnoreCase("Firefox")) {
			driver=new FirefoxDriver();
		
	}
	return driver;

}
}
