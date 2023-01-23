package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActiTimeCreateNewCustomer {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://127.0.0.1/login.do;jsessionid=1hbl3yrbul1j9");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.findElement(By.name("username")).sendKeys("admin");
		Thread.sleep(2000);
		driver.findElement(By.name("pwd")).sendKeys("manager");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[class='initial']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("a[href='/tasks/otasklist.do']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[href='/project/customers_projects.do']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("input[value='Create New Customer']")).click();

	

	}

}
