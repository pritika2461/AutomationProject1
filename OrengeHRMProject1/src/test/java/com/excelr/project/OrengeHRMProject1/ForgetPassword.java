package com.excelr.project.OrengeHRMProject1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class ForgetPassword 
{
	WebDriver driver ;
	
  @Test
  public void Forgot_Password() {
	  //Entering invalid Username password 
	  WebElement Username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
      Username.sendKeys("pritikasomase");
      
      WebElement Password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
      Password.sendKeys("admin987");
      
      // click on enter
      WebElement Login = driver.findElement(By.xpath("//button[@type='submit']"));
      Login.click();
      
      //Verify invalid credential 
      WebElement error = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"));
      String Expected_Error = "Invalid credentials" ;
      
      String Actual_Error = error.getText();
      Assert.assertEquals(Expected_Error, Actual_Error);
      
      
	  
  }
  
  @BeforeMethod
  public void beforeMethod() 
  {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  
  }

}

