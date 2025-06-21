package BDD.StartOver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class A016WindowHandel______needAttention {
	
	
WebDriver driver;
	
	By SEARCH_BAR_FIELD=By.xpath("//*[@id=\"APjFqb\"]");
	By SEARCH_BUTTON_FIELD=By.xpath("//*[@id=\"recaptcha-anchor\"]");
	By SELENIUM_DEV_LINK_FIELD=By.xpath("//*[@id=\"rso\"]/div[2]/div[6]/div/div/div/div/div/div/div[1]/div/span/a/h3");
									
	

	
	@Before
	public void init() {
		
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

	@Test
	public void TestWindoHandle() throws InterruptedException {
			
		driver.findElement(SEARCH_BAR_FIELD).sendKeys("selenium");
		
		
		Actions action=new Actions (driver);
		action.sendKeys(Keys.ENTER).build().perform();
		
		driver.findElement(SEARCH_BUTTON_FIELD).click();
		
	}	
}
