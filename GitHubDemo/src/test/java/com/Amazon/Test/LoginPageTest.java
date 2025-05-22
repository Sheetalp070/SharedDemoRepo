package com.Amazon.Test;
	
	import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.pages.LoginPage;


	public class LoginPageTest extends BaseTestAZ {

		LoginPage login;	
		BaseTestAZ baseTest;
		
			
			
			@BeforeMethod
		    public void setUp() {
		       
				baseTest = new BaseTestAZ();
		        login = new LoginPage(baseTest.driver);  
		    }
			
			/*
			 * @Test(enabled=false) public void loginToApplicationAmazon() {
			 * 
			 * login.loginWithValidUserNamePassword("sheetaltp070@gmail.com",
			 * "Marushopping@26");
			 * 
			 * 
			 * }
			 */
			@Test
			public void clikOnHaulLink()
			{
				//baseTest=new BaseTestAZ();
		
				baseTest.clickonAmaxonLink(login.AmazonHaulLink);
				Assert.assertTrue(driver.getCurrentUrl().contains("haul/store"), "Amazon Haul page is not displaying");
				driver.navigate().back();
				
			}
			
						
			@Test
			public void clikOnBasicLink()
			{
				//baseTest=new BaseTestAZ();
				baseTest.clickonAmaxonLink(login.AmazonBasicLink);
				Assert.assertTrue(driver.getCurrentUrl().contains("amazonbasics"), "Amazon Basic page is not displaying");
				driver.navigate().back();
				
			}
			
			@Test
			public void clikOnBestSellerLink()
			{
				//baseTest=new BaseTestAZ();
				baseTest.clickonAmaxonLink(login.AmazonBestSellerLink);
				Assert.assertTrue(driver.getCurrentUrl().contains("bestseller"), "Amazon Best Seller page is not displaying");
				driver.navigate().back();
				
			}
			
			@Test
			public void clikOnPrimeLink()
			{
				//baseTest=new BaseTestAZ();
				baseTest.clickonAmaxonLink(login.AmazonPrimeLink);
				Assert.assertTrue(driver.getCurrentUrl().contains("primelink"), "Amazon Prime Link  page is not displaying");
				driver.navigate().back();
				
			}
		}

