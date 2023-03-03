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
import org.testng.annotations.AfterMethod;

public class PrivacyPolicy
{
	// Crating object of Webdriver
	WebDriver driver;
	
  @Test
  public void privacyPolicy() throws InterruptedException, IOException 
  {
	// Access the property file 
	     FileInputStream fis = new FileInputStream("C:\\Users\\SAMARTH\\eclipse-workspace\\WebMath\\src\\test\\java\\com\\project\\WebMath\\data.properties");
		 Properties p = new Properties();
		 p.load(fis);
		 
		 // access the algebra page
		WebElement algebra = driver.findElement(By.xpath(p.getProperty("Algebra")));
		algebra.click();

		
		// click on privacy policy in Algebra page
		WebElement privacy_policy = driver.findElement(By.xpath("(//a[@title='Privacy Policy'])"));
		privacy_policy.click();
		
		// Wait for second
		driver.wait(300000);
		
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
