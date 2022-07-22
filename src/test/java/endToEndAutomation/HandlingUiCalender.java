package endToEndAutomation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;



import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;



public class HandlingUiCalender {



public static void main (String[] args)  throws InterruptedException, ParseException  {
	WebDriver driver;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date dateWithoutTime = sdf.parse(sdf.format(new Date()));
	Calendar cal = Calendar.getInstance();
	cal.set(Calendar.HOUR_OF_DAY, 0);
	cal.set(Calendar.MINUTE, 0);
	cal.set(Calendar.SECOND, 0);
	cal.set(Calendar.MILLISECOND, 0);
	dateWithoutTime = cal.getTime();
	String output=dateWithoutTime.toString();
	System.out.println(output);
	String[] words = output.split("\\s+");
	System.out.println( words[2]);
//	for (int i = 0; i < words.length; i++) {
//		System.out.println( words[2]);
//	}
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://www.spicejet.com/");
	driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div[1]/div[1]/div[2]/div[1]")).click();
	Thread.sleep(6000);
	driver.findElement(By.cssSelector(".css-1dbjc4n.r-1awozwy.r-16ru68a.r-y47klf.r-1loqt21.r-eu3ka.r-1otgn73.r-1aockid")).click();
}


}

