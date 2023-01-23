package parameters;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TC_ToUnderstandPassingParameters_010 {
	@Parameters("url")
	@Test
	public void demo(@Optional("https://licindia.in/Home-(1)/Customer-Portal") String urlName) {
		System.out.println(urlName);
	    System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	    WebDriver driver= new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	    
	    driver.get(urlName);
	}
}
