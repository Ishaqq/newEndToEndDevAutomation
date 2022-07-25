package comparrable.ai;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class ComparableRegistration extends base {
	public WebDriver driver;
	String email="";
	public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void setUp() throws IOException {
		driver=initializeDriver();
		log.info("driver initialized");
		
	}
	@Test
	public void comparrableRegistration() throws IOException, InterruptedException, AWTException {
		String password="12345678";
		String firstName="Unsa";
		String lastName="Saleem";
		String organisation="Comparrable";
		String title="Test Title";
		String country="Pakistan";
		String phone="+923348283765";
		String primaralyWork="Asset";
		String others="testText";
		 String[] optionsNeededArray = { "Valuation", "Benchmarking", "M&A" , "Other..."};
		 int j=0;
		 String successMessage="Get premium access";
		 
		driver.get("https://testing.comparables.ai/registration");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));

		((JavascriptExecutor)driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1)); //switches to new tab
	    driver.get("https://generator.email/");
	    Thread.sleep(1000);
	    List<WebElement> adsIns = driver.findElements(By.xpath("//ins"));
		 System.out.println(adsIns.size());
		 for(int i=0; i<adsIns.size();i++) {
			 hideElement(adsIns.get(i));
		//	 String adsIns2 = adsIns.get(i).getText();
		 }
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='email_ch_text']")));
	    WebElement emailxpath = driver.findElement(By.xpath("//*[@id='email_ch_text']"));
	     email=emailxpath.getText();
	    System.out.println(email);
	   
	    driver.switchTo().window(tabs.get(0));
	    Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys(email);
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='confirmPassword']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys(firstName);
		driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys(lastName);
		driver.findElement(By.xpath("//*[@id='organization']")).sendKeys(organisation);
		driver.findElement(By.xpath("//*[@id='title']")).sendKeys(title);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(text(),'Country*')]")).click();
		 Thread.sleep(2000);
         driver.findElement(By.xpath("//*[@id='react-select-2-input']")).sendKeys(country);
         driver.findElement(By.xpath("//*[@id='react-select-2-input']")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//*[@id='phone']")).sendKeys(phone);
		 JavascriptExecutor js = (JavascriptExecutor)driver;
	        js.executeScript("window.scrollBy(0,300)");
	        driver.findElement(By.xpath("//div[contains(text(),'Select one*')]")).click();
	         Thread.sleep(2000);
	         driver.findElement(By.xpath("//*[@id='react-select-3-input']")).sendKeys(primaralyWork);
	         driver.findElement(By.xpath("//*[@id='react-select-3-input']")).sendKeys(Keys.ENTER);
	         
	       //checkbox Options
	         WebElement e=driver.findElement(By.xpath("//div[contains(text(),'Select all that apply*')]"));
	         driver.findElement(By.xpath("//div[contains(text(),'Select all that apply*')]")).click();
			 Thread.sleep(1000);
//			 String p = driver.getPageSource();
//			 System.out.println(p);
			 List optionsNeededList = Arrays.asList(optionsNeededArray);
			 List<WebElement> Options = driver.findElements(By.xpath("//div[contains(@class, 'form-control__option')]"));
			 System.out.println(Options.size());
			 for(int i=0; i<Options.size();i++) {
				 String option = Options.get(i).getText();
				 System.out.println(option);
				 
				 if (optionsNeededList.contains(option))
					{
						j++;

						Options.get(i).click();
						if (j == optionsNeededArray.length)
						{
							break;
						}
					}
			 }
			 driver.findElement(By.xpath("//div[contains(text(),'Select all that apply*')]")).click();
			 driver.findElement(By.xpath("//*[@id=\"productHelpsWith\"]")).sendKeys(others);
//			Actions keyDown = new Actions(driver); 
//			keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
//			keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();

			 driver.findElement(By.xpath("//*[@id=\"Onboarding_Registration_Get_Access_Clicked_Success\"]/div[9]/button")).click();
			 Thread.sleep(3000);
			 String actualMesssage=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[1]/section/div/div/div/h2")).getText();
			 Assert.assertEquals(actualMesssage, successMessage);
			 
			  driver.switchTo().window(tabs.get(1));
			  Thread.sleep(2000);
		
	}
	
	public void hideElement(WebElement webElement)
	{
	    WebElement element = webElement;    
	    ((JavascriptExecutor)driver).executeScript("arguments[0].style.visibility='hidden'", element);
	}
}