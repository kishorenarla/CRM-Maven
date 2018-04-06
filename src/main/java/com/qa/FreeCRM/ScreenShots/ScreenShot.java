package com.qa.FreeCRM.ScreenShots;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	
	public void TakeScreenshot(WebDriver driver,String Screenshotname) throws IOException
	{
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		try {
		FileUtils.copyFile(src, new File("./Screenshot/"+ Screenshotname +".png"));
		
		System.out.println("Screenshot Taken");
		
		}catch (Exception e)
		
		{
			System.out.println("Screenshot not Taken");
		}
		
	}

}
