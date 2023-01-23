package popups;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToAvoidFileUploadPopUpInNaukri {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebDriverWait explicitWait= new WebDriverWait(driver, Duration.ofSeconds(15));
		
		driver.get("https://www.naukri.com/");
		driver.findElement(By.id("register_Layer")).click();
//		driver.findElement(By.id("resumeUpload")).sendKeys("C:\\Users\\Admin\\Pictures\\Screenshots\\Screenshot (2).png");
//     	Alert popUpAlert = driver.switchTo().alert();
//		System.out.println(popUpAlert.getText());
//		driver.switchTo().alert().accept();
		
		driver.findElement(By.id("resumeUpload")).sendKeys("D:\\Collin Resume.docx");
		

	}

}
