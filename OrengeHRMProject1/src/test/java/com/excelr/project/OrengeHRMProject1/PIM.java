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
public class PIM{
	
	WebDriver driver ;
	
  @Test
  public void Employ_Review() throws InterruptedException {
	  
	  //Entering Username & password
	  WebElement Username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
      Username.sendKeys("Admin");
      
      WebElement Password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
      Password.sendKeys("admin123");
      
      WebElement Login = driver.findElement(By.xpath("//button[@type='submit']"));
      Login.click();
	  
	  WebElement pim = driver.findElement(By.xpath("(//span[@class=\"oxd-text oxd-text--span oxd-main-menu-item--name\"])[2]"));
	  pim.click();
	  
	  
	  WebElement ename = driver.findElement(By.xpath("(//input[@placeholder=\"Type for hints...\"])[1]"));
	  ename.sendKeys("Admin");
	  
	  
	  WebElement eid = driver.findElement(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]"));
	  eid.sendKeys("Admin");
	  
	  WebElement empstatus = driver.findElement(By.xpath("(//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"])[1]"));
	  Select estatus = new Select(empstatus);
	  estatus.selectByVisibleText("freelance");
	  
	  Thread.sleep(20000);
	  
	  WebElement Search = driver.findElement(By.xpath("(//button[@type='submit'])"));
	  Search.click();
	  
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


