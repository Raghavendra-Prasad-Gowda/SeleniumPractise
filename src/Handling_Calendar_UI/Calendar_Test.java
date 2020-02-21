package Handling_Calendar_UI;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramprakash\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.spicejet.com/");

		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']")).click();
		//driver.findElement(By.xpath("(//td[@data-handler='selectDay'])[23]")).click();
		
		WebElement cal=driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-last']"));
		
		List<WebElement> dates=cal.findElements(By.xpath(".//a[@class='ui-state-default']"));
		//List<WebElement> dates=cal.findElements(By.cssSelector("a[class='ui-state-default']"));
		
		for(int i=0;i<dates.size();i++) {
		System.out.println(dates.get(i).getText());
		}
		
		
		

	}

}
