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
import org.testng.annotations.AfterMethod;

public class HomePage 
{
	// Crating object of Webdriver
	WebDriver driver;
	
  @Test
  public void homePage() throws FileNotFoundException, IOException 
  {	
	     // creating object of FileInputStream
	     FileInputStream fis = new FileInputStream("C:\\Users\\SAMARTH\\eclipse-workspace\\WebMath\\src\\test\\java\\com\\project\\WebMath\\data.properties");
		 Properties p = new Properties();
		 p.load(fis);
		 
		// find the home page by xpath & click on it
		WebElement home = driver.findElement(By.xpath(p.getProperty("HomePage")));
		home.click();
	
		// get the current URL
		String url = driver.getCurrentUrl();
		
		// check home page is display or not
		if(url.equals(url))
		{
			System.out.println("Home page is display...");
		}
		else
		{
			System.out.println("Incorrect URL....");
		}
		
  }
  
  @BeforeMethod
  public void launchURL() throws IOException
  {
	  // setup the chrome driver
	    WebDriverManager.chromedriver().setup();
		 
		 driver = new ChromeDriver();
		 
		 FileInputStream fis = new FileInputStream("C:\\Users\\SAMARTH\\eclipse-workspace\\WebMath\\src\\test\\java\\com\\project\\WebMath\\data.properties");
		 Properties p = new Properties();
		 p.load(fis);
		 
		 // Get the webpage
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
