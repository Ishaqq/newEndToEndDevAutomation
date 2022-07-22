package endToEndAutomation;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import resources.TestUtils;

public class CommonDataProviderXl {
 
	@Test(dataProviderClass=TestUtils.class, dataProvider="dp")
	//public void commonDataProvider(String name, String class1, String Code) {
		public void commonDataProvider(Hashtable<String,String> data) {
		if(!data.get("runmode").equals("Y")) {
			throw new SkipException("with N no");
		}
		System.out.println(data.get("name"));
		System.out.println(data.get("class1"));
		System.out.println(data.get("code"));
	}
}
