package AppiumTest;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class longPressGestures extends BaseTest {
	
	@Test
	public void testinglongPressGestures() throws IOException, InterruptedException {
	
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
		//Gesture Appium Long Click
		WebElement ele=driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		longPressElement(ele);
		
//		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
//			    "elementId", ((RemoteWebElement) ele).getId(), "duration",2000
//			));
		String MenueText=driver.findElement(By.xpath("//android.widget.TextView[@text='Sample menu']")).getText();
		Assert.assertEquals(MenueText, "Sample menu");
		
		Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text='Sample menu']")).isDisplayed());
		Thread.sleep(2000);

	}

}