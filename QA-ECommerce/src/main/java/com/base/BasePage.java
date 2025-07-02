package com.base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.alert.AlertActions;
import com.report.ExtentFactory;
import com.wait.ExplicitWaitActions;

/**
 * BasePage provides common reusable actions that all page classes can extend.
 * Includes explicit wait handling, alert interaction, and basic element
 * utilities like click, sendKeys, etc.
 */
public class BasePage {
	// Utility class for explicit wait operations
	protected ExplicitWaitActions explicitWaitActions;
	// Utility class for alert handling
	protected AlertActions alertActions;
	// WebDriver instance for the current session
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	/**
	 * Protected constructor initializes helper utility classes. This constructor is
	 * typically called by subclasses.
	 */
	protected BasePage() {

		explicitWaitActions = new ExplicitWaitActions();

		alertActions = new AlertActions();
	}

	/**
	 * Clicks on a WebElement after waiting for it to be clickable.
	 * 
	 * @param element     the WebElement to click
	 * @param elementName a readable name for reporting purposes
	 */
	public void click(WebElement element, String elementName) {
		explicitWaitActions.waitForElementToBeClickable(element, elementName);
		element.click();
		ExtentFactory.getInstance().passTest(elementName + " is clicked");
	}

	/**
	 * Waits for a given WebElement to be clickable within the defined explicit wait
	 * time. This method uses WebDriverWait and ExpectedConditions to pause the
	 * execution until the element is ready to receive click actions.
	 *
	 * @param element The WebElement to wait for.
	 */

	public void click(WebElement element) {
		explicitWaitActions.waitForElementToBeClickable(element);
		element.click();
		ExtentFactory.getInstance().passTest(element + " is clicked");

	}

	/**
	 * Sends input to a WebElement after clearing it, and waits for the element to
	 * be present.
	 * 
	 * @param element     the input field WebElement
	 * @param elementName a readable name for reporting
	 * @param value       the text value to send
	 */
	public void sendKeys(WebElement element, String elementName, String value) {
		explicitWaitActions.waitForElementToBePresent(element, elementName);
		element.clear();
		element.sendKeys(value);
		ExtentFactory.getInstance().passTest(value + " is entered in " + elementName);
	}

	/**
	 * Checks whether a given WebElement (e.g., checkbox or radio button) is
	 * selected.
	 * 
	 * @param element     the WebElement to check
	 * @param elementName a readable name for reporting
	 * @return true if selected, false otherwise
	 */
	public boolean isElementSelected(WebElement element, String elementName) {
		explicitWaitActions.waitForElementToBePresent(element, elementName);
		boolean result = element.isSelected();
		return result;
	}

	/**
	 * Selects a checkbox or similar toggle if it's not already selected.
	 * 
	 * @param element     the checkbox WebElement
	 * @param elementName a readable name for reporting
	 */
	public void selectCheckBox(WebElement element, String elementName) {
		explicitWaitActions.waitForElementToBePresent(element, elementName);
		if (this.isElementSelected(element, elementName)) {
			this.click(element, elementName);
		} else {
			ExtentFactory.getInstance().failTest(elementName + " is already selected");
		}

	}

	/**
	 * Returns the visible text from a WebElement after waiting for it to be
	 * present.
	 * 
	 * @param element     the WebElement
	 * @param elementName a readable name for reporting
	 * @return the text of the element
	 */
	public String getText(WebElement element, String elementName) {
		explicitWaitActions.waitForElementToBePresent(element, elementName);
		String text = element.getText();
		return text;
	}

	/**
	 * Waits until a loading spinner or loader element becomes invisible.
	 * 
	 * @param element the loader WebElement
	 */
	public void waitForLoaderToDisappear(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
		ExtentFactory.getInstance().passTest("Loader is not visible");
	}

}
