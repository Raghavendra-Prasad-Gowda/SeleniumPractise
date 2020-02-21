package Handling_Web_UI;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handlin_Auto_Suggestion_Dropdown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramprakash\\Desktop\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//label[@for='fromCity']")).click();
		
		Thread.sleep(2000);
		
		//driver.findElement(By.xpath("//label[@for='fromCity']")).sendKeys("Raghu");
		driver.findElement(By.xpath("//div[@role='combobox'] //input[@placeholder='From']")).click();
		
		driver.findElement(By.xpath("//div[@role='combobox'] //input[@placeholder='From']")).sendKeys("Bangalore");
		System.out.println("Keys sent");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@role='combobox'] //input[@placeholder='From']")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//div[@role='combobox'] //input[@placeholder='From']")).sendKeys(Keys.ENTER);
		
		Thread.sleep(4000);
		System.out.println(driver.findElement(By.xpath("//div[@class='fsw_inputBox searchToCity inactiveWidget '] //label[@for='toCity']")).getText());

	}

}
