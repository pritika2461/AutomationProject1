package com.project.WebMath;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class ChooseMathHelpItem
{
	// Crating object of Webdriver
	WebDriver driver;
	
  @Test
  public void mathItem() throws FileNotFoundException, IOException 
  {
		 // access the algebra page
	  // Access the property file 
	     FileInputStream fis = new FileInputStream("C:\\Users\\SAMARTH\\eclipse-workspace\\WebMath\\src\\test\\java\\com\\project\\WebMath\\data.properties");
		 Properties p = new Properties();
		 p.load(fis);
		 
		 // access the algebra page
		WebElement algebra = driver.findElement(By.xpath(p.getProperty("Algebra")));
		algebra.click();
		
		
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='topicItem']"));
		
		Select coins = new Select(dropdown);
		coins.selectByIndex(4);
		
		WebElement coin = driver.findElement(By.xpath("//input[@name='q']"));
		coin.sendKeys("5");
		
		WebElement coin1 = driver.findElement(By.xpath("//input[@name='d']"));
		coin1.sendKeys("6");
		
		WebElement coin2 = driver.findElement(By.xpath("//input[@name='n']"));
		coin2.sendKeys("5");
		
		WebElement coin3 = driver.findElement(By.xpath("//input[@name='p']"));
		coin3.sendKeys("5");
		
		WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
		submit.click();

		WebElement imageLink = driver.findElements(By.tagName("a")).get(2);
		imageLink.click();
		
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
