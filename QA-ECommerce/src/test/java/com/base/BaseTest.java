package com.base;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.driver.BrowserFactory;
import com.driver.DriverFactory;
import com.properties.ConfigLoader;
import com.properties.TestDataLoader;

/**
 * BaseTest is the foundational class for all test classes.
 * It handles WebDriver initialization and teardown, and loads configuration and test data.
 * All test classes should extend this class to inherit common setup/cleanup behavior.
 */
public class BaseTest {

	/**
     * This method is executed once before all test cases in the test suite.
     * It initializes the WebDriver, sets the browser, maximizes the window,
     * and navigates to the application URL.
     */
	@BeforeSuite
	public void setUp() {

		// Create WebDriver instance using browser type from config.properties
		WebDriver driver = BrowserFactory.createBrowserInstance(ConfigLoader.getInstance().getPropertyValue("browser"));
		// Set the WebDriver instance using ThreadLocal wrapper (for parallel execution)
		DriverFactory.getInstance().setDriver(driver);
		// Maximize the browser window
		DriverFactory.getInstance().getDriver().manage().window().maximize();
		// Navigate to the application URL from test data properties
		DriverFactory.getInstance().getDriver().get(TestDataLoader.getInstance().getAppUrl());
		
		String Actual_Title = DriverFactory.getInstance().getDriver().getTitle();
		// Assert.assertEquals(Actual_Title, "Advantage Shopping", "Actual and expected
		// titles are matching" );

	}
	
	/**
     * This method is executed once after all test cases in the test suite have run.
     * It quits the WebDriver instance to release system resources.
     */

	@AfterSuite
	public void tearDown() {
		if (DriverFactory.getInstance().getDriver() != null) {
			DriverFactory.getInstance().getDriver().quit();
		}

	}

}
