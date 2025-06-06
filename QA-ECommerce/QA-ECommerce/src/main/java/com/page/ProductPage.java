package com.page;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.driver.DriverFactory;

/**
 * ProductPage represents the page displaying the list of available products. It
 * allows selection of a specific product based on its name.
 */
public class ProductPage {
	// WebDriver instance used for interacting with the page
	private WebDriver driver;

	// Explicit wait for handling synchronization
	private WebDriverWait wait;

	// List of product elements displayed on the product page
	@FindBy(css = ".productName.ng-binding")
	private List<WebElement> productList;

	/**
	 * Constructor initializes the WebDriver and WebDriverWait, and binds the web
	 * elements using PageFactory.
	 */
	public ProductPage() {

		this.driver = DriverFactory.getInstance().getDriver();
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}

	/**
	 * Selects a product from the product list based on the provided product name.
	 * Waits for the product element to be clickable and then clicks on it.
	 *
	 * @param productName the name of the product to be selected
	 */
	public void SelectProduct(String productName) {

		// Dynamically fetch all products using CSS selector
		// List<WebElement> products =
		// driver.findElements(By.cssSelector(".productName.ng-binding"));

		// Iterate over the product list to find the matching product name
		for (WebElement product : productList) {
			if (product.getText().equalsIgnoreCase(productName)) {
				System.out.println("Selected Product: " + product.getText());

				// Wait until the product is clickable, then click it
				wait.until(ExpectedConditions.elementToBeClickable(product));
				product.click();

				// Stop the loop once the product is found and clicked
				break;
			}
		}

	}

}
