package Basic_Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class First {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramprakash\\Desktop\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		String a=driver.findElement(By.xpath("//div[@class='lfloat _ohe']/div/div[@class='_5iyx']")).getText();
		System.out.println(a);
		
	}
	

}
