package cars;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC_Cars_020 {
	@Parameters("url")
	@Test(groups = "Integration")
	public void cars(@Optional("chrome") String bname) {
//		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
//		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		WebDriver driver=null;
		if(bname.equalsIgnoreCase("firefox")) {
			driver= new FirefoxDriver();
		}else if(bname.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
		}else {
			Reporter.log("Please pass a valid browser Name", true);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.bmw.in/en/index.html");
		driver.quit();
	}	
}
