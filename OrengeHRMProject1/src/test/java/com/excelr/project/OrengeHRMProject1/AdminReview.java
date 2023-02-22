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
public class AdminReview 
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
	  
      // move to admin module 
	  WebElement admin = driver.findElement(By.xpath("(//a[@class=\"oxd-main-menu-item\"])[1]"));
	  admin.click();
	  
	  // Enter the user name
	  WebElement uname = driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));
	  uname.sendKeys("Admin");
	  
	  // select user role
	  WebElement urole = driver.findElement(By.xpath("(//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"])[1]"));
	  Select userrole =new Select(urole);
	  userrole.selectByVisibleText("Admin");
	  
	  // Enter employee name
	  WebElement ename = driver.findElement(By.xpath("(//input[@placeholder=\'Type for hints...\']"));
	  ename.sendKeys("Admin");
	  
	  // select status
	  WebElement status = driver.findElement(By.xpath("(//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"])[2]"));
	  Select estatus = new Select(status);
	  estatus.selectByVisibleText("Enabled");
	  
	  Thread.sleep(20000);
	  
	  //  click on search button
	  WebElement Search = driver.findElement(By.xpath("(//button[@type=\"submit\"])[1]"));
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

