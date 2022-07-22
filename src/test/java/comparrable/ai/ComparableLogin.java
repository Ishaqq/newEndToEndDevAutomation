package comparrable.ai;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class ComparableLogin extends base {
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void setUp() throws IOException {
		driver=initializeDriver();
		log.info("driver initialized");
		
	}
	@Test
	public void comparrableRegistration() throws IOException, InterruptedException {
		String email="zakluka8@soccerfit.com";
		String password="12345678";
		 String successMessage="Here will be success message on Login";
		 
		driver.get("https://testing.comparables.ai/login"); 
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		Thread.sleep(2000);
		driver.findElement(By.id("cookieaccept")).click();
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys(email);
		driver.findElement(By.xpath("//*[@id='userpassword']")).sendKeys(password);
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

		Thread.sleep(2000);

		 driver.findElement(By.xpath("/html/body/div[3]/div/button")).click();	
		 Thread.sleep(1000);
	        String welcomeMesssage=driver.findElement(By.xpath("//div/div[1]/div/div[2]/div/div[1]/p")).getText();
			 Assert.assertEquals(welcomeMesssage, "Publicly traded companies");
		
		
	}

}