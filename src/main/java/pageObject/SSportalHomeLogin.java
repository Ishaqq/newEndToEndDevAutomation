package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SSportalHomeLogin {
	public WebDriver driver;
	By userName = By.xpath("//input[@formcontrolname='username']");
	By password = By.xpath("//input[@formcontrolname='password']");
	By loginButon=By.xpath("//button[@type='submit']");
	By passwordForgot=By.xpath("//a[@class='text-forgot']");
	By notAMember=By.xpath("//button[@class='btn btn-block btn-gr btn-md btn-dark']");
	By enterpriseLogin=By.xpath("//a[@class='font-weight-bold text-underline']");
	
	
	
	// List<WebElement> options =
	// driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
	//By autoSugestOptions = By.cssSelector("li[class='ui-menu-item'] a");

	public SSportalHomeLogin(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getUserName() {
		return driver.findElement(userName);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement getLoginButon() {
		return driver.findElement(loginButon);
	}
	
	public WebElement getNotAMember() {
		return driver.findElement(notAMember);
	}

//	public WebElement getautoSugestBox() {
//
//		return driver.findElement(autoSugestBox);
//
//	}
//
//	public List<WebElement> getautoSugestOptions() {
//
//		return driver.findElements(autoSugestOptions);
//
//	}
}
