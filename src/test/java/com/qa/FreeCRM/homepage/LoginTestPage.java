package com.qa.FreeCRM.homepage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.FreeCRM.Base.TestBase;
import com.qa.FreeCRM.PageLayers.HomePage;
import com.qa.FreeCRM.PageLayers.LoginPage;

public class LoginTestPage extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginTestPage(){
		super();  // Super keyword gets the data from TestBase Constructor
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();  // from base Class
		loginpage = new LoginPage();  //LoginPage initialization.
		
	}
	
    @Test(priority=1)
	public void ValidateloginpageTitleTest()
	{
		String LPtitle = loginpage.ValidateLoginPagetitle();
		Assert.assertEquals("#1 Free CRM for Any Business: Online Customer Relationship Software",LPtitle);
		
	}
    @Test(priority=2)
    public void ValidatelogoTest()
    {
    	boolean flag =loginpage.Validatelogo();
    	Assert.assertTrue(flag);
    }
    
    @Test(priority=3)
    public void ValidateHomePagelogin() throws Exception
    {
    	 homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
    	 String hptitle = homepage.ValidateHomePagePagetitle();
    	 Assert.assertEquals("CRMPRO", hptitle);
       	    	 
    }
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();;
	}
}         
