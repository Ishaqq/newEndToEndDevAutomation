package AppiumTest;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class appiumtest extends BaseTest {
	
	@Test
	public void wifiSettingTestInMobile() throws IOException, InterruptedException {
		//Code to start Appium Server
//		AppiumDriverLocalService service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\muhammad.ishaq\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//				.withIPAddress("127.0.0.1").usingPort(4723).build();
//		service.start();
//		
//		UiAutomator2Options options= new UiAutomator2Options();
//		options.setDeviceName("Test API 32");
//		options.setApp("D:\\SSMembership\\src\\test\\java\\resources\\ApiDemos-debug.apk");
//		AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		//configureAppium(); No need to do this
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		driver.findElement(By.id("android:id/edit")).sendKeys("Test wifi");
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		
		service.stop();
	}

}