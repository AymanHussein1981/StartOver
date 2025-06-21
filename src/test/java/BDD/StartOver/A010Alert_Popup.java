package BDD.StartOver;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A010Alert_Popup {
	
	WebDriver driver;
	
	By USER_NAME_FIELD=By.xpath("//*[@id=\"user_name\"]");
	By PASSWORD_FIELD=By.xpath("//*[@id=\"password\"]");
	By SIGNIN_FIELD=By.xpath("//*[@id=\"login_submit\"]");
	
	String UserName="demo@codefios.com";
	String Password="abc123";
	
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
		
		driver.findElement(SIGNIN_FIELD).click();
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
	}
	
	
	@Test
	public void LoginTest1() throws InterruptedException {
		
		driver.findElement(USER_NAME_FIELD).sendKeys(UserName);
		driver.findElement(PASSWORD_FIELD).click();
		driver.findElement(SIGNIN_FIELD).click(); 
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
	}
	
	
	
	@After
	public void TearDown() {
		
		driver.close();
	}

}
