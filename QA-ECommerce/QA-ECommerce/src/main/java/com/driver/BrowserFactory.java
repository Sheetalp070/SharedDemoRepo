package com.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * BrowserFactory is a utility class responsible for creating WebDriver
 * instances based on the browser name provided (e.g., Chrome, Firefox).
 */
public class BrowserFactory {

	/**
	 * Creates and returns a WebDriver instance based on the specified browser name.
	 * Supports Chrome and Firefox.
	 * 
	 * @param browserName the name of the browser (e.g., "Chrome", "Firefox")
	 * @return WebDriver instance for the requested browser
	 */
	public static WebDriver createBrowserInstance(String browserName) {
		WebDriver driver = null;

		// Initialize Chrome browser with options
		if (browserName.equalsIgnoreCase("Chrome")) {
			// Automatically setup ChromeDriver using WebDriverManager
			WebDriverManager.chromedriver().setup();

			// Define Chrome options
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			options.addArguments("--start-maximized");

			driver = new ChromeDriver(options);
		}

		//// Initialize Firefox browser
		else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();

		}

		// Return the initialized driver instance
		return driver;

	}
}
