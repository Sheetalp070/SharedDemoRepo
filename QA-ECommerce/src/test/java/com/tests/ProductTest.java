package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.base.BaseTest;
import com.page.CartPage;
import com.page.HomePage;
import com.page.ProductPage;
import com.properties.TestDataLoader;
import com.report.ExtentFactory;


/**
 * ProductTest class verifies the complete add-to-cart workflow from searching a
 * product to verifying the total price in the cart. This test extends BaseTest
 * to inherit browser setup and teardown.
 */
public class ProductTest extends BaseTest {

	// Declare page objects
	HomePage homePage;
	CartPage cartPage;

	/**
	 * Test case: verifyAddToCartWorkflow Scenario: - Search for a product using
	 * data from testData.properties - Select the product from results - Update the
	 * quantity in cart - Proceed to checkout/cart - Assert that the displayed total
	 * price matches expected
	 */
	@Test
	public void verifyAddToCartWorkflow() {

		// Initialize page objects
		ExtentFactory.getInstance().getExtentTest().info("Test Started: verifyAddToCartWorkflow");

		HomePage homePage = new HomePage();
		ProductPage productPage = new ProductPage();
		CartPage cartPage = new CartPage();
		ExtentFactory.getInstance().getExtentTest().info("Page objects initialized");
		
		//Step 1. Search for a product
		String searchText = TestDataLoader.getInstance().getSearchText();
		ExtentFactory.getInstance().getExtentTest().info("Searching for product: " + searchText);
		homePage.SearchForItem(searchText);
		
		// Step 1.5. Verify product exists across paginated result pages
	    //productPage.verifyProductInSearchResults(searchText);
		
		//Step 2. Select the product from product listing
		String productName = TestDataLoader.getInstance().getProductName();
		ExtentFactory.getInstance().getExtentTest().info("Selecting product: " + productName);
		
		 productPage.SelectProduct(productName);
		//Step 3. Update the quantity of the selected product in the cart
		// is anything is wrong update the string as int
		String quantity = TestDataLoader.getInstance().getProductQuantity();
		//Step 4. Click checkout pop-up and go to cart
		cartPage.updateQuantity(quantity);
		ExtentFactory.getInstance().getExtentTest().info("Updating quantity to: " + quantity);
		cartPage.clickCheckOutPopUp();
		//Step 5. Verify the total product price in cart matches expected price1
		String actualPrice = cartPage.totalProductPrice();
		String expectedPrice = TestDataLoader.getInstance().getTotalProductPrice();
		Assert.assertEquals(actualPrice, expectedPrice);
		ExtentFactory.getInstance().getExtentTest().pass("Product price verification passed. Test completed successfully");

	}

}
