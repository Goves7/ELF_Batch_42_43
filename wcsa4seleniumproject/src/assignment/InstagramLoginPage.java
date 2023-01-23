package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InstagramLoginPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
     
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.Instagram.com/");
		Thread.sleep(2000);
		
		driver.findElement(By.name("username")).sendKeys("govescollin");
		driver.findElement(By.name("password")).sendKeys("Favoured#7");
		driver.findElement(By.cssSelector("button[class='_acan _acap _acas']")).click();
		Thread.sleep(6000);
		driver.close();
		
	}

}
