package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	By signin = By.xpath("//a[@href='https://rahulshettyacademy.com/sign_in/']");
	By title = By.xpath("//div[@class='text-center']/h2");
	By contact = By.xpath("//a[text()='Contact']");
	
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	} 

	public LoginPage getLogin() {
		driver.findElement(signin).click();
		LoginPage lp = new LoginPage(driver);
		return lp;
	} 
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement getContact() {
		return driver.findElement(contact);
	}

}
