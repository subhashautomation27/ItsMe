package com.bose;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CrmTest {
	
WebDriver driver;

@BeforeMethod
public void setUp()
{
	
	
	String browsername="chrome";
	
	if(browsername.equalsIgnoreCase("chrome"))
	{
		String key1="webdriver.chrome.driver";
		String value1="D:\\GitTest\\subhash_05_03\\Test123\\Drivers\\chromedriver.exe";
		System.setProperty(key1, value1);
		driver=new ChromeDriver();
    }else if(browsername.equalsIgnoreCase("FF"))
    {
    	String key1="webdriver.gecko.driver";
		String value1="D:\\GitTest\\subhash_05_03\\Test123\\Drivers\\geckodriver.exe";
		System.setProperty(key1, value1);
		driver=new FirefoxDriver();
    }
    else if(browsername.equalsIgnoreCase("IE"))
    {
    	String key1="webdriver.ie.driver";
		String value1="D:\\GitTest\\subhash_05_03\\Test123\\Drivers\\IEDriverServer.exe";
		System.setProperty(key1, value1);
		driver=new InternetExplorerDriver();
    }
	
	
	// browser settings 
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	
	//url passing 
	String url="https://classic.crmpro.com/index.html";
	driver.get(url);
	String urlname=driver.getCurrentUrl();
	System.out.println(urlname);
	
	String title=driver.getTitle();
	System.out.println(title);
}

@Test
public void logoTest()
{
	Boolean flag=driver.findElement(By.xpath("//img[contains(@src,'https://classic.crmpro.com/img/logo.png')] ")).isDisplayed();
	System.out.println(flag);
}

@AfterMethod
public void tearDown()
{
	driver.close();
}

}
