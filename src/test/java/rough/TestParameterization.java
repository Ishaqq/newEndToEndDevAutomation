package rough;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.ExcelReader;

public class TestParameterization {
	@Test(dataProvider="getData")
	//public void TestData(String Runmode,String firstname,String lastname,String postcode) {
	public void TestData(Hashtable<String,String> data) {
		System.out.println(data.get("Runmode")+data.get("firstname")+data.get("lastname")+data.get("postcode"));
	}

	@DataProvider
	public Object[][] getData () {

		ExcelReader excel = new ExcelReader(
				"C:\\Users\\qa.nitb\\eclipse-workspace\\endToEndAutomation\\src\\main\\java\\resources\\BankManagerSuite.xlsx");

		int rows = excel.getRowCount(Constants.DATA_SHEET);
		System.out.println("Total rows are : " + rows);

		String testName = "AddCustomerTest";

		// Find the test case start row
		String testCaseName = "";
		int testCaseRowNum = 1;
		for (testCaseRowNum = 1; testCaseRowNum <= rows; testCaseRowNum++) {
			testCaseName = excel.getCellData(Constants.DATA_SHEET, 0, testCaseRowNum);
			if (testCaseName.equalsIgnoreCase(testName))
				break;
		}
		System.out.println("Test case Name : " + testCaseName);
		System.out.println("Test case starts from row num: " + testCaseRowNum);

		// Checking total rows in test case

		int dataStartRowNum = testCaseRowNum + 2;
		int testRows = 0;
		while (!excel.getCellData(Constants.DATA_SHEET, 0, dataStartRowNum + testRows).equals("")) {
			testRows++;
		}

		System.out.println("Total rows of data are : " + testRows);

		// Checking total cols in test case

		int colStartColNum = testCaseRowNum + 1;
		int testCols = 0;

		while (!excel.getCellData(Constants.DATA_SHEET, testCols, colStartColNum).equals("")) {
			testCols++;
		}

		System.out.println("Total cols are : " + testCols);

		//Object[][] data=new Object[testRows][testCols];
		Object[][] data=new Object[testRows][1];
		// Printing data
		int i=0;
		for (int rNum = dataStartRowNum; rNum < (dataStartRowNum + testRows); rNum++) {
			//new for hashtable
			Hashtable<String,String> table=new Hashtable<String,String>();
			for (int cNum = 0; cNum < testCols; cNum++) {
				//System.out.println(excel.getCellData(Constants.DATA_SHEET, cNum, rNum));
				//data[rNum-dataStartRowNum][cNum]=excel.getCellData(Constants.DATA_SHEET, cNum, rNum);
				String testData=excel.getCellData(Constants.DATA_SHEET, cNum, rNum);
				String colName=excel.getCellData(Constants.DATA_SHEET, cNum, colStartColNum);
				table.put(colName, testData);
				//System.out.println(rNum);
			}
			data[i][0]=table;
			i++;
			
		}
		return data;

	}
}
