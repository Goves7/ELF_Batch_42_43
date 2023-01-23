package keyboardAndMouseStimulation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrelloAsssignment {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebDriverWait explicitWait= new WebDriverWait(driver, Duration.ofSeconds(15));
		
		driver.get("https://trello.com/home");
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("user")).sendKeys("collingoves1996@gmail.com");
		driver.findElement(By.id("login")).click();
		//driver.findElement(By.linkText("Continue as Collin")).click();
		
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.name("password")));
	    driver.findElement(By.name("password")).sendKeys("Favoured#7");
	    
	    driver.findElement(By.id("login-submit")).click();
	    driver.findElement(By.xpath("//div[@title='ELF 42-43']")).click();
	    
	     WebElement mockCompletedCard = driver.findElement(By.xpath("//span[text()='Mock Completed']"));
	     
	     Actions actions= new Actions(driver);
	     actions.contextClick(mockCompletedCard).perform();
	     List<WebElement> contextMenu = driver.findElements(By.xpath("//a[contains(@class,'quick-card-editor')]"));
	     
	     for(WebElement menu: contextMenu) {
	    	 System.out.println(menu.getText());
	    	 
	     }
	     driver.quit();
	}

}
