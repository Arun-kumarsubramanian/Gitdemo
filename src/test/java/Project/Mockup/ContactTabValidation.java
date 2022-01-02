package Project.Mockup;

import java.io.IOException;
import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class ContactTabValidation extends base{
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initizalizeDriver();
		driver.get(getPropValue("url"));
		log.info("Url Accessed");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[contains(text(),'NO THANKS')]")).click();	
		log.info("NO THANKS BUTTON FOUND");
	}
	
	@Test
	public void baseNavigationPage() throws IOException, InterruptedException {
		LandingPage l = new LandingPage(driver);
		log.fatal("check");
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		log.error("FEATURED COURSES NOT FOUND");
		Assert.assertTrue(l.getContact().isDisplayed());
		}	
	
	@AfterMethod
	public void closeDriver() {
		log.info("Browser Closed");
		driver.close();
	}

}
