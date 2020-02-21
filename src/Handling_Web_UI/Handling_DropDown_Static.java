package Handling_Web_UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Handling_DropDown_Static {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramprakash\\Desktop\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.spicejet.com/");
		
		//While handling the Static Dropdown, use the class Select. Pass the Webelement as argument to the class
		driver.findElement(By.xpath("//div[@class='paxinfo']")).click();
		Select Adult=new Select(driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_Adult']")));
		Select Child=new Select(driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_Child']")));
		Select Infant=new Select(driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_Infant']")));
		
		for(int i=0;i<=3;i++) {
			
			Adult.selectByIndex(i);
			
		}
		
		String a=driver.findElement(By.xpath("//div[@class='paxinfo']")).getText();
		System.out.println(a);
	

	}

}
