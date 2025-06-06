package com.page;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BasePage;
import com.base.BaseTest;
import com.driver.DriverFactory;

/**
 * CartPage represents the shopping cart page in the e-commerce application. It
 * contains actions like updating quantity, proceeding to checkout, and
 * verifying product prices in the cart.
 */
public class CartPage extends BasePage {
	// WebDriver instance (used here to initialize waits)
	WebDriver driver;

	// Explicit wait for cart-related elements
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	// Locators for elements on the Cart Page
	@FindBy(css = ".checkout_button")
	private WebElement checkOutButton;

	@FindBy(name = "quantity")
	private WebElement quantityUpdatField;

	@FindBy(xpath = "((//h2[@class='roboto-thin screen768 ng-binding'])[1]")
	private WebElement unitPrice;

	@FindBy(css = "button[translate='ADD_TO_CART']")
	private WebElement addToCartBtn;

	@FindBy(id = "checkOutPopUp")
	private WebElement checkOutPopUp;

	@FindBy(css = "#menuCart")
	private WebElement cartIcon;

	@FindBy(xpath = "(//span[@class='roboto-medium ng-binding'])[3]")
	private WebElement totalProuctPrice;

	/**
	 * Constructor initializes the PageFactory elements with the active WebDriver.
	 */
	public CartPage() {
		this.driver = driver;
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
	}

	/**
	 * Updates the product quantity in the input field and clicks the "Add to Cart" button.
	 * Implements retry logic to handle StaleElementReferenceException by refreshing the element.
	 *
	 * @param quantity the desired quantity to set (as String)
	 */

	public void updateQuantity(String quantity) {
		// Retry up to 2 times in case of stale element reference
		for (int i = 0; i < 2; i++) {
	        try {
	        	 // Wait for the quantity field to be visible and ensure it's a fresh reference
	            WebElement field = wait.until(ExpectedConditions.refreshed(
	                    ExpectedConditions.visibilityOf(quantityUpdatField)));

	            // Clear existing value using keys
	            field.sendKeys(Keys.CONTROL + "a");
	            field.sendKeys(Keys.DELETE);

	            // Send new quantity (converted to String)
	            super.sendKeys(field, "Quantity field", String.valueOf(quantity));

	            // Wait and click Add to Cart
	            wait.until(ExpectedConditions.refreshed(
	                    ExpectedConditions.visibilityOf(addToCartBtn)));
	            super.click(addToCartBtn, "Add to Cart Button");

	            break; // exit loop on success
	        } catch (org.openqa.selenium.StaleElementReferenceException e) {
	            System.out.println("Retrying quantity update due to stale element...");
	        }
	    }
	}
	/**
	 * Waits for the checkout popup to disappear, then clicks on the cart icon to
	 * proceed.
	 */
	public void clickCheckOutPopUp() {
		wait.until(ExpectedConditions.invisibilityOf(checkOutPopUp));
		super.click(cartIcon, "Cart Icon ");

	}

	/**
	 * Returns the total product price shown in the cart.
	 * 
	 * @return total price as a String
	 */
	public String totalProductPrice() {
		wait.until(ExpectedConditions.visibilityOf(quantityUpdatField));
		String priceValue = super.getText(totalProuctPrice, "Total Product Price");
		return priceValue;
	}

}
