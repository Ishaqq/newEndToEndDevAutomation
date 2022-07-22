package endToEndAutomation;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base;
import resources.base2;

public class validateNavBar extends base2 {
	public WebDriver driver;
	//public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void setUp() throws IOException {
		driver=initializeDriver();
//		log.info("driver initialized");
		driver.get(prop.getProperty("url"));
//		log.info("URL loaded");
	}
	@Test
	public void validateBasePageNavigation() throws IOException {
		LandingPage l=new LandingPage(driver);	
		l.getNavBar().isDisplayed();
		Assert.assertTrue(l.getNavBar().isDisplayed());
//		log.info("Navigation displayed");
		test.log(Status.INFO, "Navigation bar is displayed");
		
	}
	@AfterTest
	public void teardown() {
		driver.close();
	}
}
