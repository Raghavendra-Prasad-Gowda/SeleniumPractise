package Excel_Data_Driven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldatacompare {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Users\\Ramprakash\\Desktop\\Data1.xlsx");
		FileInputStream fis1 = new FileInputStream("C:\\Users\\Ramprakash\\Desktop\\Data2.xlsx");
		FileOutputStream fos = null;
		XSSFWorkbook workbook1 = new XSSFWorkbook(fis);
		XSSFWorkbook workbook2 = new XSSFWorkbook(fis1);
		XSSFSheet sheet1 = workbook1.getSheet("test1");
		XSSFSheet sheet2 = workbook2.getSheet("test2");
		XSSFRow row1 = null;
		XSSFCell cell1 = null;
		XSSFRow row2 = null;
		XSSFCell cell2 = null;

//		int sheet1cellno=0;
//		for(int j=0;j<=sheet1.getRow(0).getLastCellNum();j++) {
//			if(sheet1.getRow(0).getCell(j).getStringCellValue().equals("Description")) {
//				sheet1cellno=j;
//				System.out.println(j);
//				break;
//			}
//				
//		}
//		
//		int sheet2cellno=0;
//		for(int k=0;k<=sheet2.getRow(0).getLastCellNum();k++) {
//			if(sheet2.getRow(0).getCell(k).getStringCellValue().equals("Description")) {
//				sheet1cellno = k;
//				System.out.println(k);
//				break;
//			}
//				
//		}
//		
//	
//		
		
		
		if (sheet1.getRow(0).getCell(0).getStringCellValue() != null) {
			int sheet1cellno=0;
			for(int j=0;j<=sheet1.getRow(0).getLastCellNum();j++) {
				if(sheet1.getRow(0).getCell(j).getStringCellValue().equals("Description")) {
					sheet1cellno = j;
					System.out.println(sheet1cellno);
					break;
				}
					
			}
			
			int sheet2cellno=0;
			for(int k=0;k<=sheet2.getRow(0).getLastCellNum();k++) {
				if(sheet2.getRow(0).getCell(k).getStringCellValue().equals("Description")) {
					sheet2cellno = k;
					System.out.println(sheet2cellno);
					break;
				}
					
			}
			
			
			
			
			
			
			
			for (int i = 1; i <= sheet1.getLastRowNum(); i++) {

				for (int y = 1; y <= sheet2.getLastRowNum(); y++) {

					if (sheet1.getRow(i).getCell(0).getStringCellValue()
							.equals(sheet2.getRow(y).getCell(0).getStringCellValue())) {
						// System.out.println(sheet2.getRow(y).getCell(0).getStringCellValue());

						row1 = sheet1.getRow(i);
						if (row1 == null) {
							row1 = sheet1.createRow(i);
						}

						cell1 = row1.getCell(sheet1cellno);
						if (cell1 == null) {
							cell1 = row1.createCell(sheet1cellno);
						}

						String description1 = cell1.getStringCellValue();

						row2 = sheet2.getRow(y);
						if (row2 == null) {
							row2 = sheet1.createRow(y);
						}

						cell2 = row2.getCell(sheet2cellno);
						if (cell2 == null) {
							cell2 = row2.createCell(sheet2cellno);
						}

						cell2.setCellValue(description1 +"Java Code");

						break;
					}

				}

			}
			
			fos = new FileOutputStream("C:\\\\Users\\\\Ramprakash\\\\Desktop\\\\Data2.xlsx");
			workbook2.write(fos);
			fos.close();
		}else {
			System.out.println("Please check whether First Row First Column of Excel sheet is Empty");
		}

		

	}

}
