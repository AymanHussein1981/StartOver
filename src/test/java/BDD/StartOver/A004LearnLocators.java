package BDD.StartOver;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;

public class A004LearnLocators {
	
	WebDriver driver;
	
	@Before
	public void init() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ayman\\eclipse-workspace\\PRACTISE\\StartOver\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://objectspy.space/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void locators() throws InterruptedException {
		
		driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("Ayman");
		driver.findElement(By.cssSelector("input#sex-1")).click();
		driver.findElement(By.cssSelector("a[href$='http://objectspy.com/os_api_prod/']")).click();
		driver.navigate().back();
		driver.findElement(By.cssSelector("a[href$='http://techfios.com/api-prod/api_site/']")).click();
		driver.navigate().back();
		driver.findElement(By.cssSelector("input#exp-3")).click();
		driver.findElement(By.cssSelector("input#tool-1")).click();
		driver.findElement(By.cssSelector("input#photo")).sendKeys("C:\\TECHFIOS\\Selenium\\Documents\\PPT\\Session 1.pptx");
		Thread.sleep(2000);	
	}

	
	@After
	public void TearDown() {
		driver.close();
	}
}
