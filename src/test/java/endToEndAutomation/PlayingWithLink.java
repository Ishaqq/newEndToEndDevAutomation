package endToEndAutomation;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class PlayingWithLink {
	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
		// TODO Auto-generated method stub
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				 WebDriver	 driver = new ChromeDriver();
				driver.get("https://rahulshettyacademy.com/AutomationPractice/");
				System.out.println(driver.findElements(By.tagName("a")).size());
				WebElement footerLink=driver.findElement(By.id("gf-BIG"));
				System.out.println(footerLink.findElements(By.tagName("a")).size());
				
				
				  //broken URL
		         //Step 1 - IS to get all urls tied up to the links using Selenium
		         //  Java methods will call URL's and gets you the status code
		         //if status code >400 then that url is not working-> link which tied to url is broken
		         //a[href*="soapui"]'
		        
		      List<WebElement> links=   driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		      SoftAssert a =new SoftAssert();
		      for(WebElement link : links)
		      {
		          String url= link.getAttribute("href");
		          HttpURLConnection   conn= (HttpURLConnection)new URL(url).openConnection();
		          conn.setRequestMethod("HEAD");
		          conn.connect();
		          int respCode = conn.getResponseCode();
		          a.assertTrue(respCode<400, "The link with Text"+link.getText()+" is broken with code" +respCode);
		       if(respCode>=400) {
		        	  System.out.println("The link with Text "+link.getText()+" is broken with code " +respCode);
		        	  System.out.println(url);
		        	  System.out.println(link.getText());
		          }
		      }
	
	}
}
