package com.ssj;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
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
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("windows-size=1400,500");
		opt.addArguments("Headless");
		
		driver= new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.MINUTES);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
		Dimension element=driver.manage().window().getSize();
		System.out.println(element);// size(1050, 718)
	}
	
	@Test
	public void loginCrm() throws Exception
	{
		// launching browser
		String url="https://emicalculator.net/" ;
		driver.get(url);
		
		// displaying char of title
        char tilte=driver.getTitle().charAt(4);
        System.out.println(tilte);
        
        //Display title of the page
        String title1=driver.getTitle();
        System.out.println(title1);
        
        // action class performance
        Actions action=new Actions(driver);
        
        // first drag (from left to right)[here axis changing but y axis is fixed]
       WebElement homeloanamt= driver.findElement(By.cssSelector("#loanamountslider > span "));
       action.dragAndDropBy(homeloanamt, 83, 0).build().perform();
       Thread.sleep(2000);
       
       // first drag (from left to right)[here axis changing but y axis is fixed]
       WebElement InterestRate= driver.findElement(By.cssSelector("#loaninterestslider>span "));
       action.dragAndDropBy(InterestRate, 116, 0).build().perform();
       Thread.sleep(2000);
       
    // first drag (from right to left)[here axis changing but y axis is fixed]
       WebElement LoanTenure= driver.findElement(By.cssSelector("#loantermslider>span"));
       action.dragAndDropBy(LoanTenure, -113, 0).build().perform();// here from right to left ,for that use -(minus)
       Thread.sleep(2000);    
       
       // get value
       WebElement value=driver.findElement(By.cssSelector(" #emiamount>p > span"));
       String txtvalue=value.getText();
       System.out.println(txtvalue);
       Thread.sleep(3000);
       System.out.println("++++++++++++++++++++++=");
       Assert.assertEquals("1,09,782" , txtvalue);
       
       
   
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	

 }
