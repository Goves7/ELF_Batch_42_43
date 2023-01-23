package tohandledropdownusingselect;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ToHandleMultiSelectDropDown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("file:///C:/Users/Admin/Downloads/Microsoft.SkypeApp_kzf8qxf38zg5c!App/All/dropDown.html");
		WebElement multiSelectDropDown = driver.findElement(By.id("m1"));
		Select multiSelect= new Select(multiSelectDropDown);
		System.out.println("Is The DropDown Multi Select : "+multiSelectDropDown);
		List<WebElement> allOptions = multiSelect.getOptions();
		for(WebElement ele: allOptions) {
			System.out.println(ele.getText());
		}
		multiSelect.selectByIndex(1);
		multiSelect.selectByValue("4");
		
		System.out.println("Selected Options");
		List<WebElement> selectedOptions = multiSelect.getAllSelectedOptions();
		for(WebElement ele : selectedOptions) {
			System.out.println(ele.getText());
		}
		Thread.sleep(2000);
		//multiSelect.deselectByVisibleText("Mango");
		//multiSelect.deselectByIndex(3);
		multiSelect.deselectAll();
		
		multiSelect.selectByVisibleText("Grapes");
		multiSelect.selectByValue("1");
		
		WebElement firstSelectedOption = multiSelect.getFirstSelectedOption();
		System.out.println(firstSelectedOption.getText());
	
	

	}

}
