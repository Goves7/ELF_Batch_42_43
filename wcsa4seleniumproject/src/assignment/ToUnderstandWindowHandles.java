package assignment;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToUnderstandWindowHandles {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
	    driver.get("https://licindia.in/");
	     String mainWindowId = driver.getWindowHandle();
	     System.out.println(mainWindowId);
	     
	     driver.findElement(By.id("login_Layer")).click();
	     String loginWindowId = driver.getWindowHandle();
	     System.out.println(loginWindowId);
	     
	    Set<String> allWindowIds = driver.getWindowHandles();
	    System.out.println(allWindowIds);
	}

}
