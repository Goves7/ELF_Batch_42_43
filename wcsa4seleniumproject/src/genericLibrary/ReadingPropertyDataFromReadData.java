package genericLibrary;

public class ReadingPropertyDataFromReadData {

	public static void main(String[] args) {
		System.out.println(ReadData.fromPropertyFile("browserName"));
		System.out.println(ReadData.fromPropertyFile("url"));
		System.out.println(ReadData.fromPropertyFile("username"));
		System.out.println(ReadData.fromPropertyFile("password"));
		
		

	}

}
