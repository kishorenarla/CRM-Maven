package com.qa.FreeCRM.PageLayers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.FreeCRM.testUtil.Testutil;

public class DateSelector {
	
	Testutil util;

	public void DateSelection() throws InterruptedException
	{  
		WebDriver driver;
	
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
