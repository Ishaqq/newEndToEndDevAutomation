package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class base2 {
	public static FileInputStream fis;
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\main\\java\\resources\\Book1.xlsx");
	public static WebDriverWait wait;
	public static String browser;
	public static String screenshotPath;
	public static String screenshotName;
	public  WebDriver driver;
	public Properties prop;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExtentTest test;
	public static ExtentReports extent=ExtentReporterNG.getReportObject();
	public ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	public ExtentReports rep = ExtentReporterNG.getReportObject();
	public  WebDriver initializeDriver() throws IOException {
		 prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\qa.nitb\\eclipse-workspace\\endToEndAutomation\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);

		//Dono  use browserName == "phantomjs" , == when u extract value from properties
		if (browserName.equals("phantomjs") ) {
			System.out.println(browserName);
		} else if (browserName.equals("firefox") ) {
			System.out.println(browserName);
		} else if (browserName.equals("chrome") ) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("IE")) {
			System.out.println(browserName);
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;

	}
	
	public String getScreenShotPath(String testcaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testcaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
	}
	
	public static String captureScreenshot(String testcaseName, WebDriver driver) throws IOException {

		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testcaseName+screenshotName +".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;

	}

}
