package keyboardAndMouseStimulation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToMoveTheMouseCursorOnAnElement {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.drievr", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.kalkifashion.com/");
		driver.findElement(By.xpath("//button[text()='No thanks']")).click();
		WebElement kidsNavBarElement = driver.findElement(By.linkText("KIDS"));
		
        Actions actions= new Actions(driver);
        actions.moveToElement(kidsNavBarElement).perform();
	}

}
