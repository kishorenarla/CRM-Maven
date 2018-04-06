package com.qa.FreeCRM.PageLayers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.FreeCRM.Base.TestBase;

public class ScheduleCallPage extends TestBase {
	
	public ScheduleCallPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//input[@name='scheduled_call']")
	WebElement checkbox ;
	
	
	
	public boolean checkboxenabled() throws InterruptedException 
	{  
		Thread.sleep(5000);
		
	checkbox.isDisplayed();
		//checkbox.click();	
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		return checkbox.isSelected();
	}

}
