package JavaScriptInSelenium;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToScrollToParticularCoordinate {

	public static void main(String[] args) {
	  System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	  WebDriver driver= new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	  
	  driver.get("https://www.naukri.com/");
	  
	  int scrollDistance=2105;
	  JavascriptExecutor js= (JavascriptExecutor) driver;
	  
	  js.executeScript("window.scrollTo(0,arguments[0])", scrollDistance);

	}

}
