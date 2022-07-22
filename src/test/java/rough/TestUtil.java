package rough;

import resources.ExcelReader;

public class TestUtil {
	public static boolean isSuiteRrunnable(String suiteName, ExcelReader excel) {
		int rows=excel.getRowCount(Constants.SUITE_SHEET);
		System.out.println(rows);
		for (int rowNum=2; rowNum<=rows; rowNum++) {
			String data=excel.getCellData(Constants.SUITE_SHEET, Constants.SUITENAME_COL, rowNum);
			if(data.equals(suiteName)) {
			String runmode=excel.getCellData(Constants.SUITE_SHEET, Constants.RUNMODE_COL, rowNum);
			System.out.println(runmode);
			if(runmode.equals(Constants.RUNMODE_YES))
				return true;
			else 
				return false;
			}
		} 
		return false;
	}

	public static boolean isTestRrunnable(String testCaseName, ExcelReader excel) {
		int rows=excel.getRowCount(Constants.TESTCASE_SHEET);
		System.out.println(rows);
		for (int rowNum=2; rowNum<=rows; rowNum++) {
			String data=excel.getCellData(Constants.TESTCASE_SHEET, Constants.TESTCASE_COL, rowNum);
			if(data.equals(testCaseName)) {
			String runmode=excel.getCellData(Constants.TESTCASE_SHEET, Constants.RUNMODE_COL, rowNum);
			if(runmode.equals(Constants.RUNMODE_YES))
				return true;
			else 
				return false;
			}
		} 
		return false;

	}
}
