package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ssPortalRegistrationPage {
	public WebDriver driver;
	By membershipTravel = By.xpath("//label[@for='membership-travel']");
	By typeIndividual = By.xpath("//label[@for='type-1']");
	By term1=By.xpath("//label[@for='term-1']");
	By term5years=By.xpath("//*[@id='dropdown-animated']/li[5]");
	By tripLengthLabel4=By.xpath("//label[@for='trips-4']");
	By registrationEmail=By.xpath("//input[@formcontrolname='email']");
	By stickyContinueButton=By.xpath("//button[contains(text(),'continue')]");
	
	By firstName=By.xpath("//input[@formcontrolname='firstName']");
	By lastName=By.xpath("//input[@formcontrolname='lastName']");
	By phoneNumber=By.xpath("//input[@placeholder='Phone Number']");
	By birthDate=By.xpath("//input[@id='dp12']");
	By membershipStartDate=By.xpath("//input[@id='dp13']");
	By genderMale=By.xpath("//label[@for='r-gender-male']");
	By searchAddress=By.xpath("//input[@placeholder='Search Your Address']");
	By searchPacMatch=By.className("pac-matched");
	By pacItem=By.cssSelector(".pac-item");
	
	By travelInsuranceNotSelected=By.xpath("//*[@id='ti-yes-no']/form/div/div[2]/label");
	
	By creditCardNo=By.xpath("//input[@formcontrolname='creditCardNumber']");
	By expiryMonth = By.xpath("//select[@formcontrolname='expiryMonth']");
	By expiryYear = By.xpath("//select[@formcontrolname='expiryYear']");
	By crditCardCVV =By.xpath("//input[@formcontrolname='creditCardCcv']");
	By concentAgreementCheckBox =By.xpath("//label[@for='msaCheckBox']");
	By btnBuy=By.xpath("//button[contains(text(),'buy')]");
	By thanksHeading=By.xpath("//h2[@class='message ffo']");
	By registeredEmail=By.xpath("//ul[@class='list-unstyled member-info']/li[@class='ng-star-inserted']");
	
	
	public ssPortalRegistrationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getMembershipTravel() {
		return driver.findElement(membershipTravel);
	}
	
	public WebElement getTypeIndividual() {
		return driver.findElement(typeIndividual);
	}
	
	public WebElement getTerm1() {
		return driver.findElement(term1);
	}
	
	public WebElement getTerm5years() {
		return driver.findElement(term5years);
	}
	
	public WebElement getTripLengthLabel4() {
		return driver.findElement(tripLengthLabel4);
	}
	
	public WebElement getRegistrationEmail() {
		return driver.findElement(registrationEmail);
	}
	
	public WebElement getStickyContinueButton() {
		return driver.findElement(stickyContinueButton);
	}
	
	public WebElement getfirstName() {
		return driver.findElement(firstName);
	}
	
	public WebElement getlastName() {
		return driver.findElement(lastName);
	}
	
	public WebElement getphoneNumber() {
		return driver.findElement(phoneNumber);
	}
	public WebElement getbirthDate() {
		return driver.findElement(birthDate);
	}
	
	public WebElement getmembershipStartDate() {
		return driver.findElement(membershipStartDate);
	}
	public WebElement getgenderMale() {
		return driver.findElement(genderMale);
	}
	
	public WebElement getsearchAddress() {
		return driver.findElement(searchAddress);
	}
	
	public WebElement getsearchPacMatch() {
		return driver.findElement(searchPacMatch);
	}
	
	public WebElement getpacItem() {
		return driver.findElement(pacItem);
	}
	
	public WebElement getTravelInsuranceNotSelected() {
		return driver.findElement(travelInsuranceNotSelected);
	}
	
	public WebElement getcreditCardNo() {
		return driver.findElement(creditCardNo);
	}
	
	public Select getexpiryMonth(String selectFromMonths) {
		Select month=new Select(driver.findElement(expiryMonth));
		month.selectByVisibleText(selectFromMonths);
		return month;
	}
	
	public Select getexpiryYear(String selectFromYears) {
		Select Year=new Select(driver.findElement(expiryYear));
		Year.selectByVisibleText(selectFromYears);
		return Year;
	}
	
	public WebElement getcrditCardCVV() {
		return driver.findElement(crditCardCVV);
	}
	
	public WebElement getConcentAgreementCheckBox() {
		return driver.findElement(concentAgreementCheckBox);
	}
	
	public WebElement getbtnBuy() {
		return driver.findElement(btnBuy);
	}
	
	public WebElement getthanksHeading() {
		return driver.findElement(thanksHeading);
	}
	
	public WebElement getregisteredEmail() {
		return driver.findElement(registeredEmail);
	}
	
	
}
