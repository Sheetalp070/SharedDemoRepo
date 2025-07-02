package com.wait;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Constants;
import com.driver.DriverFactory;
import com.report.ExtentFactory;

/**
 * ExplicitWaitActions is a utility class that provides reusable methods for
 * applying explicit waits on web elements during test execution. It helps
 * ensure elements are ready before performing actions.
 */
public class ExplicitWaitActions {

	// Logger instance for logging wait-related events and issues
	private Logger logger = LogManager.getLogger(ExplicitWaitActions.class);

	/**
	 * Waits for the specified element to be visible on the page. Logs success or
	 * failure messages and captures failure in ExtentReport.
	 *
	 * @param element     the WebElement to wait for
	 * @param elementName a descriptive name of the element (for logs/reporting)
	 */
	public void waitForElementToBePresent(WebElement element, String elementName) {
		try {

			WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),
					Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));
			wait.until(ExpectedConditions.visibilityOf(element));
			logger.info(elementName + "available on screen");
		} catch (Exception e) {
			logger.error("Exception occured while waiting for the element to be visible " + e.getMessage());
			ExtentFactory.getInstance().clickFail("Exception occured while waiting for the element to be visible ");
		}
	}

	/**
	 * Waits for the specified element to become clickable. Logs success or failure
	 * messages and captures failure in ExtentReport.
	 *
	 * @param element     the WebElement to wait for
	 * @param elementName a descriptive name of the element (for logs/reporting)
	 */
	public void waitForElementToBeClickable(WebElement element, String elementName) {
		try {

			WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),
					Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			logger.info(elementName + " is clickable");
		} catch (Exception e) {
			logger.error("Exception occured while waiting for the element to be  clickable" + e.getMessage());
			ExtentFactory.getInstance().clickFail("Exception occured while waiting for the element to be  clickable");
		}
	}

	/**
	 * Waits for a given WebElement to be clickable within the defined explicit wait
	 * time. This method uses WebDriverWait and ExpectedConditions to pause the
	 * execution until the element is ready to receive click actions.
	 *
	 * @param element The WebElement to wait for.
	 */
	public void waitForElementToBeClickable(WebElement element) {
		{
			try {
				WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),
						Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));
				wait.until(ExpectedConditions.elementToBeClickable(element));
				logger.info(element + " is clickable");

			} catch (Exception e) {
				logger.error("Exception occured while waiting for the element to be  clickable" + e.getMessage());
				ExtentFactory.getInstance()
						.clickFail("Exception occured while waiting for the element to be  clickable");
			}

		}

	}
}
