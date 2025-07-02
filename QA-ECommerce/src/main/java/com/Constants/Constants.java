package com.constants;

/**
 * Constants class holds all the global static constant values used across the
 * automation framework. These values are primarily file paths, environment
 * variables, and wait durations.
 */
public abstract class Constants {

	// Gets the current working directory (project root path)
	public static final String CURRENT_DIR = System.getProperty("user.dir");

	// Path where the ExtentReports execution HTML file will be generated
	public static final String EXECUTION_REPORT_PATH = CURRENT_DIR + "/Reports/execution.html";

	// Path to the configuration properties file (general execution settings)
	public static final String CONFIG_FILE_PATH = CURRENT_DIR + "/src/test/resources/execution/config.properties";

	// Environment variable used to determine which test data file to load ("test"
	// or "prod")
	public static String EXECUTION_ENV = "";

	// Path to test environment test data file
	public static final String TEST_ENV_DATA_FILE = CURRENT_DIR + "/src/test/resources/testData/test_data.properties";

	// Path to production environment test data file (currently same as test file;
	// can be separated if needed)
	public static final String PROD_ENV_DATA_FILE = CURRENT_DIR + "/src/test/resources/testData/prod_data.properties";

	// Explicit wait time (in seconds) for WebDriverWait
	public static final int EXPLICIT_WAIT_TIME = 20;

	// Implicit wait time (in seconds) for WebDriverWait
	public static final int IMPLICIT_WAIT_TIME = 20;

}
