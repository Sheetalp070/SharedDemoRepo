package com.properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import com.Constants.Constants;
import com.report.ExtentFactory;

public class TestDataLoader {
	private TestDataLoader() {
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

	private static TestDataLoader instance = new TestDataLoader();

	public static TestDataLoader getInstance() {

		if (instance == null) {
			instance = new TestDataLoader();
		}
		return instance;
	}

	private static Properties prop;

	private static void loadFile(String filePath) {
		FileReader reader = null;
		// Create FileReader class object
		try {
			reader = new FileReader(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();

			ExtentFactory.getInstance().failTest("Exception occured while reading test data file");
		}

		// Properties class object

		prop = new Properties();

		// load Properties file
		try {
			prop.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private String getPropertyValue(String key) {
		return prop.getProperty(key);
	}

	private int getIntValue(String key) {
		return Integer.parseInt(prop.getProperty(key));
	}

	public String getAppUrl() {
		return this.getPropertyValue("app_url");
	}

	

	public String getProductName() {
		return this.getPropertyValue("productName");
	}

	public String getSearchText() {
		return this.getPropertyValue("searchText");
	}

	public String getProductQuantity() {
		return this.getPropertyValue("quantity");
	}

	public String getTotalProductPrice() {
		return this.getPropertyValue("totalProductPrice");
	}

}
