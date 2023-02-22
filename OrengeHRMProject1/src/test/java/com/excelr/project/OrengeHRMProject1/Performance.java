package com.excelr.project.OrengeHRMProject1;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
public class Performance
{
	
	WebDriver driver ;
	
  @Test
  public void Employ_Review() throws InterruptedException {
	  
	  //Entering Username 
	  WebElement Username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
      Username.sendKeys("Admin");
      
      
      // Enter Password
      WebElement Password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
      Password.sendKeys("admin123");
      
      // click on login button
      WebElement Login = driver.findElement(By.xpath("//button[@type='submit']"));
      Login.click();
	  
      // move to performance module 
	  WebElement perfomnce = driver.findElement(By.xpath("(//span[@class=\"oxd-text oxd-text--span oxd-main-menu-item--name\"])[7]"));
	  perfomnce.click();
	 
	  Thread.sleep(20000);
	 
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
  }

  @AfterMethod
  public void afterMethod() 
  {
	  driver.close();
  }

}

