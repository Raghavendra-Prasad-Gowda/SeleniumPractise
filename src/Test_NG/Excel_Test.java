package Test_NG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Test {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\Ramprakash\\Desktop\\DataProvider.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		XSSFRow row = sheet.getRow(1);
		
		XSSFCell cell =null;
		
		System.out.println(sheet.getLastRowNum());
		System.out.println(row.getLastCellNum());
		
		System.out.println(row.getCell(1).getStringCellValue());
		System.out.println(row.getCell(0).getStringCellValue());

	}

}
