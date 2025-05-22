package com.amazon.pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	
	
	@FindBy(xpath = "//span[contains(text(),'Hello, sign in')]")
	public WebElement singInLink;

	// Password
	@FindBy(name = "username")
	public WebElement username;
	
	@FindBy(css=".a-button-input")
	public WebElement ContinueButton;
	
	@FindBy(name = "password")
	public WebElement passWord;
	
	@FindBy(css = "#auth-signin-button")
	public WebElement signInButton;	
	
	@FindBy(css="a[data-csa-c-content-id='nav_cs_hul_disb']")
	public WebElement AmazonHaulLink;
	
	@FindBy(css="a[data-csa-c-content-id='nav_cs_amazonbasics']")
	public WebElement AmazonBasicLink;
	
	

	public LoginPage(WebDriver driver) 
	{
        this.driver=driver;
		PageFactory.initElements(driver, this);
	}	 

	public void loginWithValidUserNamePassword(String usernameValue,String password)
	{			
			singInLink.click();
			wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(usernameValue);
			wait.until(ExpectedConditions.visibilityOf(ContinueButton)).click();
			wait.until(ExpectedConditions.visibilityOf(passWord)).sendKeys(password);
			wait.until(ExpectedConditions.visibilityOf(signInButton)).click();    
	}
	
	public void clickonAmaxonHaulLink()
	{
		wait.until(ExpectedConditions.visibilityOf(AmazonHaulLink)).click(); 
	}
	
	public void clickonAmaxonBasicLink()
	{
		wait.until(ExpectedConditions.visibilityOf(AmazonBasicLink)).click(); 
	}

}
