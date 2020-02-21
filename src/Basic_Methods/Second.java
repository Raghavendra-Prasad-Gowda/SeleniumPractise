package Basic_Methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Second {
	
	public void HeaderValidation(){
		System.out.println("Header Validation is Pass");
		
	}
	
	public void FooterValidation() {
		System.out.println("Footer Validation is Pass");
	}
	
	public void Chrome() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramprakash\\Desktop\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
	}

}
