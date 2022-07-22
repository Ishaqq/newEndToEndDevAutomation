package ssPortal;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObject.LandingPage;
import pageObject.LoginPage;
import pageObject.SSportalHomeLogin;
import resources.base;
import resources.base2;

public class ssPortalLogin extends base {
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void setUp() throws IOException {
		driver=initializeDriver();
		log.info("driver initialized");
		
	}
	@Test
	public void validateUsers() throws IOException {
		driver.get(prop.getProperty("url")); 
		SSportalHomeLogin ssportalLogin = new SSportalHomeLogin(driver);
		ssportalLogin.getUserName().sendKeys("ishaq8283@gmail.com");
		ssportalLogin.getPassword().sendKeys("1234412");
		ssportalLogin.getLoginButon().click();
		
		
	}
//	@AfterTest
//	public void teardown() {
//		driver.close();
//	}
	
	
}
