package Test_NG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data_provider_using_Excel {

	@Test(dataProvider="Data_Provider_TestNG")
	public void Data_provide_Excel(String user, String pass) {
		
	}
	
	@DataProvider
	public Object[][] Data_Provider_TestNG() throws IOException {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\Ramprakash\\Desktop\\DataProvider.xlsx");
		
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		XSSFRow row =null;
		
		
		Object [][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++) {
			
			row=sheet.getRow(i);
			data [i][0]=row.getCell(0).getStringCellValue();
			data [i][1]=row.getCell(1).getStringCellValue();
			
			
		}
			
		return data;
		
	}
	

}
