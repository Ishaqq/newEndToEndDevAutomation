package ssPortal;
import java.io.IOException;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.SSportalHomeLogin;
import pageObject.ssPortalRegistrationPage;
import resources.base;

public class ssPortalRegistration  extends base {
	public WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void setUp() throws IOException {
		driver=initializeDriver();
		log.info("driver initialized");
	}

	@Test
	public void ssPortalRegistration() throws IOException, InterruptedException {
		String email="testing8123@nomail.com";
		driver.get(prop.getProperty("url")); 
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		SSportalHomeLogin ssportalLogin = new SSportalHomeLogin(driver);
		ssPortalRegistrationPage ssportalRegistration = new ssPortalRegistrationPage(driver);
		ssportalLogin.getNotAMember().click();	
		WebElement MembershipTravel =ssportalRegistration.getMembershipTravel();
		wait.until(ExpectedConditions.visibilityOf(MembershipTravel));
		MembershipTravel.click();	 
		WebElement type1 =ssportalRegistration.getTypeIndividual();
		wait.until(ExpectedConditions.visibilityOf(type1));
		type1.click();		 
		ssportalRegistration.getTerm1().click();
		ssportalRegistration.getTerm5years().click();
		ssportalRegistration.getTripLengthLabel4().click();
		ssportalRegistration.getRegistrationEmail().sendKeys(email);
		ssportalRegistration.getStickyContinueButton().click();

		//Step 2 Registration
		ssportalRegistration.getfirstName().sendKeys("testingFName");
		ssportalRegistration.getlastName().sendKeys("TestingLName");
		ssportalRegistration.getphoneNumber().sendKeys("6172347625");
		ssportalRegistration.getbirthDate().sendKeys("10011992");
		Thread.sleep(1000);
		ssportalRegistration.getmembershipStartDate().sendKeys("05012022");
		ssportalRegistration.getgenderMale().click();
		WebElement ele=ssportalRegistration.getsearchAddress();
		ele.sendKeys("Pindi Cricket"); 
		Thread.sleep(2000);
		new Actions(driver).moveToElement(ele).perform();
		ele.sendKeys(" ");
		new Actions(driver).moveToElement(ele).perform();	
		WebElement pacmatched=ssportalRegistration.getsearchPacMatch();
		wait.until(ExpectedConditions.visibilityOf(pacmatched));
		driver.findElements(By.cssSelector(".pac-item")).get(0).click();
		Thread.sleep(500);
		ssportalRegistration.getStickyContinueButton().click();

		//Step 3 Registration
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		Thread.sleep(500);
		ssportalRegistration.getTravelInsuranceNotSelected().click();
		ssportalRegistration.getStickyContinueButton().click();

		//Step 4 Registration
		ssportalRegistration.getcreditCardNo().sendKeys("4111111111111111");
		ssportalRegistration.getexpiryMonth("Mar");
		ssportalRegistration.getexpiryYear("2025");
		ssportalRegistration.getcrditCardCVV().sendKeys("123");
		ssportalRegistration.getStickyContinueButton().click();
		ssportalRegistration.getConcentAgreementCheckBox().click();
		Thread.sleep(2000);
		WebElement getbuttonBuy=ssportalRegistration.getbtnBuy();
		wait.until(ExpectedConditions.visibilityOf(getbuttonBuy));
		ssportalRegistration.getbtnBuy().click();

		WebElement regHeading=ssportalRegistration.getthanksHeading();
		wait.until(ExpectedConditions.visibilityOf(regHeading));	
		String sucessRegistration=regHeading.getText();
		String ExpectedTitle = "Thank You For Signing Up";
		Assert.assertEquals(sucessRegistration, ExpectedTitle);

		String emailRegistered=ssportalRegistration.getregisteredEmail().getText();
		Assert.assertEquals(emailRegistered, email);
	}
	//	@AfterTest
	//	public void teardown() {
	//		driver.close();
	//	}
}
