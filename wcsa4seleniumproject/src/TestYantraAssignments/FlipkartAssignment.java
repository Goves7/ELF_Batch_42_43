package TestYantraAssignments;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FlipkartAssignment {
    
	public static WebDriver driver;
	public static WebDriverWait explicitWait;
	public static Map<Integer, String> productDetails=new TreeMap<>();
	public static JavascriptExecutor js;
	
	
	public static void main(String[] args) throws InterruptedException {
		//Step 1 & 2:Open Browser And Navigate To Flipkart.
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver= new ChromeDriver();
		js= (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		explicitWait= new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		
		
		//Search And Add 3 Different Products to Cart
		searchAndAddProduct("APPLE");
		searchAndAddProduct("REDMI");
		searchAndAddProduct("realme");
		
		
		//Step 5: Remove The Least Product
		driver.findElement(By.linkText("cart")).click();
		String lowestProduct="";
		List<WebElement> prices = driver.findElements(By.xpath("(//div[contains(@style,'box-shadow')]//span[contains(text(),'₹')])[position() mod 2=0]"));
		for(int i=1; i<= prices.size();i++) {
			int price=Integer.parseInt(prices.get(i-1).getText().replace("₹","").replace(",",""));
			productDetails.put(price, "Product" + i + "");
		}
		
		Set<Integer> costsOfProduct= productDetails.keySet();
		for(int lowestCost : costsOfProduct) {
			lowestProduct= productDetails.get(lowestCost);
			break;
		}
		char indexOfRemoveButton= lowestProduct.charAt(lowestProduct.length()-1);
		for(;;) {
			try {
				driver.findElement(By.xpath("(//div[text()='Remove'])[" + indexOfRemoveButton + "]")).click();
				break;
			}catch(ElementClickInterceptedException e) {
				js.executeScript("windows.scrollBy(0,250)");
				
			}
				
		}
		driver.findElement(By.xpath("//div[text()='Remove Item]/..//div[text()='Remove']")).click();
	}
	
	public static void searchAndAddProduct(String productName) throws InterruptedException {
		driver.findElement(By.name("q")).click();
		driver.findElement(By.name("q")).sendKeys(productName,Keys.ENTER);
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'"+ productName + "')]")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(@data-tkid,'SEARCH')]/a")).click();
		String parentWindowId=driver.getWindowHandle();
		Set<String> allWindowIds=driver.getWindowHandles();
		
		allWindowIds.remove(parentWindowId);
		
		for(String WindowId : allWindowIds) {
			driver.switchTo().window(WindowId);
		}
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add to cart']")));
		driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[.='Place order']")));
		driver.close();
		driver.switchTo().window(parentWindowId);
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
		driver.findElement(By.name("q")).sendKeys(Keys.CONTROL + "a");
		driver.findElement(By.name("q")).sendKeys(Keys.DELETE);
		
		
		
		
		
	}

}
