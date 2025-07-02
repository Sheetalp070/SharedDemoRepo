package com.properties;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.constants.Constants;

/**
 * ConfigLoader is a singleton utility class responsible for loading
 * configuration values from the config.properties file located at a fixed path.
 * 
 * It sets the execution environment (e.g., "test", "prod") and provides access
 * to other config values via key-based lookups.
 */
public class ConfigLoader {

	// Logger instance for logging exceptions and information
	private Logger logger = LogManager.getLogger(ConfigLoader.class);
	// Properties object to hold loaded key-value pairs from the config file
	private final Properties prop = new Properties();

	/**
	 * Private constructor that reads the config.properties file and loads its
	 * content. Also sets the global execution environment (TEST or PROD) in
	 * Constants.
	 */
	private ConfigLoader()

	{        //File reader reads the file from a fixed path 
		try (FileReader reader = new FileReader(Constants.CONFIG_FILE_PATH)) {
			// Load properties(key-value) from file into the prop object
			prop.load(reader);

			// Set the execution environment in the Constants class
			Constants.EXECUTION_ENV = getPropertyValue("environment");
		} catch (IOException e) {

			// Log and rethrow exception if config file loading fails
			logger.error("Exception occured while reading config file" + Constants.CONFIG_FILE_PATH, e);
			throw new RuntimeException("Failed to load config.properties :" + e.getMessage(), e);

		}

	}

	// Initialization of singleton instance
	private static ConfigLoader instance = new ConfigLoader();

	/**
	 * Provides access to the singleton instance of ConfigLoader. Uses
	 * double-checked locking for thread safety during lazy initialization.
	 *
	 * @return ConfigLoader instance
	 */
	public static ConfigLoader getInstance() {
		if (instance == null) {
			synchronized (ConfigLoader.class) {
				if (instance == null) {
					instance = new ConfigLoader();
				}
			}
		}

		return instance;
	}

	/**
	 * Returns the value associated with a given key from the config file.
	 *
	 * @param key the configuration key
	 * @return the corresponding value as a String
	 */
	public String getPropertyValue(String key) {
		return prop.getProperty(key);
	}

}
