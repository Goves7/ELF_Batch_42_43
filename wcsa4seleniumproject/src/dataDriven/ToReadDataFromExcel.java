package dataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ToReadDataFromExcel {

	public static void main(String[] args) throws IOException {
		//Step 1: Creating Input Stream Type Object
	//	File absPath= new File("./testData/testData.xlsx");
   //     FileInputStream fis =new FileInputStream(absPath);
		
		 FileInputStream fis =new FileInputStream("./testData/testData.xlsx");
        
        //Step 2: Creating Object Of File Type
     //  Workbook workbook= new XSSFWorkbook(fis);
      Workbook book = WorkbookFactory.create(fis);
       //Step 3: Read Methods
    //   double value = workbook.getSheet("Number").getRow(11).getCell(7).getNumericCellValue();
       double num = book.getSheet("Number").getRow(11).getCell(7).getNumericCellValue();
       boolean bool = book.getSheet("boolean").getRow(4).getCell(12).getBooleanCellValue();
      String str = book.getSheet("String").getRow(18).getCell(4).getStringCellValue();
       LocalDateTime date = book.getSheet("Date").getRow(7).getCell(3).getLocalDateTimeCellValue().now(); // Returns Date and current Time Both.
    //   Date date = book.getSheet("Date").getRow(18).getCell(12).getDateCellValue(); // returns only date but not time..
      System.out.println(num);
      System.out.println(bool);
      System.out.println(str);
      System.out.println(date);
       
	}

}
