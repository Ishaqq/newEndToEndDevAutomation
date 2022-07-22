package endToEndAutomation;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AddToCartArray {
	public WebDriver driver;
	public static String Username ="muhammadishaq_GjV4ns";
	public static String accesskey ="dGCAzVFn4h1crEmYTXjx";
	public static final String URL = "https://" + Username + ":" + accesskey + "@hub-cloud.browserstack.com/wd/hub";
	@Test
	public void addToCartArraySimply() throws InterruptedException, MalformedURLException {
// TODO Auto-generated method stub
		DesiredCapabilities capabilities = new DesiredCapabilities();
	    // Setting the browser capability
	    capabilities.setCapability("browserName", "chrome");
	      
	    HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
	    // Setting the OS or device version capabilities
	    browserstackOptions.put("os", "Windows");
	    browserstackOptions.put("osVersion", "10");    
	    // Setting a build name for the test
	    browserstackOptions.put("buildName", "Testing for Learning purpose");       
	    // Setting a session name for the test    
	    browserstackOptions.put("sessionName", "First Test");
	    // Setting the Selenium version
	    browserstackOptions.put("seleniumVersion", "4.0.0");
	    capabilities.setCapability("bstack:options", browserstackOptions);

	    final WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), capabilities);
	    JavascriptExecutor jse = (JavascriptExecutor)driver;

		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot" };
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);
		addItems(driver, itemsNeeded);
		
		if (driver.getTitle().equals("GreenKart - veg and fruits kart")) {
		      jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Title matched!\"}}");
		    }
		    else {
		      jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Title not matched\"}}");
		    }
		
		Thread.sleep(1000);
		driver.quit();
	}

	public static void addItems(WebDriver driver, String[] itemsNeeded)
	{
		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		System.out.println(products.size());
		for (int i = 0; i < products.size(); i++)
		{
//Brocolli - 1 Kg
//Brocolli,    1 kg

			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();
//format it to get actual vegetable name
//convert array into array list for easy search
//  check whether name you extracted is present in arrayList or not-
			List itemsNeededList = Arrays.asList(itemsNeeded);
			if (itemsNeededList.contains(formattedName))
			{
				j++;

//click on Add to cart
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == itemsNeeded.length)
				{
					break;

				}

			}

		}

	}

}
