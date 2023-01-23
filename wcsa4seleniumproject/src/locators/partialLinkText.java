package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class partialLinkText {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://127.0.0.1/login.do;jsessionid=1hbl3yrbul1j9");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.findElement(By.partialLinkText("License")).click();
		Thread.sleep(6000);
		driver.quit();
		

	}

}
