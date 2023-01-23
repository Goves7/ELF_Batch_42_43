package popups;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToHandleNotificationPopUpUsingChromeOptions {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		ChromeOptions options= new ChromeOptions();
        options.addArguments("--incognito");
        
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebDriverWait explicitWait= new WebDriverWait(driver, Duration.ofSeconds(15));
        
        driver.get("https://www.easemytrip.com/");
        
        
	}
	

}
