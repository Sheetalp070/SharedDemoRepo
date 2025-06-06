package com.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public abstract class RetryAnalyzer implements IRetryAnalyzer  {
	
	private int retryCount=0;
	private static final int maxRetry=1;
	
	public boolean tetry(ITestResult result)
	{
		if(retryCount<maxRetry)
		{
			retryCount++;
			return true;
			
		}
		return false;
	}

}
