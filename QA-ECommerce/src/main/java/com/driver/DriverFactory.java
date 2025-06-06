package com.driver;

import org.openqa.selenium.WebDriver;

/**
 * DriverFactory is a Singleton utility class that manages WebDriver instances
 * using ThreadLocal. This allows safe parallel execution of tests by
 * maintaining separate WebDriver instances for each thread.
 */
public class DriverFactory {

	// ThreadLocal variable to maintain a separate WebDriver instance for each test
	// thread
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	// Private constructor to prevent external instantiation (Singleton pattern)
	private DriverFactory() {

	}

	// Initialized Singleton instance of DriverFactory
	private static DriverFactory instance = new DriverFactory();

	/**
	 * Provides global access to the singleton instance of DriverFactory.
	 * 
	 * @return singleton instance of DriverFactory
	 */
	public static DriverFactory getInstance() {

		return instance;
	}

	/**
	 * Sets the WebDriver instance for the current thread.
	 * 
	 * @param driverObj WebDriver instance to be associated with the current thread
	 */
	public void setDriver(WebDriver driverObj) {
		driver.set(driverObj);

	}

	/**
	 * Retrieves the WebDriver instance associated with the current thread.
	 * 
	 * @return WebDriver instance for the current thread
	 */
	public WebDriver getDriver() {
		return driver.get();
	}

}
