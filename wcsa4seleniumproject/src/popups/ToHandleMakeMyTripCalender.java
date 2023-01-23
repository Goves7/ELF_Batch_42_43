package popups;

import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToHandleMakeMyTripCalender {

	public static void main(String[] args) {
		LocalDateTime systemsDateTime= LocalDateTime.now().plusMonths(7);
		String monthName = systemsDateTime.getMonth().name();
		int year = systemsDateTime.getYear();
		int day = systemsDateTime.getDayOfMonth();
		String month="" + monthName.charAt(0)+ monthName.substring(1,monthName.length()).toLowerCase();
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		WebDriverWait explicitWait= new WebDriverWait(driver, Duration.ofSeconds(15));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		Actions actions= new Actions(driver);
		
		driver.get("https://www.makemytrip.com/");
		actions.click().perform();
		driver.findElement(By.xpath("//label[@for='departure']")).click();
		
		for(;;) {
			try {
				driver.findElement(By.xpath("//div[text()='" + month+ " "+year+ "']/../..//p[text()='" + day + "']")).click();
				break;
			}catch(NoSuchElementException e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
				
			}
		}
	}

}
