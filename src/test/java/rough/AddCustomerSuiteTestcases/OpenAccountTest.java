package rough.AddCustomerSuiteTestcases;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.ExcelReader;
import rough.Constants;
import rough.DataProviders;
import rough.DataUtils;

public class OpenAccountTest {
	@Test(dataProviderClass=DataProviders.class,dataProvider="bankManagerDP")
	public void openAccountTest(Hashtable<String, String> data) {
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtils.checkExecution("BankManagerSuite", "OpenAccountTest", data.get("Runmode"), excel);
	}
	
}
