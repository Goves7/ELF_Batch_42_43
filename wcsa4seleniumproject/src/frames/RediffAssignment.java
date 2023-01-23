package frames;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RediffAssignment {

	public static void main(String[] args) throws InterruptedException {
		String userName="sumanthElfBatch@rediffmail.com";
		String password="Testing@123";
		String subject="Collin";
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//implicit timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		WebDriverWait explicitWait= new WebDriverWait(driver,Duration.ofSeconds(15));
		driver.get("https://www.rediff.com/");
		
		//signin to rediffmail
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("login1")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.name("proceed")).click();
		
		//Writing A Mail
		
		driver.findElement(By.xpath("//a[.='Write mail']")).click();
		driver.findElement(By.xpath("(//input[@placeholder='Enter name or email'])[1]")).sendKeys(userName);
		driver.findElement(By.xpath("//li[contains(@class,'fld_sub')]//input[@type='text']")).sendKeys(subject);
		
		//Go Inside Frame
		WebElement contentFrame = driver.findElement(By.xpath("//iframe[contains(@title,'Rich Text Editor, rdMailEditorcmp2')]"));
		driver.switchTo().frame(contentFrame);
		driver.findElement(By.xpath("//iframe[@title='Rich Text Editor, rdMailEditorcmp2']")).sendKeys("Hello Sir");
		
		//Come Back To Main Page
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[.='Send']")).click();
		
		//Handling The NoSuchElement Exception
		
	
	}

}
