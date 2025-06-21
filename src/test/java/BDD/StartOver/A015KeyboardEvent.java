package BDD.StartOver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class A015KeyboardEvent {
	
	
	WebDriver driver;

	By User_Name_Field=By.xpath("//*[@id=\"user_name\"]");
	By Password_Field=By.xpath("//*[@id=\"password\"]");
	
	
	String userName="demo@codefios.com";
	String Password="abc123";

	
	@Before
	public void init() {
		
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://codefios.com/ebilling/login");
	}
	
	
	@Test
	public void KeyboardEvent() {
		
		driver.findElement(User_Name_Field).sendKeys(userName);
		driver.findElement(Password_Field).sendKeys(Password);
		
		Actions action=new Actions (driver);
		action.sendKeys(Keys.ENTER).build().perform();
		
		Assert.assertEquals("page not found", "Dashboard", driver.findElement(By.xpath("/html/body/div[1]/section/div/div[2]/div/div/header/div/strong")).getText());
	}
	
	@After
	public void TearDown() {
		driver.close();
	}

}
