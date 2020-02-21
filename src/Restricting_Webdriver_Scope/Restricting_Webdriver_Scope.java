package Restricting_Webdriver_Scope;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Restricting_Webdriver_Scope {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramprakash\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/22967/nza-vs-inda-1st-unofficial-test-india-a-tour-of-new-zealand-2020");
        
		
		WebElement tables1=driver.findElement(By.xpath("(//div[@id='innings_1'] //div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr'])[1]"));
		
		//While restricting the webdriver scope using the required Weblement, if you are using xpath to find the
		// required elements please use ' . ' dot before starting xpath, which is as written below.
		
		
		//int count=tables1.findElements(By.xpath(".//div[@class='cb-col cb-col-8 text-right text-bold']")).size();
		
		
		//If using CssSelector then we can proceed normal.
		List<WebElement> count=tables1.findElements(By.cssSelector("div[class='cb-col cb-col-8 text-right text-bold']"));
		
		for(int i=0;i<count.size();i++) {
			System.out.println(count.get(i).getText());
		}
		
		
	}

}
