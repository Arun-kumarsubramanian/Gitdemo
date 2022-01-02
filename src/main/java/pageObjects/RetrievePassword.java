package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RetrievePassword {
	public WebDriver driver;
	
	By emailId = By.xpath("//input[@id='user_email']");
	By submit = By.xpath("//input[@type='submit']");
	
	public RetrievePassword(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getEmail1() {
		 return driver.findElement(emailId);
	 
	} 
	public WebElement sendMeInstructions() {
		 return driver.findElement(submit);
	 
	} 

}
