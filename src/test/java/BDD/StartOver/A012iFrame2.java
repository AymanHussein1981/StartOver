package BDD.StartOver;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A012iFrame2 {
	
	WebDriver driver;
	
		By User_Name_Field=By.xpath("//*[@id=\"user_name\"]");
		By Password_Field=By.xpath("//*[@id=\"password\"]");
		By Signin_Field=By.xpath("//*[@id=\"login_submit\"]");
		
		
		
		@Before
		public void init() {
			
			System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("https://codefios.com/ebilling/login");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}

		@Test
		public void loginTest() {
				

			driver.findElement(User_Name_Field).sendKeys("demo@codefios.com");
			driver.findElement(Password_Field).sendKeys("abc123");
			driver.findElement(Signin_Field).click();
			
			
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//driver.switchTo().alert().accept();
			driver.switchTo().frame("advertisement");
			driver.findElement(By.xpath("//*[@id=\"ad_three\"]/a/img")).click();
			driver.switchTo().frame("portals");
			driver.findElement(By.xpath("//*[@id=\"portal_one\"]/div/a/img")).click();
			
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("/html/body/div[1]/aside[1]/div/nav/ul[2]/li[5]/a/span")).click();
		 

			
}
		
//		@After
//		public void TearDown() {
//			driver.close();
//		}
}