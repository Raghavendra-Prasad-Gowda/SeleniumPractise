package Test_NG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1 {

	@BeforeClass
	public static void Login_Admin() {
		System.out.println("I am before class");
	}
	
	@BeforeMethod
	public static void Before_Method() {
		System.out.println("Before Every Method");
	}
	
	@Test
	public static void Login_Customer1() {
		System.out.println("Customer1");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramprakash\\Desktop\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://facebook.com");
	}
	
	//Adding Timeout helper attributes
	@Test(timeOut= 5000)
	public static void Login_Customer2() {
		System.out.println("Customer2");
	}
	
	@AfterClass
	public static void Login_Customer() {
		System.out.println("After Class");
	}
	
	@AfterMethod
	public static void After_Method() {
		System.out.println("After Every Method");
	}
	
	@BeforeTest
	public static void Before_Each_Test() {
		System.out.println("Before_Each_Test_From_XML");
	}
	
	@AfterTest
	public static void After_Each_Test() {
		System.out.println("After_Each_Test_Suite_Frpm_XML");
	}
	
	@Test(groups="Smoke")
	public static void Smoke_Test_1() {
		System.out.println("Smoke_Test_1");
	}
	
	
	
}
