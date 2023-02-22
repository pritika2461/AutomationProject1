package com.excelr.project.OrengeHRMProject1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class ResetPassword {
	
	WebDriver driver ;
	
  @Test
  public void Reset_Password() {
	  //  click on forget password
	  WebElement ForgotPassword = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']"));
	  ForgotPassword.click();
	  
	  // enter username
	  WebElement Username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
	  Username.sendKeys("pritika2461");
	  
	  // click on reset button
	  WebElement reset = driver.findElement(By.xpath("//button[@type='submit']"));
	  reset.click();
	  
	  //verify
	  boolean verify = driver.findElement(By.xpath("//div[@class='orangehrm-card-container']")).isDisplayed();
	  if(verify==true) {
		  System.out.println("Reset Password link sent successfully");
	  }
	  else {
		  System.out.println("Reset Password link id not sent");
	  }
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
  public void afterMethod()
  {
	  driver.close();
  }

}

