package com.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

/**
 * RetryTransformer dynamically applies the RetryAnalyzer to all test methods at
 * runtime. This eliminates the need to manually add `retryAnalyzer` in
 * every @Test annotation.
 *
 * It works as a global retry mechanism using TestNG's IAnnotationTransformer.
 */
public class RetryTransformer implements IAnnotationTransformer {

	/**
	 * This method is invoked by TestNG for every test method. It modifies the test
	 * method's annotation to include the RetryAnalyzer.
	 *
	 * @param annotation      the test method's annotation
	 * @param testClass       the class in which the test method is defined
	 * @param testConstructor the constructor of the test class (if any)
	 * @param testMethod      the actual test method
	 */
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor,

			Method testMethod) {
		// Attach the custom RetryAnalyzer to the test method
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}

}
