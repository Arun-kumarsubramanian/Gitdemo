package stepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.junit.Cucumber;
import org.junit.Assert;
import org.junit.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.ExtentReportNG;
import resources.base;

@RunWith(Cucumber.class)
public class StepDefinition extends base implements ITestListener{
	ExtentTest test;
	ExtentReports extent = ExtentReportNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	@Given("^Initialize chrome browser$")
    public void initialize_chrome_browser() throws Throwable {
		driver = initizalizeDriver();
    }

    @When("^user inputs (.+) and (.+) and clicks on login$")
    public void user_inputs_and_and_clicks_on_login(String username, String password) throws Throwable {
    	LandingPage l = new LandingPage(driver);
		LoginPage lp = l.getLogin();
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		//log.info("NO THANKS BUTTON FOUND");
		lp.clickLogin().click();

    }

    @Then("^login page throws error$")
    public void login_page_throws_error() throws Throwable {
    	
    }

    @And("^Navigate to browser and bypass the step$")
    public void navigate_to_browser_and_bypass_the_step() throws Throwable {
		//log.info("Url Accessed");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[contains(text(),'NO THANKS')]")).click();
    }

    @And("^close the browser$")
    public void close_the_browser() throws Throwable {
    	driver.close();
    }
	public void onTestStart(ITestResult result) {	
		
		test= extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}
    
    public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
		WebDriver driver = null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String testMethodName = result.getMethod().getMethodName();
		System.out.println(testMethodName);
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenshotPath(testMethodName, driver), testMethodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

