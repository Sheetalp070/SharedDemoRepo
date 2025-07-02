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
import org.testng.Assert;

import com.driver.DriverFactory;
import com.report.ExtentFactory;

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
	
	@FindBy(linkText="Next")
	private WebElement NextBtn;

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
		 driver.findElements(By.cssSelector(".productName.ng-binding"));

		// Iterate over the product list to find the matching product name
		for (WebElement product : productList) {
			if (product.getText().equalsIgnoreCase(productName)) {
				System.out.println("Selected Product: " + product.getText());

				// Wait until the product is clickable, then click it
				
				product.click();

				// Stop the loop once the product is found and clicked
				break;
			}
		}

	}
	//This method is to verify search query  text present on the results list 
	public void verifyProductInSearchResults(String searchText) throws InterruptedException {
	    boolean productFound = false;

	    while (true) {
	        List<WebElement> productTitles = DriverFactory.getInstance().getDriver()
	            .findElements(By.cssSelector(".productName.ng-binding"));
	            		

	        for (WebElement product : productTitles) {
	            String productName = product.getText();
	            if (productName.toLowerCase().contains(searchText.toLowerCase())) {
	                ExtentFactory.getInstance().getExtentTest().info("Product found: " + productName);
	                productFound = true;
	            }
	        }

	        List<WebElement> nextButtons = DriverFactory.getInstance().getDriver()
	            .findElements(By.linkText("Next")); 

	        if (nextButtons.size() > 0 && nextButtons.get(0).isEnabled()) {
	            nextButtons.get(0).click();
	            ExtentFactory.getInstance().getExtentTest().info("Navigated to next search result page.");
	            wait.until(ExpectedConditions.elementToBeClickable(NextBtn));
	        } else {
	            break;
	        }
	    }

	    if (!productFound) {
	        ExtentFactory.getInstance().getExtentTest()
	            .fail("No matching product found for search term: " + searchText);
	    }

	    Assert.assertTrue(productFound, "No product matched the search term: " + searchText);
	}

}
