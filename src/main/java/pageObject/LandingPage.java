package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LandingPage {
	public WebDriver driver;

	By signin = By.xpath("//span[text()='Login']");
	By title = By.xpath("//h2[text()='Featured Courses']");
	By NavBar=By.cssSelector(".nav.navbar-nav.navbar-right li");

	@FindBy(className = "Location")

	WebElement locationList;

	public Select selectLocation() {

	           return new Select(locationList);

	}
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLogin() {
		return driver.findElement(signin);
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement getNavBar() {
		return driver.findElement(NavBar);
	}
}
