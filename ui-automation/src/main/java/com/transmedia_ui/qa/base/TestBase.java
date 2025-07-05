package com.transmedia_ui.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;



public class TestBase
{


	public static WebDriver driver;
	public static Properties prop;
	
	
	@BeforeMethod
	public void TestBase()
	//global variable initialize
	//read properties
	{
		
		try
		{
			prop=new Properties();
			FileInputStream ip =new FileInputStream
					("C:\\Users\\dilsh\\Documents\\GitHub\\Ifran-Saad-Omee-Automation\\ui-automation\\src\\main\\java\\com\\transmedia_ui\\qa\\config\\config.properties");
			

			prop.load(ip);
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	
		
	}
	@SuppressWarnings("deprecation")
	public static void initialization()
	{
		 String browserName=prop.getProperty("browser");
		 if(browserName.equals("chrome"))
		 {
			 WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			 
			 
			 
		 }else if (browserName.equals("firefox"))
		 {
			 WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
			
		 }
		 
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 
		 driver.get(prop.getProperty("url"));
		 
		 
		 
		 
	}
	
//	@AfterMethod
//    public void teardown() {
//        if (driver != null) {
//            driver.quit();
//        }
//        
//    }
}
