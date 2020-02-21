package Handling_Mouse_Interactions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Windows_Handling_Assignment {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramprakash\\Desktop\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.amazon.com/ref=nav_logo");
		
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.linkText("Help"))).keyDown(Keys.CONTROL).click().build().perform();
		
		//Getting Windows Handles
		Set<String> Handles=driver.getWindowHandles();
		
		//Using Iterator to traverse and get the Stored content in Set
		Iterator traverser=Handles.iterator();
		
		
		String Parent_Handle=(String) traverser.next();
		
		String Child_Handle=(String) traverser.next();
		
		driver.switchTo().window(Child_Handle);
		System.out.println(driver.findElement(By.xpath("(//h1)[1]")).getText());
		
		driver.switchTo().window(Parent_Handle);
		System.out.println(driver.getTitle());
		

	}

}
