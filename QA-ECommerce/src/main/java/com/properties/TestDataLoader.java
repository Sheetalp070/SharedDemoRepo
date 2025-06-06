package com.properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import com.Constants.Constants;
import com.report.ExtentFactory;

/**
 * TestDataLoader is a Singleton class responsible for loading test-specific
 * data from a .properties file based on the configured execution environment
 * (e.g., test or prod).
 * 
 * It provides access to key-value pairs such as product name, search text,
 * quantity, etc., required for test execution.
 */
public class TestDataLoader {

	// Private constructor to prevent direct instantiation (Singleton pattern)
	private TestDataLoader() {

		// Determine which test data file to load based on environment
		String env = Constants.EXECUTION_ENV;

		switch (env) {
		case "test":
			loadFile(Constants.TEST_ENV_DATA_FILE);
			break;

		case "prod":
			loadFile(Constants.PROD_ENV_DATA_FILE);
			break;

		default:
			ExtentFactory.getInstance().failTest("Invalid environment specified: " + env);
			break;
		}
	}

	// initialization of singleton instance
	private static TestDataLoader instance = new TestDataLoader();

	/**
	 * Returns the singleton instance of TestDataLoader.
	 * 
	 * @return instance of TestDataLoader
	 */
	public static TestDataLoader getInstance() {

		if (instance == null) {
			instance = new TestDataLoader();
		}
		return instance;
	}

	// Properties object to hold key-value pairs from the properties file
	private static Properties prop;

	/**
	 * Loads a .properties file from the given file path and initializes the
	 * Properties object.
	 *
	 * @param filePath path to the test data properties file
	 */
	private static void loadFile(String filePath) {
		FileReader reader = null;
		// Create FileReader class object
		try {
			reader = new FileReader(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();

			ExtentFactory.getInstance().failTest("Exception occured while reading test data file");
		}

		// Initialize Properties and load the file

		prop = new Properties();

		// load Properties file
		try {
			prop.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Retrieves a property value as a String from the loaded test data.
	 * 
	 * @param key property key
	 * @return corresponding value
	 */
	private String getPropertyValue(String key) {
		return prop.getProperty(key);
	}

	/**
	 * Retrieves a property value as an integer.
	 * 
	 * @param key property key
	 * @return corresponding value parsed as int
	 */
	private int getIntValue(String key) {
		return Integer.parseInt(prop.getProperty(key));
	}

	/**
	 * Gets the application URL from the test data.
	 */
	public String getAppUrl() {
		return this.getPropertyValue("app_url");
	}

	/**
	 * Gets the product name to be searched or validated.
	 */
	public String getProductName() {
		return this.getPropertyValue("productName");
	}

	/**
	 * Gets the search text used for product search.
	 */
	public String getSearchText() {
		return this.getPropertyValue("searchText");
	}

	/**
	 * Gets the product quantity (as string) to be entered or validated.
	 */
	public String getProductQuantity() {
		return this.getPropertyValue("quantity");
	}

	/**
	 * Gets the expected total product price from test data.
	 */
	public String getTotalProductPrice() {
		return this.getPropertyValue("totalProductPrice");
	}
	
	public String getTitle() {
		return this.getPropertyValue("title");
	}
	
	

}
