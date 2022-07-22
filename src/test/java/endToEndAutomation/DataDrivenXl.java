package endToEndAutomation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenXl {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("C:\\Users\\qa.nitb\\eclipse-workspace\\endToEndAutomation\\src\\main\\java\\resources\\Book1.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		int sheets=workbook.getNumberOfSheets();
		System.out.println(workbook.getNumberOfSheets());
		for (int i=0; i<sheets;i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) {
			XSSFSheet sheet=workbook.getSheetAt(i);
			System.out.println(sheet.getSheetName());
			//Import java util and for row usermodel
			Iterator<Row> rows=sheet.iterator();
			Row firstrow=rows.next(); //First Row after 2nd it will go to 2nd row
			Iterator<Cell> ce=firstrow.cellIterator(); //import usermoadel
			int k=0;
			int coloumn = 0;
			while(ce.hasNext()) {
				Cell value=ce.next();
				value.getStringCellValue();
				if(value.getStringCellValue().equalsIgnoreCase("Testcases")) {
					coloumn=k;
				}
				
				k++;
			}
			System.out.println(coloumn);
			}
		}

	}

}
