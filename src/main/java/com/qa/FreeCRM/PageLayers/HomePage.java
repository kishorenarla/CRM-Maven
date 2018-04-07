package com.qa.FreeCRM.PageLayers;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.FreeCRM.Base.TestBase;
import com.qa.FreeCRM.testUtil.Testutil;



public class HomePage  extends TestBase
{
	
Testutil util;
	
public HomePage()
{
	
	PageFactory.initElements(driver, this);
	
	
}
@FindBy(xpath="//select[@name='slctMonth']") // HomePage calendar month
WebElement SelectMonth;

@FindBy(xpath="//select[@name='slctYear']") // HomePage calendar year
WebElement SelectYear;

@FindBy(xpath="//a[@title='Contacts']")
WebElement Contactslink;


@FindBy(xpath="//a[contains(text(),'Deals')]")
WebElement DealsLink;

@FindBy(xpath="//td[@class='headertext'][contains(text(),'Kishore Narla')]")
WebElement LoggeduserVerify;

@FindBy(xpath ="//a[contains(text(),'New Contact')]")
WebElement NewContact;

@FindBy(xpath ="//a[contains(text(),'New Deal')]")
WebElement NewDeallink;

//Schedule Call

@FindBy(xpath="//div[@id='leftMenuContainer']//child::div[@id='navMenu']//child::li[10]/a")
WebElement Schedulecalllink;

//Actions in HomePage

public ContactsPage ClickContactLinkWhenAlreadyinContactpage()// already in frame
{
	WebElement Contactslink = (new WebDriverWait(driver, 10))
			.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Contacts']")));
	Contactslink.click();
	return new ContactsPage();
	 
}

public boolean LoggeruserVerify()
{
	return  LoggeduserVerify.isDisplayed();

}

public ContactsPage clickOnContactsLink()
{ 
	util= new Testutil();
	util.swithchtoFrame();
	WebElement Contactslink = (new WebDriverWait(driver, 10))
			.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Contacts']")));
	Contactslink.click();
	return new ContactsPage();
	
}

public String ValidateHomePagePagetitle()
{
return driver.getTitle();
}

public void clickonNewContact() throws InterruptedException
{   
	
	
	Actions action = new Actions(driver);
	action.moveToElement(Contactslink).build().perform();
    util.ExplicitlywaitbyXpath(NewContact, "//a[contains(text(),'New Contact')]");
	NewContact.click();
}

public DealsPage clickOnDealslink()
{
	util.swithchtoFrame();
	DealsLink.click();
	return new DealsPage();
}

public void clickOnNewDeal()
{   util = new Testutil();
	util.swithchtoFrame();
	Actions action = new Actions(driver);
	action.moveToElement(DealsLink).build().perform();
	util.ExplicitlywaitbyXpath(NewDeallink, "//a[contains(text(),'New Deal')]");
	NewDeallink.click();
			
}

public ScheduleCallPage clickonScheduleLink() throws InterruptedException
{
driver.switchTo().frame("mainpanel");
	Schedulecalllink.click();
	return new ScheduleCallPage();
}

public void DateSelection() throws InterruptedException
{  
	util= new Testutil();
	util.swithchtoFrame();
	WebElement calender = driver.findElement(By.xpath("//div[@id='crmcalendar']"));
	Thread.sleep(5000);
	util.SelectbyVisibleText(SelectMonth, "June");
	Thread.sleep(5000);
	util.SelectbyVisibleText(SelectYear, "2018");
		Thread.sleep(6000);		
	List<WebElement> columns=driver.findElements(By.xpath("//td[@class='calendarcell']"));

	for (WebElement cell: columns){
	  
	   if (cell.getText().equals("10")){
	      cell.click();
	      break;
	 }
	}
	
	
}

}
