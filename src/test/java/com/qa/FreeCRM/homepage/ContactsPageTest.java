package com.qa.FreeCRM.homepage;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.FreeCRM.Base.TestBase;
import com.qa.FreeCRM.PageLayers.ContactsPage;
import com.qa.FreeCRM.PageLayers.HomePage;
import com.qa.FreeCRM.PageLayers.LoginPage;
import com.qa.FreeCRM.testUtil.Testutil;

public class ContactsPageTest extends TestBase {
		
	Testutil util;
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactpage;

	
	public ContactsPageTest()
	{
		super();
	}

	@BeforeMethod
	public void ContactPageTest() 
	{
		initialization();
		loginpage = new LoginPage();
		util= new Testutil();
		contactpage = new ContactsPage();
		try {
			homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
			//util.swithchtoFrame();
			contactpage =homepage.clickOnContactsLink();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} 
		
			
	}
	
	@DataProvider
	public Object[][] getCRMdata() throws IOException
	{
	  Object data[][] = util.getdata("Contacts");
	  return data;
	}
	
	@Test(dataProvider ="getCRMdata")
	public void getCRMData(String titletext,String FirstName,String Surname,String Company) throws IOException, InterruptedException
	{
	 homepage.clickonNewContact();
	 Thread.sleep(5000);	
	 contactpage.createNewContact(titletext, FirstName, Surname, Company);
	 homepage.ClickContactLinkWhenAlreadyinContactpage();
	 Thread.sleep(5000);
	 Assert.assertTrue(contactpage.VerifyconactSaved());
	}
	 
		@AfterMethod
	public void teardown()
	{
		driver.close();
	}
	
			 
		
	}


