package assertion;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionFacebook {
    @Test
	public void emailSignInErrorMessageVerificationAndValidation() {
		WebDriver driver=new ChromeDriver();
		Reporter.log("Empty Chrome Browser Is Launched",true);
		driver.manage().window().maximize();
		Reporter.log("Browser Window is Maximized", true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebDriverWait explicitWait= new WebDriverWait(driver, Duration.ofSeconds(15));
		SoftAssert sa = new SoftAssert();
		
		driver.get("https://www.facebook.com/login/");
		sa.assertEquals(driver.getTitle(), "Log in to Facebook", "Login Page Is Not Displayed");
		
		driver.findElement(By.id("loginbutton")).click();
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='email_container']/div[2]")));
		Reporter.log("Successfully Clicked On Login Button");
		sa.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/login/device-based/regular/login/?login_attempt=1&lwv=100", "Login Page Is Not Displayed");
		
		WebElement emailTextField = driver.findElement(By.id("email"));
		sa.assertEquals(emailTextField.getCssValue("border"), "1px solid rgb(240, 40, 73)", "Border Colour of Email TextField Is not Correct");
	    WebElement errorMessage = driver.findElement(By.xpath("//div[@id='email_container']/div[2]"));
		sa.assertEquals(errorMessage.getText(),"The email address or mobile number you entered isn't connected to an account. Find your account and log in." , "The Error Message is Not Correct");
		
		sa.assertAll();
	}
	
	
}
