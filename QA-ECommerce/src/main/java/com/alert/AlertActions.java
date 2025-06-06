package com.alert;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.driver.DriverFactory;
import com.report.ExtentFactory;

/**
 * AlertAction class for handling JavaScript alert popups in Selenium WebDriver.
 * Provides methods to accept or cancel alerts, with logging and reporting.
 */
public class AlertActions {

	private Logger logger = LogManager.getLogger(AlertActions.class);

	/**
	 * Accepts a JavaScript alert if present. Waits up to 10 seconds for the alert
	 * to appear. Logs and reports the outcome using Log4j and ExtentReports.
	 */
	public void acceptAlert() {
		try {
			WebDriver driver = DriverFactory.getInstance().getDriver();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// Wait for the alert to be present
			wait.until(ExpectedConditions.alertIsPresent()); // Wait for alert

			// Wait for the alert to be present
			Alert alert = driver.switchTo().alert(); // Switch safely

			alert.accept(); // Accept the alert
			logger.info("Alert accepted successfully.");
			ExtentFactory.getInstance().passTest("Alert accepted successfully.");
		} catch (NoAlertPresentException e) {
			logger.error("No alert present to accept.");
			ExtentFactory.getInstance().failTest("No alert present to accept.");
		} catch (Exception e) {
			logger.error("Error while accepting alert: " + e.getMessage());
			ExtentFactory.getInstance().failTest("Error while accepting alert: " + e.getMessage());
		}
	}

	/**
	 * Cancels  a JavaScript alert if present. Logs and reports the
	 * action.
	 */
	public void cancelAlert() {
		try {
			// Switch to alert and dismiss it
			Alert alert = DriverFactory.getInstance().getDriver().switchTo().alert();
			alert.dismiss();
			logger.info("Clicked Cancel on alert");
			ExtentFactory.getInstance().passTest("Clicked Cancel on alert");
		} catch (NoAlertPresentException e) {
			logger.error("No alert present to cancel");
			ExtentFactory.getInstance().failTest("No alert present to cancel");
		}
	}

}
