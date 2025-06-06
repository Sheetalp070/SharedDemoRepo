package com.report;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.driver.DriverFactory;

/**
 * ExtentFactory is a singleton utility class that manages ExtentTest instances
 * using ThreadLocal for safe parallel test execution. It handles logging,
 * screenshot capturing, and step-level reporting for test cases.
 */
public class ExtentFactory {

	// ThreadLocal ensures each thread has its own ExtentTest instance (useful for
	// parallel test execution)
	ThreadLocal<ExtentTest> extent = new ThreadLocal<ExtentTest>();

	// Private constructor for singleton pattern
	private ExtentFactory() {

	}

	 // Singleton instance of ExtentFactory
	private static ExtentFactory instance = new ExtentFactory();

	/**
     * Returns the singleton instance of ExtentFactory.
     */
	public static ExtentFactory getInstance() {
		return instance;

	}

	 /**
     * Sets the ExtentTest object for the current thread.
     * @param obj the ExtentTest instance to set
     */
	public void setExtent(ExtentTest obj) {
		extent.set(obj);
	}

	/**
     * Returns the ExtentTest object associated with the current thread.
     */
	public ExtentTest getExtentTest() {
		return extent.get();
	}
	/**
     * Removes the ExtentTest instance from the current thread
     * to prevent memory leaks.
     */
	public void removeExtentTest() {
		extent.remove();
	}

	/**
     * Captures a screenshot of the current browser state and returns it as a Base64 string.
     * Used for embedding screenshots in ExtentReports.
     */
	public static String captureApplicationScreenshot() {
		WebDriver driver = DriverFactory.getInstance().getDriver();

		if (driver == null || !(driver instanceof TakesScreenshot)) {
			System.err.println("WebDriver is null or doesn't support screenshots");
			return "";
		}

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			byte[] content = FileUtils.readFileToByteArray(file);
			return Base64.getEncoder().encodeToString(content);
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
     * Logs a test step as failed and attaches a screenshot if available.
     * @param msg the failure message
     */
	public static void failTest(String msg) {
		try {
			ExtentTest test = getInstance().getExtentTest();
			if (test == null) {
				System.err.println("ExtentTest is null — skipping logging");
				return;
			}

			String screenshot = captureApplicationScreenshot();
			if (!screenshot.isEmpty()) {
				test.fail(msg, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
			} else {
				test.fail(msg + " (screenshot not available)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
     * Logs a test step as passed with a green label in the report.
     * @param msg the pass message
     */
	public static void passTest(String msg) {
		ExtentTest test = getInstance().getExtentTest();
		if (test != null) {
			test.log(Status.PASS, MarkupHelper.createLabel(msg, ExtentColor.GREEN));
		}
	}

	/**
     * Logs a successful click action in the test report.
     * @param btnName the name of the button clicked
     */

	public static void clickPass(String btnName) {
		getInstance().getExtentTest().pass(btnName + " is clicked ");
	}
	
	/**
     * Logs a failed click action in the test report.
     * @param btnName the name of the button attempted to be clicked
     */
	public static void clickFail(String btnName) {
		getInstance().getExtentTest().fail("Error occured while clicking " + btnName);
	}

	/**
     * Logs a successful sendKeys (text entry) action in the report.
     * @param value the value entered
     * @param elementName the name of the element where text was entered
     */
	public static void sendKeysPass(String value, String elementName) {
		getInstance().getExtentTest().pass(value + "is entered on " + elementName);
	}

	/**
     * Logs a failed sendKeys action in the report.
     * @param value the value attempted to enter
     * @param elementName the name of the element
     */
	public static void sendKeysFail(String value, String elementName) {
		getInstance().getExtentTest().pass("Error occured while " + value + "is entered on " + elementName);
	}

	// Logs a general test step as passed with a green label in the report
	/*
	 * public static void passTest(String msg) {
	 * 
	 * getInstance().getExtentTest().log(Status.PASS, MarkupHelper.createLabel(msg,
	 * ExtentColor.GREEN)); }
	 * 
	 * // Logs a test step as failed along with a screenshot (captured as Base64)
	 * 
	 * public static void failTest(String msg) { try { String base64Screenshot =
	 * captureApplicationScreenshot(); ExtentTest test =
	 * getInstance().getExtentTest();
	 * 
	 * if (base64Screenshot != null && !base64Screenshot.isEmpty()) { test.fail(msg,
	 * MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).
	 * build()); } else { test.fail(msg + " (screenshot not available)"); } } catch
	 * (Exception e) { getInstance().getExtentTest().fail(msg +
	 * " (exception while capturing screenshot)"); e.printStackTrace(); }
	 */
}
