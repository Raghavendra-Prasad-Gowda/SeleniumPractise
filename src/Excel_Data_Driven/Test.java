package Excel_Data_Driven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\Ramprakash\\Desktop\\ArchrDump.xlsx");
		
		
		XSSFWorkbook workbook1 = new XSSFWorkbook(fis);
		
		XSSFSheet sheet1 = workbook1.getSheet("Sheet1");
		//sheet1.createRow(0);
		XSSFRow row=sheet1.getRow(1);
		
		XSSFCell cell=row.getCell(4);
		System.out.println(cell.getStringCellValue());
		

	}

}
