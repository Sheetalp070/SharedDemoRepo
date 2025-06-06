package com.wait;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.Constants.Constants;
import com.driver.DriverFactory;

/**
 * ImplicitWaitActions is a utility class responsible for setting up
 * the global implicit wait time for the WebDriver instance.
 * 
 * Implicit waits tell WebDriver to poll the DOM for a certain amount
 * of time when trying to find elements that are not immediately available.
 */
public class ImplicitWaitActions {

	// Logger instance for capturing wait setup status or errors
	private Logger logger = LogManager.getLogger(ImplicitWaitActions.class);

	/**
     * Sets the implicit wait time defined in Constants for the WebDriver session.
     * Logs success or failure in setting the wait time.
     */
	public void setImplicitWait() {
		try {
			DriverFactory.getInstance().getDriver().manage().timeouts()
					.implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));
			logger.info("Implicit wait time is set to " + Constants.IMPLICIT_WAIT_TIME);
		} catch (Exception e) {
			logger.error("Error occured while setting the implicit wait " + e.getMessage());
		}
	}

}
