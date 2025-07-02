package com.report;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

/**
 * ExtentReportListener integrates TestNG test execution lifecycle with
 * ExtentReports. It listens to test events (start, success, failure, etc.) and
 * logs them accordingly in the report.
 */
public class ExtentReportListner implements ITestListener {

	// Logger instance for logging framework-level events
	private static Logger logger = LogManager.getLogger(ExtentReportListner.class);

	// ExtentReports instance to generate the HTML report
	private ExtentReports extentReports;
	// ExtentTest represents the current test in the report
	private ExtentTest extentTest;

	/**
	 * Invoked when a test starts. Creates a new ExtentTest instance and associates
	 * it with the current thread using ExtentFactory.
	 */
	public void onTestStart(ITestResult result) {
		this.extentTest = extentReports.createTest(result.getName());
		//Add the extenseTest instance to threadlocal pool
		ExtentFactory.getInstance().setExtent(extentTest);
		logger.info("Test is added in pool");
	}

	/**
	 * Invoked when a test completes successfully. Logs a PASS status using
	 * ExtentFactory.
	 */
	public void onTestSuccess(ITestResult result) {
		ExtentFactory.getInstance().passTest(result.getName());
	}

	/**
     * Invoked when a test fails.
     * Logs the exception message and marks the test as failed in the report.
     */
	public void onTestFailure(ITestResult result) {
		ExtentFactory.getInstance().getExtentTest().fail("Exception fail" + result.getThrowable().getMessage());
	}

	/**
     * Invoked when a test is skipped.
     * Logs the test as skipped in ExtentReports.
     */
	public void onTestSkipped(ITestResult result) {

		ExtentFactory.getInstance().getExtentTest().log(Status.SKIP, "Test case" + result.getName() + "is skipped");
	}

	/**
     * Invoked before any test methods are run in the suite.
     * Initializes the ExtentReports object using the report manager.
     */
	public void onStart(ITestContext context) {

		this.extentReports = ExtentReportManager.setUpExtentReport();

	}

	/**
	 * Invoked once after all tests in the suite have finished. Flushes the report
	 * to write all collected results to the HTML file.
	 */
	public void onFinish(ITestContext context) {
		this.extentReports.flush();

	}

}
