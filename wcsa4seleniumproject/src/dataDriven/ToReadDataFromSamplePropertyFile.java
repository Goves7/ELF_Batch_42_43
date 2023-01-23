package dataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToReadDataFromSamplePropertyFile {

	public static void main(String[] args) throws IOException {
		
		//Step1: Creating Object Of Input Stream
		File absPath= new File("./testData/SampleScriptData.properties");
		FileInputStream fis= new FileInputStream(absPath);
 
		//Step 2: Creating Object of File Type
		Properties properties= new Properties();
		properties.load(fis);
		
		//Step 3: Read Methods
		String key = properties.get("ChromeBrowserKey").toString();
		String value = properties.get("ChromeDriverPath").toString();
		String url = properties.getProperty("url");
		String url1 = properties.get("url").toString();
		System.out.println(key+" "+value+" "+url);
		
		System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();
		driver.get(url);
	}
}
