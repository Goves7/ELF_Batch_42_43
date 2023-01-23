package JavaScriptInSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToHandleDisabledElements {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//Click on Disabled Button
		driver.get("https://www.oracle.com/in/java/technologies/javase/javase7-archive-downloads.html");
		driver.findElement(By.linkText("jdk-7u80-windows-i586.exe")).click();
       WebElement disabledButton = driver.findElement(By.xpath("//a[text()='Download jdk-7u80-windows-i586.exe']"));
       JavascriptExecutor js=(JavascriptExecutor) driver;
       js.executeScript("arguments[0].click();", disabledButton);
	}

}
