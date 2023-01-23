package MethodsOfWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseMethod {

	public static void main(String[] args)throws InterruptedException {
		// TODO Auto-generated method stub
		
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        
	        Thread.sleep(4000);
	        driver.close();
	        
//			driver.get("https://demo.actitime.com/login.do");
//			driver.findElement(By.id("username")).sendKeys("admin");
//			String demo = driver.findElement(By.id("username")).getAttribute("value");
//			System.out.println(demo);

	}

}
