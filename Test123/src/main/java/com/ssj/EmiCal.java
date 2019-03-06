package com.ssj;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmiCal {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		String key="webdriver.chrome.driver";
		String value="D:\\GitTest\\subhash_05_03\\Test123\\Drivers\\chromedriver.exe";
		
		
		
		System.setProperty(key, value);
		
		driver= new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(130, TimeUnit.SECONDS);
		Dimension element=driver.manage().window().getSize();
		System.out.println(element);
		
		
		
	}
	
	@Test
	public void loginCrm()
	{
		
		String url="https://emicalculator.net/" ;
		driver.get(url);
       char tilte=		driver.getTitle().charAt(4);
  System.out.println(tilte);
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	

 }
