package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	By emailId = By.xpath("//input[@id='user_email']");
	By pwd = By.xpath("//input[@id='user_password']");
	By login = By.xpath("//input[@type='submit']");
	By forgotpwd = By.linkText("Forgot Password?");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getEmail() {
		return driver.findElement(emailId);
	} 
	
	public WebElement getPassword() {
		return driver.findElement(pwd);
	}
	
	public WebElement clickLogin() {
		return driver.findElement(login);
	}
	
	public RetrievePassword forgotPwd() {
		driver.findElement(forgotpwd).click();
		RetrievePassword rp = new RetrievePassword(driver);
		return rp;
		 
	}

}
