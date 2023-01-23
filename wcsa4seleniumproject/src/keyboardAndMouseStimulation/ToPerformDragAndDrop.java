package keyboardAndMouseStimulation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToPerformDragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/#Photo%20Manage");

		WebElement frameElement = driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']"));
		driver.switchTo().frame(frameElement);
		WebElement image1 = driver.findElement(By.xpath("//img[@alt='The peaks of High Tatras']"));
		WebElement image2 = driver.findElement(By.xpath("//img[@alt='The chalet at the Green mountain lake']"));
		WebElement image3 = driver.findElement(By.xpath("//img[@alt='Planning the ascent']"));
		WebElement image4 = driver.findElement(By.xpath("//img[@alt='On top of Kozi kopka']"));
		WebElement trash = driver.findElement(By.id("trash"));

		Actions actions = new Actions(driver);
		actions.dragAndDrop(image1, trash).perform();
		int i = 2;
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h5[text()='High Tatras']")));
		actions.dragAndDrop(image2, trash).perform();
		explicitWait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h5[text()='High Tatras " + i++ + "']")));
		actions.dragAndDrop(image3, trash).perform();
		explicitWait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h5[text()='High Tatras " + i++ + "']")));
		actions.dragAndDrop(image4, trash).perform();
		explicitWait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h5[text()='High Tatras " + i++ + "']")));
		// actions.clickAndHold(image2).perform();
		// actions.moveByOffset(150, 250).perform();
		// Thread.sleep(2000);
		// actions.release().perform();
		i = 2;
		WebElement preLocation = driver.findElement(By.id("gallery"));
		actions.dragAndDrop(image1, preLocation).perform();
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='High Tatras']")));
		actions.dragAndDrop(image2, preLocation).perform();
		explicitWait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='High Tatras " + i++ + "']")));
		actions.dragAndDrop(image3, preLocation).perform();
		explicitWait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='High Tatras " + i++ + "']")));
		actions.dragAndDrop(image4, preLocation).perform();
		explicitWait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='High Tatras " + i++ + "']")));

		driver.switchTo().defaultContent();
		driver.findElement(By.id("Accepted Elements")).click();
		WebElement draggable = driver.findElement(By.xpath("//iframe[contains(@data-src,'accepted-elements.html')]"));
		driver.switchTo().frame(draggable);
		// WebElement elementToBeDragged =
		// explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.id("draggable")));
		// actions.dragAndDropBy(elementToBeDragged, 160, 4);
		WebElement source = driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
		WebElement destination = driver.findElement(By.id("droppable"));
		actions.dragAndDrop(source, destination).perform();
		String text = destination.getText();
         System.out.println(text);
         
         driver.switchTo().defaultContent();
         driver.findElement(By.id("Propagation")).click();
         WebElement frame3 = driver.findElement(By.xpath("//iframe[contains(@data-src,'propagation.html')]"));
         driver.switchTo().frame(frame3);
         WebElement source3 = driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
 		WebElement destination3 = driver.findElement(By.xpath("//p[text()='Inner droppable (not greedy)']"));
        actions.dragAndDrop(source3, destination3).perform();
        String text3 = destination3.getText();
        System.out.println(text3);
        
        WebElement destination4 = driver.findElement(By.xpath("//p[text()='Inner droppable (greedy)']"));
        actions.dragAndDrop(source3, destination4).perform();
        String text4 = destination4.getText();
        System.out.println(text4);
        
        driver.quit();
        
	}

}
