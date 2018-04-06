package com.qa.FreeCRM.PageLayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.FreeCRM.Base.TestBase;
import com.qa.FreeCRM.testUtil.Testutil;

public class ContactsPage extends TestBase {
	
	Testutil util;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
//  	
	
@FindBy(name="title")
WebElement title1;

@FindBy(id="first_name")
WebElement firstname;

@FindBy(id="surname")
WebElement Surname;

@FindBy(name="client_lookup")
WebElement company;

@FindBy(xpath="//input[@id='btn_cs_search']")
WebElement AdvancedSearch;

@FindBy(xpath="//input[@class='button'][@value='Save']")
WebElement Savebutton;


@FindBy(xpath="//a[contains(text(),'Kishore Kumar')]")
WebElement Contactname;




//Actions on Contact Page


public boolean VerifyconactSaved()
{
	return Contactname.isDisplayed();
}

public boolean VerifyAdvancedSearch()
{
	return AdvancedSearch.isDisplayed();
}
public String VerifyContactsPageTitle()
{
	return driver.getTitle();
}

public void createNewContact(String titletext,String Firstname,String surname,String Companyname)
{
	util = new Testutil();
	util.ExplicitlywaitbyName(title1,"title");
    util.SelectbyVisibleText(title1, titletext);
	util.ExplicitlywaitbyID(firstname, "first_name");
	firstname.sendKeys(Firstname);
	util.ExplicitlywaitbyID(Surname,"surname" );
	Surname.sendKeys(surname);
	util.ExplicitlywaitbyName(company, "client_lookup");
	company.sendKeys(Companyname);
	Savebutton.click();
}

}