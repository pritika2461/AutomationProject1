package com.project.WebMath;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdvertizePage
{
	  WebDriver driver;
	  Properties p = new Properties();
	  
	  @Test
	  public void advertisementTest() throws IOException, InterruptedException {

	        boolean advertisement = driver.findElement(By.xpath(p.getProperty("advertisement"))).isDisplayed();
	        
	        Thread.sleep(3000);
	                      
	        if(advertisement==true) {
	        	
	        	 System.out.println("Advertisement image is Displayed");
	        }
	  
	        else {
	      	  
	      	  System.out.println("Advertisement image is not displayed");
	        }
	  	  
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
