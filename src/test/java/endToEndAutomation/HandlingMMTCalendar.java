package endToEndAutomation;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.base;

public class HandlingMMTCalendar extends base {
	public WebDriver driver;

	public static void selectDate(WebElement calendar, String year, String monthName, String day, WebDriver driver) throws ParseException, InterruptedException 
	{
		//Clicking on calendar to open calendar widget
		calendar.click();
		Thread.sleep(3000);
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement departCal = driver.findElement(By.xpath("//div[contains(@class,'DayPicker-Caption')]/div[text()='January 2022']"));
			wait.until(ExpectedConditions.elementToBeClickable(departCal));
		// Retrieving current year value
		String currentYear= driver.findElement(By.xpath("//div[@class='DayPicker-wrapper']/div/div/following-sibling::div[1]/div[1]/div")).getText();
		String currentYear1 =currentYear;
				String [] splitedString= currentYear1.split(" ");
				currentYear=splitedString[1];
				System.out.println(currentYear);
				System.out.println(year);
		// Click on Next arrow till we get desired year
				
				String requiredYear;
		if(!currentYear.equals(year))
		{
			do{
				driver.findElement(By.cssSelector(".DayPicker-NavButton.DayPicker-NavButton--next")).click();
				 requiredYear= driver.findElement(By.xpath("//div[@class='DayPicker-wrapper']/div/div/following-sibling::div[1]/div[1]/div")).getText();
				String [] splitedYear= requiredYear.split(" ");
				requiredYear=splitedString[1];
				System.out.println(requiredYear);
			}while(!requiredYear.equals(year));
			
		}
		
		// Select desired month after selecting desired year
		String currentMonth= driver.findElement(By.xpath("//div[@class='DayPicker-wrapper']/div/div/following-sibling::div[1]/div[1]/div")).getText();
		String [] splitedYear= currentMonth.split(" ");
		String calMonth=splitedString[0];
		System.out.println(calMonth);
		System.out.println(monthName);
		String requiredMonth;
		if(!calMonth.equalsIgnoreCase(monthName))
		{
			do{
				driver.findElement(By.cssSelector(".DayPicker-NavButton.DayPicker-NavButton--next")).click();
				 currentMonth= driver.findElement(By.xpath("//div[@class='DayPicker-wrapper']/div/div/following-sibling::div[1]/div[1]/div")).getText();
				String [] splitedMonth= currentMonth.split(" ");
				  requiredMonth=splitedMonth[0];
				System.out.println(requiredMonth);
				
			}while(!requiredMonth.equalsIgnoreCase(monthName));
			
		}
		
		driver.findElement(By.cssSelector(".DayPicker-NavButton.DayPicker-NavButton--next")).click();
		//get java month number for desired month
		
		
		// Find dates of desired month only
		
		List<WebElement> allDateOfDesiredDate= driver.findElements(By.xpath("//div[@class='DayPicker-Month'][1]/div[3]/div/div/div/p[1]"));
		for(WebElement d:allDateOfDesiredDate )
		{
			System.out.println(d.getText());
			if(d.getText().equals(day))
			{
				Thread.sleep(3000);
				d.click();
				break;
			}
		}
		
		}
		
		public static void main(String[] args) throws ParseException, IOException, InterruptedException {
			
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			WebDriver driver= new ChromeDriver();
			
			driver.get("https://www.makemytrip.com/");
			driver.manage().window().maximize();
			  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement departCal = driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[1]/ul/li[3]"));
				wait.until(ExpectedConditions.elementToBeClickable(departCal));
			Thread.sleep(3000);
			departCal.click();
			WebElement departCal2= driver.findElement(By.xpath("//span[contains(text(),'DEPARTURE')]"));
			HandlingMMTCalendar.selectDate(departCal2, "2022", "December", "10", driver);
			
		}
	}