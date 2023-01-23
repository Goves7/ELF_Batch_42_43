package tohandledropdownusingselect;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ToHandleDropDownInFacebook {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.facebook.com/signup");
		WebElement dayDropDown = driver.findElement(By.id("day"));
		WebElement monthDropDown = driver.findElement(By.id("month"));
		WebElement yearDropDown = driver.findElement(By.id("year"));
		
	     Select daySelect=new Select(dayDropDown);
	     System.out.println("Day DropDown : "+daySelect.isMultiple());
	     List<WebElement> dayDropDownOptions = daySelect.getOptions();
	     for(WebElement ele: dayDropDownOptions) {
	    	 System.out.println(ele.getText()+", ");
	     }
	     System.out.println();
	     daySelect.selectByIndex(16);
	     System.out.println("==========================================================");
	     
	     Select monthSelect= new Select(monthDropDown);
	     List<WebElement> monthDropDownOptions = monthSelect.getOptions();
	     for(WebElement ele: monthDropDownOptions) {
	    	 System.out.println(ele.getText()+", "); 
	     }
	     monthSelect.selectByValue("6");
	     System.out.println("=======================================================");
           
	     Select yearSelect=new Select(yearDropDown);
	     List<WebElement> yearDropDownOptions = yearSelect.getOptions();
	     for(WebElement ele: yearDropDownOptions) {
	    	 yearSelect.selectByVisibleText(ele.getText());
	    	 Thread.sleep(500);
	     }
	     yearSelect.selectByVisibleText("1996");
	}

}
