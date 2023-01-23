package TestYantraAssignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakeMyTripAssignment {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebDriverWait explicitWait= new WebDriverWait(driver, Duration.ofSeconds(15));
		Actions actions = new Actions(driver);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		
		driver.get("https://www.makemytrip.com/");
		actions.click().perform();
		driver.findElement(By.id("fromCity")).sendKeys("Bengaluru",Keys.ENTER);
		driver.findElement(By.xpath("(//input[@value='Bengaluru'])[1]")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Delhi", Keys.ENTER);

	}

}
