package JavaPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StringConcepts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		String mnk="collin";
//		mnk.replace('l', 'm');
//		System.out.println(mnk);
//		//System.out.println(m);
		int year=2022;
		String month="December";
	String Month=(String) month.subSequence(0, 3);
		String  day="Saturday";
		int Day=31;
		StringBuilder bui = new StringBuilder("mustakim");
		bui.append("koujalagi");
		System.out.println(bui);
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();   //OOAD
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//div[@data-cy='landingContainer']")).click();
		
		//driver.findElement(By.xpath("//span[normalize-space(text())='DEPARTURE']"));
	//	driver.findElement(By.xpath("[text()='"+month+" "+year+"']/../..//p[text()='"+day+"']"));
		//input[@value='Saturday, 31 Dec 2022']
		driver.findElement(By.xpath("//input[@value='"+day+", "+Day+" "+Month+" "+year+"']")).click();
		
		
				
	}

}
