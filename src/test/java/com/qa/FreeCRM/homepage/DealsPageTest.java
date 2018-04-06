package com.qa.FreeCRM.homepage;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.FreeCRM.Base.TestBase;
import com.qa.FreeCRM.PageLayers.DealsPage;
import com.qa.FreeCRM.PageLayers.HomePage;
import com.qa.FreeCRM.PageLayers.LoginPage;
import com.qa.FreeCRM.testUtil.Testutil;

public class DealsPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	Testutil util;
	DealsPage dealspage;
	
	public DealsPageTest()
	{
		super();
	}
    
	@BeforeMethod
	public void DealsPageTestinit() throws InterruptedException
	{
		initialization();
		 loginpage = new LoginPage();
		 homepage = new HomePage();
		 util = new Testutil();
		 homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		 dealspage = new DealsPage();
	}
   
	@DataProvider
    public Object[][] getDealdata() throws IOException
    {
    	Object[][] data = util.getdata("Deals");
    	return data;
    }
   
    @Test
    public void fillNewDeals() throws InterruptedException
    {
    	homepage.clickOnNewDeal();
    	dealspage.newDealformfill();
    }
   
    @AfterMethod
    public void teardown()
    {
    	//driver.close();
    }
       
}
