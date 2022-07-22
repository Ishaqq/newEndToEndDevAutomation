package endToEndAutomation;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObject.AutoSugestDropPage;
import resources.base;

public class AutosugestiveDropdown extends base {

	@Test
	public void autoDropDown() throws InterruptedException, IOException {

// TODO Auto-generated method stub
		driver = initializeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		AutoSugestDropPage asdp=new AutoSugestDropPage(driver);
		asdp.getautoSugestBox().sendKeys("pa");
		Thread.sleep(5000);
		List<WebElement> options = asdp.getautoSugestOptions();

		for (WebElement option : options)

		{

			if (option.getText().equalsIgnoreCase("Pakistan"))

			{

				option.click();

				break;

			}

		}

	}

}
