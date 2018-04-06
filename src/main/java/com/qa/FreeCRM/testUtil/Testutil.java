package com.qa.FreeCRM.testUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.FreeCRM.Base.TestBase;

public class Testutil extends TestBase {
	
	
	public void swithchtoFrame()
	{
		driver.switchTo().frame("mainpanel");
	}

   public void SelectbyVisibleText(WebElement element,String text)
   {
	   Select select = new Select(element);
	   select.selectByVisibleText(text);
   }
   
   public static Object[][] getdata(String Sheetname) throws IOException
   {
   
	   File src = new File("C:\\Users\\HP 1040-G1\\Desktop\\Crmdata\\New Microsoft Office Excel Worksheet.xlsx");
	   FileInputStream fis = null;
	try {
		fis = new FileInputStream(src);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   XSSFWorkbook wb = new XSSFWorkbook(fis);
	   XSSFSheet sheet1= wb.getSheet(Sheetname);
	   Object[][] data = new Object[sheet1.getLastRowNum()][sheet1.getRow(0).getLastCellNum()];
	    for(int i=0;i<sheet1.getLastRowNum();i++)
	    {
	    	for(int j=0;j<sheet1.getRow(0).getLastCellNum();j++)
	    		
	    	{
	    		data[i][j]= sheet1.getRow(i+1).getCell(j).toString();
	    	}
	   
	   
   }
		return data;
}

   public void ExplicitlywaitbyName(WebElement element,String name)
   {
	   element = (new WebDriverWait(driver, 20))
				.until(ExpectedConditions.presenceOfElementLocated(By.name(name)));
   }
   
   public void ExplicitlywaitbyID(WebElement element,String ID)
   {
	   element = (new WebDriverWait(driver, 20))
				.until(ExpectedConditions.presenceOfElementLocated(By.id(ID)));
   }
   public void ExplicitlywaitbyXpath(WebElement element,String xpath)
   {
	   element = (new WebDriverWait(driver, 20))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
   }

   
   public void WindowHandler()
   {
	   Collection<String> windowhandles = driver.getWindowHandles();
	   Iterator<String> itr = windowhandles.iterator();
	   
	   while(itr.hasNext())
	   {
		   String Childwindow =itr.next();
		   
		   for (String childwindow:windowhandles)
		   {
			   driver.switchTo().window(childwindow);
		   }
	   }
   }
}
   
