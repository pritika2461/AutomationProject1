package com.project.WebMath;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class PracticeMathInOtherStuff
{
	// Crating object of Webdriver
	WebDriver driver;
	
  @Test
  public void practiceMath() throws InterruptedException, IOException 
  {
	  
	    FileInputStream fis = new FileInputStream("C:\\Users\\SAMARTH\\eclipse-workspace\\WebMath\\src\\test\\java\\com\\project\\WebMath\\data.properties");
	    Properties p = new Properties();
	    p.load(fis);
	  
		WebElement OtherStuff = driver.findElement(By.xpath(" //a[@title='Other Fun Math Stuff']"));
		OtherStuff.click();
		
		WebElement PracticeMath = driver.findElement(By.xpath("//a[@href=\"wsheet.html\"]"));
		PracticeMath.click();
		
		WebElement dropdown = driver.findElement(By.xpath("//select[@name=\"ptype\"]"));
		
		Select s1 = new Select(dropdown);
		s1.selectByVisibleText("Addition problems");
		
        WebElement dropdown1 = driver.findElement(By.xpath("//select[@name=\"ntype\"]"));
		
		Select s2 = new Select(dropdown1);
		s2.selectByVisibleText("decimal");
		
		WebElement large_number = driver.findElement(By.xpath("//input[@name=\"maxnum\"]"));
		large_number.sendKeys(p.getProperty("LargeNumber"));
		
        WebElement dropdown2 = driver.findElement(By.xpath("//select[@name=\"ntype\"]"));
		
		Select s3 = new Select(dropdown2);
		s3.selectByVisibleText("decimal");
		
		WebElement smaller_number = driver.findElement(By.xpath("//input[@name=\"maxnum\"]"));
		smaller_number.sendKeys(p.getProperty("SmaallNumber"));
		
		driver.wait(30000);
		
		
  }
  
  @BeforeMethod
  public void launchURL() throws IOException
  {
	  // setup the chromedriver
	    WebDriverManager.chromedriver().setup();
		 
		 driver = new ChromeDriver();
		 
		// Get the webpage
		    FileInputStream fis = new FileInputStream("C:\\Users\\SAMARTH\\eclipse-workspace\\WebMath\\src\\test\\java\\com\\project\\WebMath\\data.properties");
		    Properties p = new Properties();
		    p.load(fis);
		    driver.get(p.getProperty("URL"));
		 
		 // Maximize the window
		 driver.manage().window().maximize();
		 
		 // Wait
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		 
	  
  }

  @AfterMethod
  public void closeConnection() 
  {
	  // Close the connection
	  driver.close();
  }

}
