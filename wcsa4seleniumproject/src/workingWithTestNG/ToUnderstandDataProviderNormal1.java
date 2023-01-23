package workingWithTestNG;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ToUnderstandDataProviderNormal1 {

	@DataProvider()
	public String[] getUrl() {
		String[] sarr = { "https://licindia.in/", "https://www.royalenfield.com/", "https://www.bmw.in/en/index.html/",
				"https://www.icicibank.com/", "https://www.hdfcbank.com/" };
		return sarr;

	}
	
	@Test(dataProvider = "getUrl")
	public void launchApplication(String url) {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
		
	}
}
