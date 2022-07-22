package AppiumTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	public static AndroidDriver driver;
	public static AppiumDriverLocalService service;
	@BeforeClass
	public static void configureAppium() throws MalformedURLException {
		// TODO Auto-generated method stub
		 service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\muhammad.ishaq\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		UiAutomator2Options options= new UiAutomator2Options();
		options.setDeviceName("Test API 32");
//		options.setApp("D:\\SSMembership\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		options.setApp("D:\\SSMembership\\src\\test\\java\\resources\\General-Store.apk");
		 driver=new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void longPressElement(WebElement ele) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId(), "duration",2000
			));
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}

}
