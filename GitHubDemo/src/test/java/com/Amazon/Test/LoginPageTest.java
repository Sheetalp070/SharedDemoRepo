package com.Amazon.Test;
	
	import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.pages.LoginPage;


	public class LoginPageTest extends BaseTestAZ {

		LoginPage login;			
			
			
			@BeforeMethod
		    public void setUp() {
		       
				 login = new LoginPage(driver); 
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
				login.clickonAmaxonHaulLink();
				Assert.assertTrue(driver.getCurrentUrl().contains("haul/store"), "Amazon Haul page is not displaying");
				driver.navigate().back();
				
			}
			
			@Test
			public void clikOnBasicLink()
			{
				login.clickonAmaxonBasicLink();
				Assert.assertTrue(driver.getCurrentUrl().contains("amazonbasics"), "Amazon Haul page is not displaying");
				driver.navigate().back();
				
			}
		}

