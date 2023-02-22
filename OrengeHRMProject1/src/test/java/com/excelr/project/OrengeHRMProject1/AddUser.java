// Add user page
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
public class AddUser 
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
      
      
      // Click on login button
      WebElement Login = driver.findElement(By.xpath("//button[@type='submit']"));
      Login.click();
	  
      
      // Move to admin module
	  WebElement admin = driver.findElement(By.xpath("(//a[@class=\"oxd-main-menu-item\"])[1]"));
	  admin.click();
	  
	  
	  //click on add user button
	  WebElement adduser = driver.findElement(By.xpath("(//button[@type=\"button\"])[4]"));
	  adduser.click();
	  
	  Thread.sleep(3000);
	 
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

