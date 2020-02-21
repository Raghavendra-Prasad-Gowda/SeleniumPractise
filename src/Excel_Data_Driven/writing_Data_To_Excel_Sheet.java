package Excel_Data_Driven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writing_Data_To_Excel_Sheet {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\Ramprakash\\Desktop\\Test.xlsx");
		 XSSFWorkbook workbook = new XSSFWorkbook(fis);
		 XSSFSheet sheet = workbook.getSheetAt(0);
		 Cell cell = null;
		 
		 System.out.println(sheet.getRow(0).getCell(0));
		 
		 //Writing the data to Excel Sheet
		 sheet.createRow(2).createCell(3).setCellValue("Written from Eclipse saudvsuadu");
		 
		 fis.close();

         FileOutputStream outFile =new FileOutputStream(new File("C:\\Users\\Ramprakash\\Desktop\\Test1POI.xlsx"));
         workbook.write(outFile);
         outFile.close();

	}

}
