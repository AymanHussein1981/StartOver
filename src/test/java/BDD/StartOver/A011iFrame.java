package BDD.StartOver;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A011iFrame {
	
	
WebDriver driver;
	
	
	
	@Before
	public void init() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ayman\\eclipse-workspace\\PRACTISE\\StartOver\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://docs.oracle.com/javase/8/docs/api/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	
	@Test
	public void iFrame() {
		
		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.xpath("/html/body/div[2]/ul/li[5]/a")).click();
		driver.switchTo().parentFrame();
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.xpath("/html/body/div/ul[1]/li[2]/a/span")).click();
		driver.switchTo().parentFrame();
		driver.switchTo().frame("classFrame");
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/ul/li/pre/a")).click();
	}

}
