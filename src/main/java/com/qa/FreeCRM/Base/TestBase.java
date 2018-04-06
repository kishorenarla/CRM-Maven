package com.qa.FreeCRM.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	
	public static  WebDriver driver;
	public static Properties prop;
	
	public TestBase() // create constructor for TestBase
	{
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("C:\\EclipseOxygenWorkspace\\com.qa.FreeCRMPOM\\src\\main\\java\\com\\qa\\FreeCRM\\Config\\config.properties");
			prop.load(fis);
		}
		catch (FileNotFoundException e)
		{
			
		} catch (IOException e) {
	
			e.printStackTrace();
		}
		
	}
	
	public static void initialization()
	{
		String browsername =prop.getProperty("browser");
			
		if(browsername.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\EclipseOxygenWorkspace\\chromedriver.exe");
			 driver = new ChromeDriver();		
		}
	     driver.manage().deleteAllCookies();
	     driver.manage().window().maximize();
		 driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		 driver.get(prop.getProperty("url"));
	    
	}
	
	
}
