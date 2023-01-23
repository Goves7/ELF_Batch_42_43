package popups;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToHandleAuthenticationPopUp {

	public static void main(String[] args) throws AWTException {
	  System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	  WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	  WebDriverWait explicitWait= new WebDriverWait(driver, Duration.ofSeconds(15));
	  
	  driver.get("https://the-internet.herokuapp.com/basic_auth");
	  
	  Robot robot= new Robot();
	  robot.keyPress(KeyEvent.VK_A);
	  robot.keyPress(KeyEvent.VK_D);
	  robot.keyPress(KeyEvent.VK_M);
	  robot.keyPress(KeyEvent.VK_I);
	  robot.keyPress(KeyEvent.VK_N);
	  
	  robot.keyRelease(KeyEvent.VK_A);
	  robot.keyRelease(KeyEvent.VK_D);
	  robot.keyRelease(KeyEvent.VK_M);
	  robot.keyRelease(KeyEvent.VK_I);
	  robot.keyRelease(KeyEvent.VK_N);
	  
	  robot.keyPress(KeyEvent.VK_TAB);
	  robot.keyRelease(KeyEvent.VK_TAB);
	  
	  robot.keyPress(KeyEvent.VK_A);
	  robot.keyPress(KeyEvent.VK_D);
	  robot.keyPress(KeyEvent.VK_M);
	  robot.keyPress(KeyEvent.VK_I);
	  robot.keyPress(KeyEvent.VK_N);
	  
	  robot.keyRelease(KeyEvent.VK_A);
	  robot.keyRelease(KeyEvent.VK_D);
	  robot.keyRelease(KeyEvent.VK_M);
	  robot.keyRelease(KeyEvent.VK_I);
	  robot.keyRelease(KeyEvent.VK_N);
	  
	  robot.keyPress(KeyEvent.VK_TAB);
	  robot.keyRelease(KeyEvent.VK_TAB);
	  
	  robot.keyPress(KeyEvent.VK_ENTER);
	  robot.keyRelease(KeyEvent.VK_ENTER);
	  
	}

	
}
