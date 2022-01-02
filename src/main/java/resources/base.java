package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	public WebDriver driver;
	public Properties prop;
public WebDriver initizalizeDriver() throws IOException {
	
	String browserName= getPropValue1("browser");
	System.out.println(browserName);
	ChromeOptions options = new ChromeOptions();
	
	if (browserName.contains("chrome")) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
		if (browserName.contains("headless"))
			options.addArguments("headless");		
		driver = new ChromeDriver();
		driver.get(getPropValue("url"));
	}
	if (browserName.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
}

public static String getPropValue(String key) throws IOException {
	
Properties prop = new Properties();
FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
prop.load(fis);
return prop.getProperty(key);
}

public static String getPropValue1(String key) throws IOException {
	
Properties prop = new Properties();
FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
prop.load(fis);
//String value1 = prop.getProperty(key);
String value1 = System.getProperty(key);
//System.out.println(value1);
return value1;

}

public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException {
	TakesScreenshot ts =(TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"\\screenshots\\"+testCaseName+".png";
	FileUtils.copyFile(source,new File(destinationFile));	
	return destinationFile;

}

}
