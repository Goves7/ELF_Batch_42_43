package workingWithTestNG;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ToUnderstandDataProviderUsingExcel {

	@DataProvider
	public String [][] registerUserData () throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(new File ("./testData/testData.xlsx"));
		Workbook workbook = WorkbookFactory.create(fis);
	    
		Sheet urlInfo = workbook.getSheet("Url");
		int rowCount = urlInfo.getPhysicalNumberOfRows()-1;
		int colCount = urlInfo.getRow(0).getPhysicalNumberOfCells();
		
		String data [][] = new String [rowCount][colCount];
		
		for(int i=1,k=0; i<=rowCount; i++, k++) {
			for(int j=0; j< colCount; j++) {
				data [k][j]= urlInfo.getRow(i).getCell(j).toString();
			}
		}
		
	  return data;
	}
	
	
	
	@Test(dataProvider= "registerUserData")
	public void test(String data) {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(data);
	}
}
