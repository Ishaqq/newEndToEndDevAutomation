package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

public class base {
	public WebDriver driver;
	public Properties prop;

	public  WebDriver initializeDriver() throws IOException {
		 prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);

		//Dono  use browserName == "phantomjs" , == when u extract value from properties
		if (browserName.equals("phantomjs") ) {
			System.out.println(browserName);
		} else if (browserName.equals("firefox") ) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			System.out.println(browserName);
		} else if (browserName.equals("chrome") ) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			 DesiredCapabilities capabilities = new DesiredCapabilities();
		        capabilities.setCapability("network", true); // To enable network logs
		        capabilities.setCapability("visual", true); // To enable step by step screenshot
		        capabilities.setCapability("video", true); // To enable video recording
		        capabilities.setCapability("console", true); // To capture console logs
			driver = new ChromeDriver();
		} else if (browserName.equals("IE")) {
			System.out.println(browserName);
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;

	}
	public String getScreenShotPath(String testcaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testcaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
	}
}
