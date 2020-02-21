package Handling_Web_UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Array_Demo {
	static WebDriver driver;
	
	public static void main(String[] args) {
		int a []= {1,2};
		a[0]=8;
		System.out.println(a);
		
		

	}
	
	public static void Invoke_Chrome() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramprakash\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	

}
