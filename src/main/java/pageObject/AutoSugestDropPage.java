package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AutoSugestDropPage {
	public WebDriver driver;
	By autoSugestBox = By.id("autosuggest");

	// List<WebElement> options =
	// driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
	By autoSugestOptions = By.cssSelector("li[class='ui-menu-item'] a");

	public AutoSugestDropPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getautoSugestBox() {

		return driver.findElement(autoSugestBox);

	}

	public List<WebElement> getautoSugestOptions() {

		return driver.findElements(autoSugestOptions);

	}
}
