package BDD.StartOver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class A009DropDown {
	
	WebDriver driver;
	
	String userName="demo@codefios.com";
	String Password="abc123";
	
	By USER_NAME_FIELD = By.xpath("//*[@id=\"user_name\"]");
	By PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]");
	By SIGN_IN_FIELD = By.xpath("//*[@id=\"login_submit\"]");
	By HEADER_TEXT_FIELD = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/header/div/strong");
	By CUSTOMER_FIELD= By.xpath("/html/body/div[1]/aside[1]/div/nav/ul[2]/li[2]/a/span");
	By ADD_CUSTOMER_FIELD= By.xpath("//*[@id=\"customers\"]/li[2]/a/span");
	By CUSTOMER_HEADER_FIELD=By.xpath("/html/body/div[1]/section/div/div[2]/div/div[1]/div[1]/div/div/header/div/strong");
	By COMPANY_DROP_DOWN_FIELD=By.xpath("//*[@id=\"general_compnay\"]/div[2]/div/select");
	
	
	@Before
	public void init() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ayman\\eclipse-workspace\\PRACTISE\\StartOver\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://codefios.com/ebilling/login");
	}
	
	
	@Test
	public void LoginTest() {
		
		driver.findElement(USER_NAME_FIELD).clear();
		driver.findElement(USER_NAME_FIELD).sendKeys(userName);
		driver.findElement(PASSWORD_FIELD).sendKeys(Password);
		driver.findElement(SIGN_IN_FIELD).click();
		
		
		String headerText=driver.findElement(HEADER_TEXT_FIELD).getText();
		Assert.assertEquals("page not found", "Dashboard", headerText);
		
	}
	
	
	@Test
	public void DropDown() {
		
		LoginTest();
		driver.findElement(CUSTOMER_FIELD).click();
		driver.findElement(ADD_CUSTOMER_FIELD).click();
		
		String customerHeader=driver.findElement(ADD_CUSTOMER_FIELD).getText();
		
		Assert.assertEquals("page not found", "Add Customer", customerHeader);
		
		Select sel=new Select(driver.findElement(COMPANY_DROP_DOWN_FIELD));
		sel.selectByVisibleText("Techfios");
		
		
	}
	
	
//	@After
//	public void TearDown() {
//		driver.close();
//	}

}
