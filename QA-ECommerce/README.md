# QA-ECommerce Test Automation Framework

This project is a test automation framework designed to validate the end-to-end workflow of an e-commerce application using Java, Selenium WebDriver, and TestNG. It follows the Page Object Model (POM) design pattern for maintainability and scalability.
URL: https://advantageonlineshopping.com


##  Tech Stack

- Language: Java
- Automation Tool: Selenium WebDriver
- Test Framework: TestNG
- Build Tool: Maven
- Design Pattern: Page Object Model (POM)
- Reports: ExtentReports
- Logging: Log4j
- Retry Mechanism: Custom RetryAnalyzer
- Test Data: Properties file-based external configuration

##  Test Case: verifyAddToCartWorkflow
This test checks if a user can search for a product, add it to the cart, change the quantity, and see the correct total price.

## Test Steps (Simple Language)
1. Open the website in a browser.
2. Search for a product (like "Laptop") using the value from the test data file.
3. Make sure all the products shown in the search results have the product name in their title.
4. Go to the last item of search results and select the last product.
5. Add that product to the cart.
6. Open the cart and update the product quantity (like 2).
7. Get the unit price of the product.
8. Calculate the total price (unit price × quantity).
9.Check that the total price shown in the cart is correct.
10.Log each step in the test report (ExtentReport) and show a pass/fail result.

## Project Structure 


QA-ECommerce/
├── pom.xml
├── testng.xml
├── execution.html                 
├── src/
│   ├── main/java/com/
│   │   ├── alert/                  # AlertActions.java
│   │   ├── base/                   # BasePage.java
│   │   ├── constants/              # Constants.java
│   │   ├── driver/                 # BrowserFactory, DriverFactory
│   │   ├── pages/                  # HomePage, ProductPage, CartPage
│   │   ├── properties/             # ConfigLoader, TestDataLoader
│   │   ├── report/                 # ExtentReportManager, ExtentFactory, Listener
│   │   └── wait/                   # ExplicitWaitActions, ImplicitWaitActions
│
│   ├── test/java/com/
│   │   ├── base/                   # BaseTest.java
│   │   ├── tests/                  # ProductTest.java
│   │   └── utils/                  # RetryAnalyzer, RetryTransformer
│
│   └── test/resources/
│       ├── execution/              # config.properties
│       └── testdata/               # test_data.properties, prod_data.properties


## Author 

Sheetal Patel 

