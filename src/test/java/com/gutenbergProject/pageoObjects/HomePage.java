package com.gutenbergProject.pageoObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver ldriver;
	
	public HomePage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div/div[1]/div/h1")
	WebElement header;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div/div[2]/div[1]/div/div/a/button")
	WebElement fiction;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div/a/button")
	WebElement drama;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div/div[2]/div[3]/div/div/a/button")
	WebElement humor;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div/div[2]/div[4]/div/div/a/button")
	WebElement politics;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div/div[2]/div[8]/div[1]/div/div/a/button")
	WebElement phylosophy;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div/div[2]/div[8]/div[2]/div/div/a/button")
	WebElement history;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div/div[2]/div[8]/div[3]/div/div/a/button")
	WebElement adventure;
	
	public String getHeader()
	{
		String pageHeader= header.getText();
		return pageHeader;
	}
	
	public void clickFiction()
	{
		fiction.click();
	}
	
	public void clickDrama()
	{
		drama.click();
	}
	
	public void clickHumor()
	{
		humor.click();
	}
}
