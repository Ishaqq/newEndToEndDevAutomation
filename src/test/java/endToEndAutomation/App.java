package endToEndAutomation;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class App {
	//public static NgWebDriver ngDriver;
	public WebDriver driver;
	public static String Username ="muhammadishaq_GjV4ns";
	public static String accesskey ="dGCAzVFn4h1crEmYTXjx";
	public static final String URL = "https://" + Username + ":" + accesskey + "@hub-cloud.browserstack.com/wd/hub";
	JavascriptExecutor js = (JavascriptExecutor) driver;
	@Test
	public void ssPortalRegistration() throws IOException, InterruptedException {
		String email="testing912345@nomail.com";
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://ssqa/ssp/#/home/");
		 driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 driver.findElement(By.xpath("//div/div/div/form/div[3]/button")).click();
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='membership-travel']")));
		 driver.findElement(By.xpath("//label[@for='membership-travel']")).click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='type-1']")));
		 driver.findElement(By.xpath("//label[@for='type-1']")).click();
		 driver.findElement(By.xpath("//label[@for='term-1']")).click();
		driver.findElement(By.xpath("//*[@id='dropdown-animated']/li[5]")).click();
		driver.findElement(By.xpath("//label[@for='trips-4']")).click();
		driver.findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
		driver.findElement(By.xpath("//button[contains(text(),'continue')]")).click();
		
		driver.findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys("testing1");
		driver.findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys("testing2");
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("6172347625");
		driver.findElement(By.xpath("//input[@id='dp12']")).sendKeys("10 01, 1992");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='dp13']")).sendKeys("05 01 2022");
		driver.findElement(By.xpath("//label[@for='r-gender-male']")).click();
		WebElement ele  = driver.findElement(By.xpath("//input[@placeholder='Search Your Address']"));
		driver.findElement(By.xpath("//input[@placeholder='Search Your Address']")).sendKeys("Pindi Cricket"); 
		Thread.sleep(2000);
		new Actions(driver).moveToElement(ele).perform();
		ele.sendKeys(" ");
		new Actions(driver).moveToElement(ele).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pac-matched")));
		driver.findElements(By.cssSelector(".pac-item")).get(0).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),'continue')]")).click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(":nth-child(2) > .label-sm"))).click();
		 //driver.findElement(By.xpath("//*[@id='ti-no']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'continue')]")).click();
		driver.findElement(By.xpath("//input[@formcontrolname='creditCardNumber']")).sendKeys("4111111111111111");
		Select expiryMonth = new Select(driver.findElement(By.xpath("//select[@formcontrolname='expiryMonth']")));
		expiryMonth.selectByVisibleText("Mar");
		//expiryMonth.selectByIndex(1);
		Select expiryYear = new Select(driver.findElement(By.xpath("//select[@formcontrolname='expiryYear']")));
		expiryYear.selectByVisibleText("2025");
		driver.findElement(By.xpath("//input[@formcontrolname='creditCardCcv']")).sendKeys("123");
		driver.findElement(By.xpath("//button[contains(text(),'continue')]")).click();
		wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//label[@for='msaCheckBox']")))).click();
		driver.findElement(By.xpath("//button[contains(text(),'buy')]")).click();
		wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//h2[@class='message ffo']"))));
		String sucessRegistration=driver.findElement(By.xpath("//h2[@class='message ffo']")).getText();
		String ExpectedTitle = "Thank You For Signing Up";
		Assert.assertEquals(sucessRegistration, ExpectedTitle);
		
		String emailRegistered=driver.findElement(By.xpath("//ul[@class='list-unstyled member-info']/li[@class='ng-star-inserted']")).getText();
		Assert.assertEquals(emailRegistered, email);
	}
//	@AfterTest
//	public void teardown() {
//		driver.close();
//	}
}
