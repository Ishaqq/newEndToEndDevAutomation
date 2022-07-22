package pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage {
	public WebDriver driver;
	By dropDownTest = By.xpath("//*[@id='ctl00_mainContent_DropDownListCurrency']");
	

	public DropDownPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getDropDownTest() {
		
		return driver.findElement(dropDownTest);

	}
	
	public Select getDropDownTest(String selectFromDropDown) {
		Select dropdown=new Select(driver.findElement(dropDownTest));
		WebElement option = dropdown.getFirstSelectedOption();
		String defaultItem = option.getText();
		System.out.println("default Selected : " + defaultItem);
		
		dropdown.selectByValue(selectFromDropDown);
		return dropdown;

	}
}
