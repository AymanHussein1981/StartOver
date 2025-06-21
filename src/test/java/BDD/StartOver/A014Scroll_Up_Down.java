package BDD.StartOver;

import java.awt.Window;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A014Scroll_Up_Down {
	
	
	WebDriver driver;
	
	@Before
	public void init() {
		
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.dell.com/en-us");
	}
	
	
	@Test
	public void ScrollUpDown() throws InterruptedException{
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("scroll(0,5000)");
		
		Thread.sleep(3000);
		
		js.executeScript("scroll (0,0)");
		
		Thread.sleep(3000);
	}
	
	@After
	public void TearDown() {
		
		driver.close();
	}

}
