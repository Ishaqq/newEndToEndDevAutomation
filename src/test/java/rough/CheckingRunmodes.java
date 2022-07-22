package rough;

import resources.ExcelReader;

public class CheckingRunmodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String suiteName="BankManagerSuite";
		boolean suiteRunmode=TestUtil.isSuiteRrunnable(suiteName, new ExcelReader(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Suite.xlsx"));
		System.out.println(suiteRunmode);
		
		String testCaseName="AddCustomerTest";
		boolean testRunmode=TestUtil.isTestRrunnable(testCaseName, new ExcelReader(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\BankManagerSuite.xlsx"));
		System.out.println(testRunmode);
		
	}

}
