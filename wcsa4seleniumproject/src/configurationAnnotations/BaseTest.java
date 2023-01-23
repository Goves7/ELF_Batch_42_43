package configurationAnnotations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import genericLibrary.ReadData;

public class BaseTest {

	public WebDriver driver;
	// Expected Data
	String expectedLoginPageTitle = "actiTIME - Login";
	String expecdtedHomePageTitle = "actiTIME - Enter Time-Track";
	String usernameData = "admin";
	String passwordData = "manager";
	String url = ReadData.fromPropertyFile("url");

	@Parameters("browserName")
	@BeforeClass()
	public void browserSetUp(@Optional("chrome") String bname) throws InvalidBrowserValueException {
		// Step 1: Open the Browser and enter the Test Url
		if (bname.equalsIgnoreCase("chrome")) {
			 driver = new ChromeDriver();
		} else if (bname.equalsIgnoreCase("firefox")) {
			 driver = new FirefoxDriver();
		} else {
			throw new InvalidBrowserValueException();
		}

		Reporter.log("Empty Chrome Browser is Launched", true);
		driver.manage().window().maximize();
		Reporter.log("Browser Window is Maximized", true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
		String actualLoginPageTitle = driver.getTitle();

		if (expectedLoginPageTitle.equals(actualLoginPageTitle)) {
			System.out.println("Login Page Is Displayed");
		} else {
			System.err.println("Login Page Is Not Displayed");
		}
	}

	@BeforeMethod()
	public void loginToApplication() {
		// Step 2: Enter Valid Credentials Into Username TextField And Password TextField
	
		WebElement usernameTextField = driver.findElement(By.id("username"));
		usernameTextField.clear();
		//usernameTextField.sendKeys(usernameData);
		usernameTextField.sendKeys(ReadData.fromPropertyFile("username"));
		String actualUsernameEntered = usernameTextField.getAttribute("value");
		if (usernameData.equals(actualUsernameEntered)) {
			Reporter.log("Successfully entered username into username TextField");
		} else {
			Reporter.log("Username is not entered Successfully");
		}
		
		WebElement passwordTextField = driver.findElement(By.name("pwd"));
		passwordTextField.clear();
		passwordTextField.sendKeys(ReadData.fromPropertyFile("password"));
		//passwordTextField.sendKeys(passwordData);
		String actualPasswordEntered = passwordTextField.getAttribute("value");
		if (passwordData.equals(actualPasswordEntered)) {
			Reporter.log("Successfully Entered Password In Password TextField", true);
		} else {
			Reporter.log("Password Is Not Entered Successfully", true);
		}

		// Step 3: Click On Login Page
		driver.findElement(By.id("loginButton")).click();
		String actualHomePageTitle = driver.getTitle();
		if (expecdtedHomePageTitle.equals(actualHomePageTitle)) {
			Reporter.log("Home Page Is Displayed", true);
			Reporter.log("Successfully Logged In to The Application", true);
		} else {
			Reporter.log("Home Page Is Not Displayed", true);
		}
	}

	@AfterMethod()
	public void logOutOfApp() {
		driver.findElement(By.id("logoutLink")).click();
		String actualLoginPageTitle = driver.getTitle();
		if (expectedLoginPageTitle.equals(actualLoginPageTitle)) {
			Reporter.log("Login Page Is Displayed", true);
			Reporter.log("Successfully Logged out Of The Application", true);
		} else {
			Reporter.log("Login Page Is Not Displayed");
		}
	}

	@AfterClass()
	public void browserTearDown() {
		driver.quit();
		Reporter.log("Closed The Browser Session", true);
	}
	
}

@SuppressWarnings("serial")
class InvalidBrowserValueException extends Exception {
	public InvalidBrowserValueException() {
		super("The Browser Name Passed Is Invalid");
	}
}
