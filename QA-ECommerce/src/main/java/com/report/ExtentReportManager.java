package com.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.constants.Constants;

/**
 * ExtentReportManager is responsible for configuring and setting up the
 * ExtentReports instance. It defines the output path for the HTML report and
 * attaches the SparkReporter.
 */
public class ExtentReportManager {

	/**
	 * Sets up and returns a configured ExtentReports object. This will be used to
	 * generate the HTML report of test execution.
	 *
	 * @return ExtentReports instance with Spark reporter attached
	 */
	public static ExtentReports setUpExtentReport() {

		// Create a SparkReporter which generates an HTML report at the specified path
		ExtentSparkReporter reporter = new ExtentSparkReporter(Constants.EXECUTION_REPORT_PATH);

		// Create the main ExtentReports instance
		ExtentReports extent = new ExtentReports();

		// Attach the SparkReporter object to the main ExtentReports object
		extent.attachReporter(reporter);

		// Return the configured ExtentReports instance
		return extent;

	}

}
