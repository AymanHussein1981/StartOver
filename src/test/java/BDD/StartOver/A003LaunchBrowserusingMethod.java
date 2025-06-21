package BDD.StartOver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A003LaunchBrowserusingMethod {

	
	static WebDriver driver;
	
	public static void main(String[] args)throws InterruptedException  {
		
		setup();
		LoginTest();
		TearDown();	

		setup();
		NegativeLoginTest();
		TearDown();	
	}
	
	
	public static void setup() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ayman\\eclipse-workspace\\PRACTISE\\StartOver\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://codefios.com/ebilling/login");
	}
	
	
	public static void TearDown() {
		
		driver.close();
	}
	
	
	public static void LoginTest() {
		
		driver.findElement(By.xpath("//*[@id=\"user_name\"]")).sendKeys("demo@codefios.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("abc123");
		driver.findElement(By.xpath("//*[@id=\"login_submit\"]")).click();
	}
	
	
	public static void NegativeLoginTest() {
		
		driver.findElement(By.xpath("//*[@id=\"user_name\"]")).sendKeys("demo@codefios.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("abc1234");
		driver.findElement(By.xpath("//*[@id=\"login_submit\"]")).click();
	}

}
