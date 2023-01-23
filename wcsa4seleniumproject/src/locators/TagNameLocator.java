package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TagNameLocator {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.findElement(By.tagName("input")).sendKeys("Admin");
		//driver.findElement(By.tagName("input")).sendKeys("admin123");
	    Thread.sleep(2000);
	    
	   driver.close();
	}

}

// With the help  we of tagName we cannot identify or locate 2nd, 3rd or nth no.of WebElement.