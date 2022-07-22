package endToEndAutomation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.base2;

public class DataProviderExcel extends base2 {
	 @Test (dataProvider = "getData")
	public void addCustomer(String firstname, String lastname, String postcode) {
		System.out.println(firstname);
		System.out.println(lastname);
		System.out.println(postcode);
		
	}
	
	@DataProvider
	public Object[][] getData(){
		String sheetName="Sheet1";
		int rows=excel.getRowCount(sheetName);
		int cols=excel.getColumnCount(sheetName);
		
		Object[][] data= new Object[rows-1][cols];
		
		for(int rowNum=2; rowNum<=rows; rowNum++) {
			for (int colNum=0; colNum<cols; colNum++) {
				data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum);
			}
		}
		return data;
		
	}
}
