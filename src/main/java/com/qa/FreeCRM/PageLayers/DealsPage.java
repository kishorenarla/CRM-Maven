package com.qa.FreeCRM.PageLayers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.FreeCRM.Base.TestBase;
import com.qa.FreeCRM.testUtil.Testutil;

public class DealsPage extends TestBase{
	
	Testutil util;
	
	public DealsPage()
	{
		PageFactory.initElements(driver, this);
		 util = new Testutil();
	}

	//OR
	@FindBy(id="title")
	WebElement Title;
	
	@FindBy(xpath ="//input[@class='button'][@value='Lookup']")
	WebElement LookUpbutton;
	
	@FindBy(id ="search")
	WebElement Searchinnewindow;
	
	@FindBy(xpath="//input[@value='Search']")
	WebElement Searchbutton;
	
	//input[@value='Search']
	
	@FindBy(xpath ="//a[contains(text(),'Shire')]")
	WebElement Searchnamelink;
	
	
	


public void newDealformfill() throws InterruptedException
{
	util.ExplicitlywaitbyID(Title, "title");
	Title.sendKeys("training");
	util.ExplicitlywaitbyXpath(LookUpbutton, "//input[@class='button'][@value='Lookup']");
	LookUpbutton.click();
	Thread.sleep(5000);
	util.WindowHandler();
	Searchinnewindow.sendKeys("shire");
	Searchbutton.click();
	util.ExplicitlywaitbyXpath(Searchnamelink, "//a[contains(text(),'Shire')]");
	Searchnamelink.click();
	
	
	
}




}
