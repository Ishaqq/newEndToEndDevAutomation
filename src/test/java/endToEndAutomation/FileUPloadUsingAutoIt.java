package endToEndAutomation;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import resources.base;

public class FileUPloadUsingAutoIt extends base {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://pdf2jpg.net/");
		driver.findElement(By.id("advanced_pdf_file")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("fileUpload.exe");

	}

}
