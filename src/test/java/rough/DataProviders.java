package rough;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import resources.ExcelReader;

public class DataProviders {

	@DataProvider(name="bankManagerDP")
	public static Object[][] getDataSuite1 (Method m) {
		ExcelReader excel=new ExcelReader(Constants.SUITE1_XL_PATH);
		String testcase=m.getName();
		return DataUtils.getData(testcase, excel);
	}
	
		@DataProvider(name="CustomerDP")
		public static Object[][] getDataSuite2 (Method m) {
			ExcelReader excel=new ExcelReader(Constants.SUITE2_XL_PATH);
			String testcase=m.getName();
			return DataUtils.getData(testcase, excel);
		}
	
}
