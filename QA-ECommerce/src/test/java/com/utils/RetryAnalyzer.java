package com.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


/**
 * RetryAnalyzer implements TestNG's IRetryAnalyzer to re-run failed test cases.
 * This is useful for handling flaky tests that fail due to intermittent issues (e.g., UI sync, network delay).
 */
public class RetryAnalyzer implements IRetryAnalyzer {

	// Counter to keep track of retry attempts
	private int retryCount=0;
	// Maximum number of times to retry a failed test
	private static final int maxRetryCount=2;
	
	/**
     * This method is called by TestNG to determine whether a failed test should be retried.
     * @param result The result of the test method that just ran.
     * @return true if TestNG should retry the test, false otherwise.
     */
	@Override
	public boolean retry(ITestResult result) {
		if (retryCount<maxRetryCount)
		{
			retryCount++;
			return true;
			
		}
		return false;
	}
	
	
}
