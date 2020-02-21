package Excel_Data_Driven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Demo_Excel {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		
	// Fetching data from Excel and adding it to the Array List
		
		//I have placed an excel file 'Test.xlsx' in my D Driver 
		 FileInputStream fis = new FileInputStream("C:\\Users\\Ramprakash\\Desktop\\Test.xlsx");
		 XSSFWorkbook workbook = new XSSFWorkbook(fis);
		 XSSFSheet sheet = workbook.getSheetAt(0);
		 Cell cell = null;
		                        //I have added test data in the cell A1 as "SoftwareTestingMaterial.com"
		                        //Cell A1 = row 0 and column 0. It reads first row as 0 and Column A as 0.
		 //Row row = sheet.getRow(0);
		 //Cell cell = row.getCell(0);
		 //System.out.println(cell);
		 //System.out.println(sheet.getRow(1).getCell(0));
		 
		 
		 
		 //Gettinf data from excel and adding into Array List
		 ArrayList<String> list=new ArrayList<String>();//Creating arraylist    
		 for(int i=0;i<=15;i++) {
			 
			 //System.out.println(sheet.getRow(i).getCell(0).getStringCellValue());
			 list.add(sheet.getRow(i).getCell(0).getStringCellValue());
			 
		 }
		 System.out.println("Data From Excel:");
		 for(int y=0;y<list.size();y++) {
			 
			 System.out.println(list.get(y));
			 
		 }
		 System.out.println(" ");
		 
		 
		 
		 
		 
		 
		 //Selenium Webdriver fetching test cases from Website
		 
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramprakash\\Desktop\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver();
			
		 driver.get("https://survicate.com/website-survey/questions/");
		 
		 List<WebElement> a=driver.findElements(By.xpath("//h3[@style='text-align: justify;']"));
		 
		 ArrayList<String> CompareWebList = new ArrayList<String>();
		 System.out.println("Data From WebUI:");
		 for(int z=0;z<a.size();z++) {
			
			 CompareWebList.add(a.get(z).getText());
		 }
		 

		 
		 
		 
//		 for(int q=0;q<CompareWebList.size();q++) {
//			 Assert.assertEquals(list.get(q),CompareWebList.get(q));
//			 System.out.println(q+1 +" Question Pass");
//		 }
		 
		 
		 
		 //Comparing the test values and Checking it.
		 for(int a1=0;a1<CompareWebList.size();a1++) {
			 
			 for(int b1=0;b1<list.size();b1++) {
				 if(CompareWebList.get(a1).equals(list.get(a1))) {
					System.out.println(a1+1 +") "+ CompareWebList.get(a1) + "   ------> PASS");
					break;
				 }else {
					 System.out.println(a1+1 + ") "+ CompareWebList.get(a1) + "  ------> is FAIL");
					 break;
				 }
			 }
		 }
		
		 cell = sheet.getRow(0).getCell(1);
		 
		 cell.setCellValue("Raghu");
		
	}

}
