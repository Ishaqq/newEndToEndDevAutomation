package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;
	By email = By.cssSelector("input[type='email']");
	By password = By.cssSelector("input[type='password']");
	By submit = By.cssSelector("input[type='submit']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getemail() {
		return driver.findElement(email);

	}

	public WebElement getpassword() {
		return driver.findElement(password);

	}

	public WebElement getsubmit() {
		return driver.findElement(submit);

	}
}
