# 🛒 ProductTest – Add to Cart Workflow Automation

This project contains an automated test case `ProductTest.java` that verifies the **"Add to Cart" workflow** for an e-commerce application. It uses **Selenium WebDriver**, **TestNG**, **ExtentReports**, **Log4j**, and follows the **Page Object Model (POM)** design pattern.
Application URL: https://advantageonlineshopping.com
---

## ✅ Test Case Summary

**Class:** `ProductTest`  
**Test Method:** `verifyAddToCartWorkflow()`

### 📋 Scenario Steps:
1. Open the application URL
2. Search for a product (from `testData.properties`)
3. Select the product from the results
4. Update product quantity
5. Proceed to the cart
6. Verify that the displayed total price matches the expected price

---

## 🧰 Tech Stack

- Java 17+
- Selenium WebDriver 4.x
- TestNG
- Maven
- ExtentReports
- Log4j
- Page Object Model (POM)

---

## 📁 Folder Structure

src/
├── test/
│ ├── java/
│ │ ├── com.base/ # BaseTest.java, Browser setup
│ │ ├── com.page/ # HomePage.java, ProductPage.java, CartPage.java
│ │ ├── com.tests/ # ProductTest.java
│ │ ├── com.report/ # ExtentFactory.java, Report setup
│ │ └── com.properties/ # TestDataLoader.java, ConfigLoader.java
│ └── resources/
│ ├── config.properties # Browser config
│ └── testData.properties # Product search, name, quantity, expected price

