package keyboardAndMouseStimulation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToExploreKeyPressAndRelease {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebDriverWait explicitWait= new WebDriverWait(driver, Duration.ofSeconds(15));
		
		driver.get("https://yonobusiness.sbi/login/yonobusinesslogin");
		WebElement usernameTextField = driver.findElement(By.id("userName"));
		WebElement passwordTextField = driver.findElement(By.id("password"));
		
		Actions actions=new Actions(driver);
		actions.moveToElement(usernameTextField).click().sendKeys("Collin").build().perform();
		actions.keyDown(Keys.CONTROL).perform();
		actions.keyUp(Keys.CONTROL).perform();
		
		actions.moveToElement(passwordTextField).click().sendKeys("Favoured#7").perform();
		actions.keyDown(Keys.CONTROL).perform();
		actions.keyUp(Keys.CONTROL).perform();
		
	    WebElement showAndHideIcon = driver.findElement(By.xpath("//div[contains(@class,'shownhide')]"));
	    actions.clickAndHold(showAndHideIcon).perform();
	    Thread.sleep(3000);
	    actions.release().perform();
	    
	}

}
