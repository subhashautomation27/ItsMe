package com.hello;



import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ParallelTest  {
	
	WebDriver driver;
	
	@Test
	public void Paralleltest1() throws IOException
	{    
		String key="webdriver.chrome.driver" ;
		String value="D:\\GitTest\\subhash_05_03\\Test1\\Drivers\\chromedriver.exe";
		System.setProperty(key,value );
		driver= new ChromeDriver();
		
		 driver.get("https://www.facebook.com/");
		 
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		File f=new File("D:\\GitTest\\subhash_05_03\\Test1\\ExcelData\\subhash_test_Book1.xlsx");
	    FileInputStream fis=new FileInputStream(f);
	    XSSFWorkbook wb=new  XSSFWorkbook(fis);
	    XSSFSheet sh=wb.getSheetAt(2);
	     int ttlnum= sh.getLastRowNum();
	     System.out.println(ttlnum);
	     for (int i = 0; i <ttlnum; i++) {
	    	 String username=sh.getRow(i).getCell(0).getStringCellValue();
	    	 System.out.println("username" + username);
	    	 
        	 String password=sh.getRow(i).getCell(1).getStringCellValue();
	    	 System.out.println("password" + password);
	    	 
	    	
	    	  
	    	 
	    	 
	    	 driver.findElement(By.name("email")).sendKeys(username);
	    	 driver.findElement(By.name("pass")).sendKeys(password);
	    	 driver.findElement(By.id("u_0_2")).click();
	    	 driver.close();
		}
	    
}
	
	
	@Test
	public void parllelTest2() throws IOException
	{    
		
		
		String key="webdriver.chrome.driver" ;
		String value="D:\\GitTest\\subhash_05_03\\Test1\\Drivers\\chromedriver.exe";
		System.setProperty(key,value );
		driver= new ChromeDriver();
		
		 driver.get("https://www.facebook.com/");
		 
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		File f=new File("D:\\GitTest\\subhash_05_03\\Test1\\ExcelData\\subhash_test_Book1.xlsx");
	    FileInputStream fis=new FileInputStream(f);
	    XSSFWorkbook wb=new  XSSFWorkbook(fis);
	    XSSFSheet sh=wb.getSheetAt(2);
	     int ttlnum= sh.getLastRowNum();
	     System.out.println(ttlnum);
	     for (int i = 0; i <ttlnum; i++) {
	    	 String username=sh.getRow(i).getCell(0).getStringCellValue();
	    	 System.out.println("username" + username);
	    	 
        	 String password=sh.getRow(i).getCell(1).getStringCellValue();
	    	 System.out.println("password" + password);
	    	 
	    	 
	    	 driver.findElement(By.name("email")).sendKeys(username);
	    	 driver.findElement(By.name("pass")).sendKeys(password);
	    	 driver.findElement(By.id("u_0_2")).click();
	    	 driver.close();
		}
	    
}
	
	
	

}
