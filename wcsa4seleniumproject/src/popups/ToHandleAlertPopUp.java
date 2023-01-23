package popups;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToHandleAlertPopUp {

	public static void main(String[] args) {
	 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	 WebDriver driver= new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
	 WebDriverWait explicitWait= new WebDriverWait(driver,Duration.ofSeconds(15));
	 JavascriptExecutor js= (JavascriptExecutor) driver;
	 driver.get("https://licindia.in/");
	 try {
	 driver.findElement(By.xpath("//a[@title='Agents Portal']")).click();
	 }catch(ElementClickInterceptedException e) {
		 js.executeScript("window.scrollBy(0,250)");
		 driver.findElement(By.xpath("//a[@title='Agents Portal']")).click();
	 }
	 
	 Alert confirmationAlert = driver.switchTo().alert();
	 System.out.println(confirmationAlert.getText());
	 confirmationAlert.accept();
	
	 String parentWindowId = driver.getWindowHandle();
	 System.out.println(parentWindowId);
	 Set<String> allWindowIds = driver.getWindowHandles();
	 System.out.println(allWindowIds);
	
	 allWindowIds.remove(parentWindowId);
	 
	 for(String windowId : allWindowIds) {
		 driver.switchTo().window(windowId);
//     String url=driver.switchTo().window(windowId).getCurrentUrl();
//		System.out.println(url);
//		if(url.equalsIgnoreCase("https://ebiz.licindia.in/AgentPortal/?&_ga=2.152984241.983437703.1673188916-224605781.1673188916#Login")) {
//			driver.navigate().to("https://ebiz.licindia.in/AgentPortal/?&_ga=2.152984241.983437703.1673188916-224605781.1673188916#Login");
//		}
	}
	 driver.findElement(By.id("da_button-1110-btnInnerEl")).click();
	 
	 WebElement text1 = driver.findElement(By.xpath("//li[text()='Please enter your Agent Code or Email or Mobile']"));
	 System.out.println(text1.getText());
	 
	 WebElement text2 = driver.findElement(By.xpath("//li[text()='Please enter your Password']"));
	 System.out.println(text2.getText());
	}
}
