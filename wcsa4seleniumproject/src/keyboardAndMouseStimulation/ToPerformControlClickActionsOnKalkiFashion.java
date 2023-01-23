package keyboardAndMouseStimulation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToPerformControlClickActionsOnKalkiFashion {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		WebDriverWait explicitWait= new WebDriverWait(driver, Duration.ofSeconds(15));
		
		driver.get("https://www.kalkifashion.com/");
		 
		Actions actions= new Actions(driver);
		List<WebElement> navBar = driver.findElements(By.id("desktop-nav"));
		for(WebElement menu : navBar) {
			System.out.println(menu);
		}
		

	}

}
