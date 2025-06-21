package BDD.StartOver;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class revision {
	
	WebDriver driver;
	
	By USER_NAME_FIELD=By.xpath("//*[@id=\"user_name\"]");
	By PASSWORD_FIELD=By.xpath("//*[@id=\"password\"]");
	By SIGNIN_FIELD=By.xpath("//*[@id=\"login_submit\"]");
	By CUSTOMER_FIELD=By.xpath("/html/body/div[1]/aside[1]/div/nav/ul[2]/li[2]/a/span");
	By ADD_CUSTOMER_FIELD=By.xpath("//*[@id=\"customers\"]/li[2]/a/span");
	By FULL_NAME_FIELD=By.xpath("//*[@id=\"general_compnay\"]/div[1]/div/input");
	By EMAIL_FIELD=By.xpath("//*[@id=\"general_compnay\"]/div[3]/div/input");
	By PHONE_NUMEBER_FIELD=By.xpath("//*[@id=\"phone\"]");
	By COMPANY_NAME_FIELD=By.xpath("//*[@id=\"general_compnay\"]/div[2]/div/select");
	By COUNTRY_NAME_FIELD=By.xpath("//*[@id=\"general_compnay\"]/div[8]/div[1]/select");
	By SAVE_BUTTON_FIELD=By.xpath("//*[@id=\"save_btn\"]");
	
	
	
	
	
	
	String userName="demo@codefios.com";
	String Password="abc123";
	String CompanyName="Techfios";
	String CountryName="Australia";
	
	@Before
	public void init() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ayman\\eclipse-workspace\\PRACTISE\\StartOver\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://codefios.com/ebilling/admin/dashboard");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void LoginTest() {
		

		driver.findElement(SIGNIN_FIELD).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void LoginTest1() {
		
		driver.findElement(USER_NAME_FIELD).sendKeys(userName);
		driver.findElement(SIGNIN_FIELD).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}
	
	
	@Test
	public void DropDown() throws InterruptedException {
		
		driver.findElement(USER_NAME_FIELD).sendKeys(userName);
		driver.findElement(PASSWORD_FIELD).sendKeys(Password);
		driver.findElement(SIGNIN_FIELD).click();
		
		System.out.println(driver.findElement(By.xpath("/html/body/div[1]/section/div/div[2]/div/div/header/div/strong")).getText());
		String homePageHeader=driver.findElement(By.xpath("/html/body/div[1]/section/div/div[2]/div/div/header/div/strong")).getText();
		Assert.assertEquals("page not found", "Dashboard", homePageHeader);
		
		driver.findElement(CUSTOMER_FIELD).click();
		driver.findElement(ADD_CUSTOMER_FIELD).click();
		
		
		System.out.println(driver.findElement(By.xpath("/html/body/div[1]/section/div/div[2]/div/div[1]/div[1]/div/div/header/div/strong")).getText());
		String customerPageHeader=driver.findElement(By.xpath("/html/body/div[1]/section/div/div[2]/div/div[1]/div[1]/div/div/header/div/strong")).getText();
		Assert.assertEquals("page not found", "New Customer", customerPageHeader);
		
		driver.findElement(FULL_NAME_FIELD).sendKeys("John S King");
		
		Select sel=new Select(driver.findElement(COMPANY_NAME_FIELD));
		sel.selectByVisibleText(CompanyName);
		
		driver.findElement(EMAIL_FIELD).sendKeys("A1B2C3DD44@gmail.com");
		driver.findElement(PHONE_NUMEBER_FIELD).sendKeys("4694691234");
		
		Select sel1=new Select(driver.findElement(COUNTRY_NAME_FIELD));
		sel1.selectByVisibleText(CountryName);
		
		driver.findElement(SAVE_BUTTON_FIELD).click();
		Thread.sleep(5000);
		
	}
		
		@Test
		public void iFrame() throws InterruptedException {
			
			
			driver.findElement(USER_NAME_FIELD).sendKeys(userName);
			driver.findElement(PASSWORD_FIELD).sendKeys(Password);
			driver.findElement(SIGNIN_FIELD).click();
			
			System.out.println(driver.findElement(By.xpath("/html/body/div[1]/section/div/div[2]/div/div/header/div/strong")).getText());
			String homePageHeader=driver.findElement(By.xpath("/html/body/div[1]/section/div/div[2]/div/div/header/div/strong")).getText();
			Assert.assertEquals("page not found", "Dashboard", homePageHeader);
			
			Thread.sleep(5000);
			driver.switchTo().frame("advertisement");
			driver.findElement(By.xpath("//*[@id=\"ad_three\"]/a/img")).click();
			driver.switchTo().frame("portals");
			driver.findElement(By.xpath("//*[@id=\"portal_one\"]/div/a/img")).click();
			
			
			driver.switchTo().defaultContent();
			
			
		}
		
		
		@After
		public void TearDown() {
			driver.close();
		}
		
	

}
