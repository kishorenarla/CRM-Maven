package com.qa.FreeCRM.homepage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.FreeCRM.Base.TestBase;
import com.qa.FreeCRM.PageLayers.HomePage;
import com.qa.FreeCRM.PageLayers.LoginPage;
import com.qa.FreeCRM.PageLayers.ScheduleCallPage;
import com.qa.FreeCRM.testUtil.Testutil;

import junit.framework.Assert;

public class ScheduleCallPageTest  extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	ScheduleCallPage schedulecallPage;
	Testutil util;
	public ScheduleCallPageTest()
	{
		super();
		
	}
	@BeforeMethod
	public void ScheduleCallInit() throws InterruptedException
	{
		initialization();
		homepage = new HomePage();
		loginpage = new LoginPage();
		util = new Testutil();
		schedulecallPage= new ScheduleCallPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void SchedulecallPage() throws InterruptedException
	{
	
		homepage.clickonScheduleLink();
		boolean b = schedulecallPage.checkboxenabled();
		Assert.assertTrue(b);
	}
	
}
