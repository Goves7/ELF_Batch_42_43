package frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesConcepts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://www.dream11.com/");
	    
        
	    WebElement frameElement = driver.findElement(By.xpath("//iframe[@title='Iframe Example']"));
	    Thread.sleep(2000);
	    driver.switchTo().frame(frameElement);
	    driver.findElement(By.id("regEmail")).sendKeys("9876543210");
	    
	}

}
