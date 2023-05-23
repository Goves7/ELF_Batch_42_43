package workingWithTestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SearchBusesForThreeDifferentFromAndToLocations {

	@Test
	public void searchBusesForThreeDifferentFromAndToLocations() throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://in.via.com/");
		BasePage basePage= new BasePage(driver);
		
		basePage.getbusNavBarIcon().click();
		BusHomePage busHomePage= new BusHomePage(driver);
		
		busHomePage.getFromTextField().sendKeys("Bangalore");
		busHomePage.getBangaloreSearchSuggestion().click();
		busHomePage.getToTextField().sendKeys("Goa");
		busHomePage.getGoaSearchSuggestion().click();
		busHomePage.getDepartureField().click();
		driver.findElement(By.xpath("//span[.='Jan 2023']/../..//div[text()='27']")).click();
		busHomePage.getSearchBusesButton().click();
		
		Thread.sleep(3000);
		driver.navigate().back();
		busHomePage.getFromTextField().clear();
		busHomePage.getFromTextField().sendKeys("Chennai");
		busHomePage.getChennaiSearchSuggestion().click();
		busHomePage.getToTextField().clear();
		busHomePage.getToTextField().sendKeys("Hyderabad");
		busHomePage.getHyderabadSearchSuggestion().click();
		busHomePage.getDepartureField().click();
		driver.findElement(By.xpath("(//span[.='Feb 2023']/../..//div[.='7'])[1]")).click();
		busHomePage.getSearchBusesButton().click();
		
		Thread.sleep(3000);
		driver.navigate().back();
		busHomePage.getFromTextField().clear();
		busHomePage.getFromTextField().sendKeys("Pune");
		busHomePage.getPuneSearchSuggestion().click();
		busHomePage.getToTextField().clear();
		busHomePage.getToTextField().sendKeys("Kolhapur");
		busHomePage.getKolhapurSearchSuggestion().click();
		busHomePage.getDepartureField().click();
		driver.findElement(By.xpath("(//span[.='Feb 2023']/../..//div[.='10'])[1]")).click();
		busHomePage.getSearchBusesButton().click();
		Thread.sleep(3000);
		driver.navigate().back();
		
		driver.quit();
		
	}
}
