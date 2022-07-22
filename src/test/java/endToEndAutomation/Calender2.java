package endToEndAutomation;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import pageObject.AutoSugestDropPage;
import resources.base;
@Test
public class Calender2 extends base {
			String expected_from_date_str = "01/20/2020";
			String expected_to_date_str = "02/26/2020";
			 
			String expected_fr_date = "27";
			String expected_to_date = "31";
	public void getCurrentDay() {
        //Create a Calendar Object
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        //Get Current Day as a number
        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("Today Int: " + todayInt + "\n");
        //Integer to String Conversion
        String todayStr = Integer.toString(todayInt);
        System.out.println("Today Str: " + todayStr + "\n");
       // return todayStr;
    }
	
	@Test
	public void calendar() throws InterruptedException, IOException {

		// TODO Auto-generated method stub
				driver = initializeDriver();
				driver.get("https://jqueryui.com/datepicker/#date-range");
				
				driver.manage().window().maximize();
		        WebElement iframe_element = driver.findElement(By.xpath("//*[@id='content']/iframe"));
		        driver.switchTo().frame(iframe_element);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@id='from']")).click();
				WebElement from_month=driver.findElement(By.xpath("//div/select[@class='ui-datepicker-month']"));
				Select dropdown=new Select(from_month);
				dropdown.selectByVisibleText("Feb");
				WebElement from_day = driver.findElement(By.xpath("//td[not(contains(@class,'ui-datepicker-month'))]/a[text()='" + expected_fr_date + "']"));
				        from_day.click();
	}
	
}
