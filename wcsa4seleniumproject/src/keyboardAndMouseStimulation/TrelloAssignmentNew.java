package keyboardAndMouseStimulation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrelloAssignmentNew {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebDriverWait explicitWait=new WebDriverWait(driver, Duration.ofSeconds(15));
	    driver.get("https://trello.com/home");
	    
	    driver.findElement(By.linkText("Log in")).click();
	    driver.findElement(By.id("user")).sendKeys("collingoves1996@gmail.com");
	    driver.findElement(By.id("login")).click();
	    explicitWait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
	    driver.findElement(By.id("password")).sendKeys("Favoured#7");
	    driver.findElement(By.xpath("//span[text()='Log in']")).click();
	    
	    driver.findElement(By.xpath("//div[@title='Mock_Data']")).click();
	    
	    Actions actions=new Actions(driver);
	    
	    WebElement mockCompletedTab = driver.findElement(By.xpath("//span[text()='Mock Completed']"));
	    WebElement mockScheduledTab = driver.findElement(By.xpath("//span[text()='Mock Scheduled']"));
	    driver.findElement(By.xpath(""));
	    
	    
	    

	}

}
