package BDD.StartOver;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class A013MouseHoverOver______needAttention {
	
	WebDriver driver;
	
	@Before
	public void init() {
		
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.dell.com/en-us");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	
	
	@Test
	public void loginTest() {
			

	
		By COMPUTER_ACCESS_FIELD = By.xpath("//span[contains(text(), 'Computers & Accessories')]");
		By MONITORS_FIELD = By.xpath("//*[@id=\"unified-masthead-navigation\"]/nav/ul/li[3]/ul/li[5]/button");
		
		By VIEW_ALL_MONITORS_FIELD = By.xpath("//*[@id=\"hpg-hero-div\"]/div[1]/div/div[3]/div/div[2]/div");
		
		
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(COMPUTER_ACCESS_FIELD)).build().perform();
	
		action.moveToElement(driver.findElement(MONITORS_FIELD)).build().perform();
		driver.findElement(VIEW_ALL_MONITORS_FIELD).click();
	}
	

}
