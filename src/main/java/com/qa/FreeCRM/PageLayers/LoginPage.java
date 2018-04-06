package com.qa.FreeCRM.PageLayers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.FreeCRM.Base.TestBase;

public class LoginPage extends TestBase{
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}


//  Page Factory or OR-object repository

@FindBy(xpath="//input[@name='username']")
WebElement username;

@FindBy(xpath="//input[@name='password']")
WebElement  password;

@FindBy(xpath= "//input[@type='submit']")
WebElement LoginButton;

@FindBy(xpath ="//button[contains(text(),signup)]")
WebElement SignupButton;

@FindBy(xpath="//img[@class='img-responsive']")
WebElement logo;


//Actions

public String ValidateLoginPagetitle()
{
	return driver.getTitle();
}

public boolean Validatelogo()
{
	return logo.isDisplayed();
}

public HomePage login(String un, String pwd) throws InterruptedException
{
	username.sendKeys(un);
	password.sendKeys(pwd);
	Thread.sleep(5000);
	LoginButton.click();
   return new HomePage();
		
}



}

