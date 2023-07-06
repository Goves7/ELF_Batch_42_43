package JavaPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToUnderstandfEandfEs {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebDriverWait explicitWait= new WebDriverWait(driver, Duration.ofSeconds(15));
		
		//driver.get("http://127.0.0.1/login.do;jsessionid=1hbl3yrbul1j9");
		//driver.findElement(By.xpath("//input[@class='textField']")).sendKeys("Abc");
  
		driver.get("https://www.flipkart.com/");
		List<WebElement> navBar = driver.findElements(By.xpath("//div[@class='eFQ30H']"));
		
		for(int i=0; i< navBar.size();i++) {
			String navBarOptions = navBar.get(i).getText();
			System.out.println(navBarOptions);
			Thread.sleep(1000);
		}
	}

	
}
