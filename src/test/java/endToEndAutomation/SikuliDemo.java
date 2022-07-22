package endToEndAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SikuliDemo {

    public static void main(String[] args){
    	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/image_upload/index.php");
        // Click on Browse button and handle windows pop up using Sikuli
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/a/img")).click();
        
        
        driver.findElement(By.xpath("//*[@id=\"photoimg\"]")).sendKeys("C:\\Users\\qa.nitb\\Downloads\\Fazal Haq_0008.jpg");
      
    }

}