package com.page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BasePage;
import com.driver.DriverFactory;

/**
 * HomePage represents the landing page of the e-commerce application. It
 * provides methods to perform product search operations.
 */
public class HomePage extends BasePage {

	// WebDriver instance for wait handling
	WebDriver driver;
	// Explicit wait with a default timeout of 20 seconds
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	// WebElements for search icon)
	@FindBy(css = "svg[data-ng-click='openSearchProducts()']")
	private WebElement searchIcon;

	// WebElement for the search text input field)
	@FindBy(css = "input[id='autoComplete']")
	private WebElement searchTextArea;

	// WebElement for the 'View All' button after entering search term
	@FindBy(css = ".roboto-medium.viewAll.ng-scope")
	private WebElement viewAllBtn;

	// WebElement to close the search modal
	@FindBy(css = "div[data-ng-click=\"closeSearchForce()\"]")
	private WebElement closeBtn;

	// WebElement for loader on homepage
	@FindBy(css = "div.loader")
	private WebElement loader;

	/**
	 * Constructor initializes PageFactory elements using the current WebDriver
	 * instance.
	 */
	public HomePage() {
		this.driver = driver;
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
	}

	/**
	 * Searches for a product using the search icon, text input, and view all
	 * results.
	 * 
	 * @param productName the name of the product to search for
	 */
	public void SearchForItem(String productName) {
		// Wait for loader to disappear
		super.waitForLoaderToDisappear(loader); // this should already handle explicit wait

		// Wait until search icon is visible and clickable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(searchIcon));

		// Perform search steps
		super.click(searchIcon, "Search Icon");
		super.sendKeys(searchTextArea, "Search text box", productName);

		// Wait and click 'View All' button
		wait.until(ExpectedConditions.elementToBeClickable(viewAllBtn));
		super.click(viewAllBtn, "View All button");

		// Wait and click close button
		wait.until(ExpectedConditions.elementToBeClickable(closeBtn));
		super.click(closeBtn, "Close button");
	}

}
