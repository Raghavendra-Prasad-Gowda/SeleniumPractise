package Xpath_Css;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSS_Path {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramprakash\\Desktop\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://login.salesforce.com/");
		
		//Syntax Css = tagname[attribute='value']
		// Css = #value (value should be only @id attribute value)
		//Css = .classname
		
		driver.findElement(By.xpath("input[class='input r4 wide mb16 mt8 username']")).sendKeys("Test1");
		driver.findElement(By.xpath("#password")).sendKeys("Raghu");
		driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();
		
		driver.get("");
		driver.findElement(By.xpath("//input[@class='search-keyword']")).sendKeys("Apple");

	}

}
