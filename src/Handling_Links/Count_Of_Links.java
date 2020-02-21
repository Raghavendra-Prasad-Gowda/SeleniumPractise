package Handling_Links;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Count_Of_Links {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramprakash\\Desktop\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://trailhead.salesforce.com/en/home");
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		
		//Printing Number of Links
		System.out.println("Overall count of links = "+links.size());
		
		
		//Printing Number of links present in Footer of Website
		
		  //Restricting the webdriver scope
		  WebElement footer_scope=driver.findElement(By.xpath("//div[@class='tds-bg_white']"));
		  
		  //Adding footer links to the list
		  List<WebElement> footer_Links=footer_scope.findElements(By.tagName("a"));
		  System.out.println("Overall footer links count = " + footer_Links.size());
		  
		  System.out.println(" ");
		  Actions act= new Actions(driver);
		  for(int i=0;i<footer_Links.size();i++) {
			  act.moveToElement(footer_Links.get(i)).keyDown(Keys.CONTROL).click().build().perform();
		  }
		  
		  Set<String> windows=driver.getWindowHandles();
		  
		  Iterator<String> itr=windows.iterator();
		  
		 
		  
		  int i=1;
		  
		  while(itr.hasNext()) {
			  
			  
			  driver.switchTo().window(itr.next());
			  Add_Details_Excel(driver.getTitle(), i);
		      i++;
		  }
		  
		  

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
