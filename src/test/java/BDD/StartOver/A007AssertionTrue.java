package BDD.StartOver;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A007AssertionTrue {
	
	
WebDriver driver;
	

	
	
	
	@Before
	public void init() {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ayman\\eclipse-workspace\\PRACTISE\\StartOver\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://codefios.com/ebilling/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void LoginTest() throws InterruptedException {
	
		WebElement USER_NAME_FIELD=driver.findElement(By.xpath("//*[@id=\"user_name\"]"));
		WebElement PASSWORD_FIELD=driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement SIGN_IN_FIELD=driver.findElement(By.xpath("//*[@id=\"login_submit\"]"));
		
		USER_NAME_FIELD.clear();
		USER_NAME_FIELD.sendKeys("demo@codefios.com");
		PASSWORD_FIELD.sendKeys("abc123");
		SIGN_IN_FIELD.click();
		
		WebElement DASH_BOARD_HEADER_ELEMENT=driver.findElement(By.xpath("/html/body/div[1]/section/div/div[2]/div/div/header/div/strong"));
		
		Assert.assertTrue("HomePage did not available", DASH_BOARD_HEADER_ELEMENT.isDisplayed());
		Thread.sleep(3000);
	}
	
	
	@After
	public void TearDown() {
		driver.close();
	}


}
