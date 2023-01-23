package popups;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToAvoidFileUploadPopUp {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebDriverWait explicitWait= new WebDriverWait(driver, Duration.ofSeconds(15));
		
		driver.get("https://www.freshersworld.com/user/register?src=homeheader");
        driver.findElement(By.id("file-upload")).sendKeys("D:\\Collin Resume.docx");
//	    Alert popUpAlert = driver.switchTo().alert();
//	    System.out.println(popUpAlert.getText());
//	    driver.switchTo().alert().accept();
	    
	    //driver.get("https://www.freshersworld.com/user/register?src=homeheader");
	    //driver.findElement(By.id("file-upload")).sendKeys("D:\\Collin Resume.docx");
	    
	    
	}

}
