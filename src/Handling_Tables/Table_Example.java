package Handling_Tables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table_Example {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramprakash\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/22967/nza-vs-inda-1st-unofficial-test-india-a-tour-of-new-zealand-2020");
        
		
		WebElement tables1=driver.findElement(By.xpath("(//div[@id='innings_1'] //div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr'])[1]"));
		
		//int count=tables1.findElements(By.xpath(".//div[@class='cb-col cb-col-8 text-right text-bold']")).size();
		
		int count=tables1.findElements(By.cssSelector("div[class='cb-col cb-col-8 text-right text-bold']")).size();
		//Thread.sleep(3000);
		System.out.println(count);
		
	}

}
