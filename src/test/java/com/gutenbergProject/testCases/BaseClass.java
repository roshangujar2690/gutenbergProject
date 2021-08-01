package com.gutenbergProject.testCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.gutenbergProject.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig config= new ReadConfig();
	public String baseUrl=config.getUrl();
	public static WebDriver driver;
	public static Logger logger; 
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		if (br.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", config.getChromePath());
			driver= new ChromeDriver();
		}
		
		else if(br.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", config.getfirefoxPath());
			driver= new FirefoxDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		logger= Logger.getLogger("gutnberg");
		PropertyConfigurator.configure("Log4j.properties");
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
