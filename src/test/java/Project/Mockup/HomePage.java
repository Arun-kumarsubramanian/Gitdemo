package Project.Mockup;

import java.io.IOException;

import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeMethod
	public void initialize() throws IOException {
		driver = initizalizeDriver();
		driver.get(getPropValue("url"));
		log.info("Url Accessed");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[contains(text(),'NO THANKS')]")).click();
	}
	
	@Test(dataProvider="getData")
	public void baseNavigationPage2(String username, String Password) throws IOException, InterruptedException {	
		LandingPage l = new LandingPage(driver);
		LoginPage lp = l.getLogin();
	lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(Password);
		log.info("NO THANKS BUTTON FOUND");
		lp.clickLogin().click();

	}
		@DataProvider	
		public Object[][] getData() throws InterruptedException {
			Object[][] data = new Object[2][2];
			
			data[0][0] = "cogn.arun@gmail.com";
			data[0][1] = "asdsdasd";
			//data[0][2] = "user1";
			data[1][0] = "abcd.arun@gmail.com";
			data[1][1] = "dfsfdfsdf";
			//data[1][2] = "user2";
			
			return data;
			
		}
		@AfterMethod
		public void closeDriver() {
			log.info("Browser Closed");
			driver.close();
		}

	

}
