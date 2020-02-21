package Handling_Web_UI;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Handling_Checkbox {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramprakash\\Desktop\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.spicejet.com/");
		WebElement a=driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']"));
		a.click();
		
		Assert.assertFalse(a.isSelected());
		
		List<WebElement> c=driver.findElements(By.xpath("//*[@type='checkbox']"));
		System.out.println("Number of Checkboxes are "+c.size());
		
		for(int i=0;i<c.size();i++) {
			System.out.println(c.get(i));
		}
		

	}

}
