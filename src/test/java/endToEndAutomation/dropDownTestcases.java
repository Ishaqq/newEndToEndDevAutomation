package endToEndAutomation;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.DropDownPage;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base;

public class dropDownTestcases extends base {
	public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void setUp() throws IOException {
		driver=initializeDriver();
		log.info("driver initialized");
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		log.info("Navigated to URL");
	}
	@Test
	public void loadingURL() throws IOException {
		//WebElement dropDownTest;
		DropDownPage drpD=new DropDownPage(driver);
		
		Select dropdown=new Select(drpD.getDropDownTest());
		WebElement option = dropdown.getFirstSelectedOption();
		String defaultItem = option.getText();
		System.out.println("default Selected : From 2nd method " + defaultItem);
		
		//dropdown.selectByValue(selectFromDropDown);
		
		
		Select val=drpD.getDropDownTest("USD");
		String selectedoption =val.getFirstSelectedOption().getText();
	      System.out.println("Selected element: " + selectedoption);
		
	}
	
}
