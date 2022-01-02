package Project.Mockup;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class TitleValidation extends base{
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initizalizeDriver();
		driver.get(getPropValue("url"));
		log.info("Url Accessed");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[contains(text(),'NO THANKS')]")).click();
	}
	@Test
	public void baseNavigationPage1() throws IOException, InterruptedException {	
		LandingPage l = new LandingPage(driver);
		Assert.assertTrue(l.getContact().isDisplayed());
	}	
	
	@AfterMethod
	public void closeDriver() {
		log.info("Browser Closed");
		driver.close();
	}

}
