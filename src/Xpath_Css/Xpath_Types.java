package Xpath_Css;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath_Types {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramprakash\\Desktop\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://login.salesforce.com/");
		
		//Syntax for Xpath = //tagname[@attribute='value']
		
		//Xpath = //*[@attribute='value'] (* --> Indicates any tag )
		
		//Xpath = //tagname[contains(@attribute,'value')]
		
		//Writing X-Path using text Name
		//Xpath= //tagname[text()='test']
		
		//Parent Child Xpath === //tagname[@attribute='value'] //tagname[@attribute='value'] (Seperate two Xpath with a space,
		// so that it searches within that parent
		
		driver.findElement(By.xpath("//input[@class='input r4 wide mb16 mt8 username']")).sendKeys("Test1");
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("Raghu");
		driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();

	}

}
