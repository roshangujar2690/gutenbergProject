package com.gutenbergProject.testCases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.gutenbergProject.pageoObjects.HomePage;

public class TC_HomePageTest_001 extends BaseClass{
	
	@Test(priority=1)
	public void getPageTitle()
	{
		driver.get(baseUrl);
		logger.info("Url is opened");
		
		if (driver.getTitle().equals("React App"))
			{
				Assert.assertTrue(true);
				logger.info("getPageTitle test passed");
			}
			
			else
			{
				Assert.assertTrue(false);
				logger.info("getPageTitle test failed");
			}
	}
	
	@Test(priority=2)
	public void getpageHeader()
	{				
		HomePage hp= new HomePage(driver);
		if (hp.getHeader().equals("Gutenberg Project"))
			{
				Assert.assertTrue(true);
				logger.info("getpageHeader test passed");
			}
			
			else
			{
				Assert.assertTrue(false);
				logger.info("getpageHeader test failed");
			}
	}
	
	@Test(priority=3)
	public void verifyValidLinks() throws InterruptedException
	{
		HomePage hp1= new HomePage(driver);
		hp1.clickDrama();
		logger.info("Clicked on DRAMA button");
		String url = "";
        HttpURLConnection huc = null;
        int respCode = 200;        
        List<WebElement> links = driver.findElements(By.tagName("a"));        
        Iterator<WebElement> it = links.iterator();        
        while(it.hasNext())
        	{
            url = it.next().getAttribute("href");
        
            if(url == null || url.isEmpty())
            	{
            	logger.info("URL is either not configured for anchor tag or it is empty");
                continue;
            	}            
            try 
            	{
                huc = (HttpURLConnection)(new URL(url).openConnection());
                huc.setRequestMethod("HEAD");
                huc.connect();
                respCode = huc.getResponseCode();
                if(respCode >= 400)
                	{
                    logger.info(url+" is a broken link");
                    Assert.assertTrue(false);
                    logger.info("verifyValidLinks test is failed");
                	}
                else
                	{
                    logger.info(url+" is a valid link");
                	}
                Assert.assertTrue(true);
            	} 
            catch (MalformedURLException e) 
            	{
                e.printStackTrace();
            	} 
            catch (IOException e) 
            	{
                e.printStackTrace();
            	}
        }
	}
}
