package rough;

import resources.ExcelReader;

public class ReadingExcelData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExcelReader excel = new ExcelReader(
				"C:\\Users\\qa.nitb\\eclipse-workspace\\endToEndAutomation\\src\\main\\java\\resources\\BankManagerSuite.xlsx");

		int rows = excel.getRowCount(Constants.DATA_SHEET);
		System.out.println("Total rows are : "+rows);
		
		String testName = "OpenAccountTest";
		
		//Find the test case start row
		String testCaseName="";
		int testCaseRowNum=1;
		for(testCaseRowNum=1; testCaseRowNum<=rows;testCaseRowNum++){
			 testCaseName = excel.getCellData(Constants.DATA_SHEET, 0, testCaseRowNum);	
			if(testCaseName.equalsIgnoreCase(testName))
				break;	
		}
		System.out.println("Test case Name : "+testCaseName);
		System.out.println("Test case starts from row num: "+testCaseRowNum);
		
		//Checking total rows in test case
		
		int dataStartRowNum = testCaseRowNum+2;
		int testRows = 0;
		while(!excel.getCellData(Constants.DATA_SHEET, 0, dataStartRowNum+testRows).equals("")){	
			testRows++;
		}
		
		System.out.println("Total rows of data are : "+testRows);
		
		//Checking total cols in test case
	
		int colStartColNum = testCaseRowNum+1;
		int testCols=0;
	
		while(!excel.getCellData(Constants.DATA_SHEET, testCols, colStartColNum).equals("")){
			testCols++;	
		}
		
		System.out.println("Total cols are : "+testCols);
		
		//Printing data
		for(int rNum=dataStartRowNum; rNum<(dataStartRowNum+testRows);rNum++){
			for(int cNum=0; cNum<testCols; cNum++){	
				System.out.println(excel.getCellData(Constants.DATA_SHEET, cNum, rNum));
				
			}	
		}	
	}
}
