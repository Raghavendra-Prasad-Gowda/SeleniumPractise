package Handling_Auto_Suggestive_Dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KSRCTC_Initial_Page {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramprakash\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://ksrtc.in/oprs-web/");
//		WebElement from = driver.findElement(By.xpath("//input[@id='fromPlaceName']"));
//		from.click();
//		from.sendKeys("BENGALURU");
//		from.sendKeys(Keys.DOWN);
//		from.sendKeys(Keys.ENTER);
//		from.sendKeys(Keys.TAB);
//		
//		WebElement to = driver.findElement(By.xpath("//input[@id='toPlaceName']"));
//		//to.click();
//		//to.sendKeys("MYSURU");
//		to.sendKeys(Keys.DOWN);
//		to.sendKeys(Keys.ENTER);
//		to.sendKeys(Keys.TAB);
		
		driver.findElement(By.id("txtJourneyDate")).click();
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		List<WebElement> dates=driver.findElements(By.xpath("//td[@data-handler='selectDay']"));
		dates.get(1).click();

	}

}
