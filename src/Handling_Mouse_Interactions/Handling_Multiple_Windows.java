package Handling_Mouse_Interactions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_Multiple_Windows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramprakash\\Desktop\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/#");
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//button[@id='openwindow']")).click();
		
		//Window Handles returns Set Data Structure
		Set<String> r=driver.getWindowHandles();
		
		//Use Iterator to get the data from Set
		Iterator i=r.iterator();
		
		//next() moves the iterator to first element and so on
		String parent_id=(String) i.next();
		String child_id=(String) i.next();
		
		//Using SwitchTo method we can switch to child Tab
		driver.switchTo().window(child_id);
		System.out.println(driver.getTitle());
		
 
	}

}
