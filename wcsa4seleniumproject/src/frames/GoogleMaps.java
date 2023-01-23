package frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleMaps {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
      System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
       WebDriver  driver  = new ChromeDriver();
       driver.get("https://www.google.co.in/");
       driver.manage().window().maximize();
       driver.findElement(By.xpath("//a[@aria-label='Google apps']")).click();
       Thread.sleep(2000);
       
       
       WebElement frameElement = driver.findElement(By.xpath("//iframe[@name='app']"));
       driver.switchTo().frame(frameElement);
       
       driver.findElement(By.xpath("//span[text()='Maps']")).click();
	}
	

}
