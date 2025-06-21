package BDD.StartOver;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A005ByType {

	WebDriver driver;
	
	By USER_NAME_FIELD=By.xpath("//*[@id=\"user_name\"]");
	By PASSWORD_FIELD=By.xpath("//*[@id=\"password\"]");
	By SIGN_IN_FIELD=By.xpath("//*[@id=\"login_submit\"]");
	
	
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
	public void LoginTest() {
		
		driver.findElement(USER_NAME_FIELD).sendKeys("demo@codefios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(SIGN_IN_FIELD).click();
		
	
	}
}
