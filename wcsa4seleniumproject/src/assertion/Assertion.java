package assertion;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion {

	@Test
	public void assertionPractice() {
		String expectedLoginPageTitle = "actiTIME - Login";
		String expectedHomePageTitle = "actiTIME - Enter Time-Track";
		String usernameData = "admin";
		String passwordData = "manager";
		
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebDriverWait explicitWait= new WebDriverWait(driver, Duration.ofSeconds(15));
		SoftAssert softAssert= new SoftAssert();
		
		driver.get("https://demo.actitime.com/login.do");
		String actualLoginPageTitle = driver.getTitle();
		softAssert.assertEquals(actualLoginPageTitle, expectedLoginPageTitle, "Login Page Is Not Displayed");
		WebElement username = driver.findElement(By.id("username"));
		username.clear();
		username.sendKeys(usernameData);
		softAssert.assertEquals(username.getAttribute("value"), usernameData, "Username Is Not Displayed");
		WebElement password = driver.findElement(By.name("pwd"));
		password.clear();
		password.sendKeys(passwordData);
		softAssert.assertEquals(password.getAttribute("value"), passwordData, "Password IS Not displayed");
		driver.findElement(By.id("loginButton")).click();
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.id("logoutLink")));
		String actualHomePageTitle = driver.getTitle();
		softAssert.assertEquals(actualHomePageTitle, expectedHomePageTitle, "Home Page Is Not Displayed");
		
		softAssert.assertAll();
	}
}
