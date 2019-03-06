package com.subhash;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CrmPro {
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		String key="webdriver.chrome.driver";
		String value="D:\\GitTest\\subhash_05_03\\Test123\\Drivers\\chromedriver.exe";
		String url="https://classic.crmpro.com/index.html";
		System.setProperty(key, value);
		driver=new ChromeDriver();
		
		// browser settings 
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//url passing 
		
		driver.get(url);
		String urlname=driver.getCurrentUrl();
		System.out.println(urlname);
		
		String title=driver.getTitle();
		System.out.println(title);
		
		
	}
	
	@Test
	public void test() 
	{
	  WebElement usename= driver.findElement(By.xpath("//input[contains(@name,'user')]"));
	  usename.sendKeys("subhashautomation");
	      
	  
	  WebElement password=driver.findElement(By.xpath("//input[contains(@name,'pass')]"));
	  password.sendKeys("subhash081927");
	  
	  WebElement btnclk=driver.findElement(By.xpath("//input[contains(@type,'submit')]"));
	  btnclk.click();
	  
	  
	 char afterlogintitlechar = driver.getTitle().charAt(4);
	 System.out.println(afterlogintitlechar);
	}

	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
