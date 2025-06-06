# 🛒 Product Test Automation – Add to Cart Workflow

This project contains a Selenium-based automation test for verifying the **"Add to Cart"** workflow of an e-commerce application  using the **Page Object Model (POM)**, **TestNG**, **ExtentReports**, and **Log4j**.
Url: https://advantageonlineshopping.com/
---

## ✅ Test Case: `verifyAddToCartWorkflow()`

### Test Scenario:
1. Launch the application
2. Search for a product (value from `testData.properties`)
3. Select the product from search results
4. Update the quantity in the cart
5. Proceed to checkout
6. Validate that the total price displayed matches the expected price

---

## 🔧 Technology Stack

- **Java**
- **Selenium WebDriver**
- **TestNG** (test execution)
- **ExtentReports** (reporting)
- **Log4j** (logging)
- **Maven** (build management)
- **Page Object Model (POM)**

---

## 📂 Folder Structure

src/
├── com.base # BaseTest class for browser setup
├── com.page # Page classes: HomePage, ProductPage, CartPage
├── com.tests # Test classes: ProductTest
├── com.properties # Test data and config loaders
├── com.report # ExtentReport Factory
resources/
├── config.properties # Browser and application config
└── testData.properties# Search keyword, product name, quantity, expected price