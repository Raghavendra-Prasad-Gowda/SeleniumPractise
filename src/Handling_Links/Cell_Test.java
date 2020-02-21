package Handling_Links;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Cell_Test {

	public static void main(String[] args) throws IOException {
		Add_Details_Excel("Google", 6);

	}
	
	public static void Add_Details_Excel(String WebPage_Title, int cell_no) throws IOException {
		  FileInputStream fis=new FileInputStream("C:\\Users\\Ramprakash\\Desktop\\Windows.xlsx");
		  FileOutputStream fos=null;
		  
		  XSSFWorkbook workbook = new XSSFWorkbook(fis);
		  XSSFSheet sheet=workbook.getSheet("Sheet1");
		  
		  XSSFCell cell=null;
		  XSSFRow row=null;
		  
		  row=sheet.getRow(cell_no);
		  if(row==null) {
			  row=sheet.createRow(cell_no);
		  }
		  
		  cell=row.getCell(0);
		  if(cell==null) {
			  cell=row.createCell(0);
		  }
		  
		  cell.setCellValue(WebPage_Title);
		  
		  fos = new FileOutputStream("C:\\\\Users\\\\Ramprakash\\\\Desktop\\\\Windows.xlsx");
		  workbook.write(fos);
		  fos.close();
	}


}
