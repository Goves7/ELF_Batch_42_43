package JavaPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FireFlinkPractice {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Allen Solly");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.xpath("(//SPAN[@class='a-price-whole']/self::SPAN)[1]")).click();
		
	
	}

}
