package rough.bankManagerSuiteTestcases;

import java.util.Hashtable;
import org.testng.annotations.Test;
import resources.ExcelReader;
import rough.Constants;
import rough.DataProviders;
import rough.DataUtils;

public class AddCustomerTest {
	//@Test(dataProvider="getData")
	@Test(dataProviderClass=DataProviders.class,dataProvider="bankManagerDP")
	public void addCustomerTest(Hashtable<String, String> data) {
	
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtils.checkExecution("BankManagerSuite", "AddCustomerTest", data.get("Runmode"), excel);
		
		DataUtils.isTestRunnable("addCustomerTest", excel);
	}
}
