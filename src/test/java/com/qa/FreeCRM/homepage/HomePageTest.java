package com.qa.FreeCRM.homepage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.FreeCRM.Base.TestBase;
import com.qa.FreeCRM.PageLayers.ContactsPage;
import com.qa.FreeCRM.PageLayers.HomePage;
import com.qa.FreeCRM.PageLayers.LoginPage;
import com.qa.FreeCRM.testUtil.Testutil;

public class HomePageTest extends TestBase {

	
	HomePage homepage;
	LoginPage loginpage;
	ContactsPage cpage;
	Testutil testutil;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void HomePageTest1() 
	{
		initialization();
		try {
		    loginpage= new LoginPage();
			homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
			testutil = new Testutil();
		
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}	
	 	
	 }
	
	@Test(priority=1)
	public void VerifyUser()
	{  
		testutil.swithchtoFrame(); 
		
		Assert.assertTrue(homepage.LoggeruserVerify());
	}
	
	@Test(priority =2)
	public void ClickonScheduleLink() throws InterruptedException
	{
		homepage.clickonScheduleLink();
	}
	 
	 @Test(enabled =false)
	 public void clickOnContactslinkTest() 
	 {    
		 testutil.swithchtoFrame();
		  homepage.clickOnContactsLink();
		 
	 }
	
	 @AfterMethod
	 public void teardown()
	 {
		 driver.close();
	 }
	
}
