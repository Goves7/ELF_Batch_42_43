package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathUsingMultipleAttributes {

	
	public static void main(String[] args)  throws InterruptedException {
		// TODO Auto-generated method stub
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://in.puma.com/in/en");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		
		driver.findElement(By.xpath("//h3[@class='tw-8216tu' and(contains(text(),'Softride Pro Coast Training Shoes'))].cli")).click();
		Thread.sleep(2000);
		
	}

}
