package genericLibrary;

public class ReadingExcelDataFromReadData {

	public static void main(String[] args) {
     System.out.println(ReadData.fromExcel("Number",11 ,7 ));
     System.out.println(ReadData.fromExcel("Boolean",4 ,12 ));
     System.out.println(ReadData.fromExcel("String",18 ,4 ));
     System.out.println(ReadData.fromExcel("Date",18 ,12 ));

	}

}
