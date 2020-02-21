package Test_NG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test3 {
	
	//Executes before Main test suite
	@BeforeSuite
	public static void Before_Test_Suite() {
		System.out.println("Before_Test_Suite");
	}
	
	
	//Executes After Main test suite
	@AfterSuite
	public static void After_Test_Suite() {
		System.out.println("After_Test_Suite");
	}
	
	
	//TestNg helper annotaion for enabling and disabling the test case
	@Test(enabled=true)
	public static void T1() {
		System.out.println("T1 with Enabled Annotation");
	}
	
	@Test
	public static void T2() {
		System.out.println("T2 ");
	}
	
	@Test
	public static void T3() {
		System.out.println("Main method for T3 ");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramprakash\\Desktop\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://google.com");
	}
	
	//Grouping the test cases with Annotaion
	@Test(groups="Smoke")
	public static void Smoke_Test_3() {
		System.out.println("Smoke_Test_3");
	}
	
	//Adding the dependency on another method
	@Test(dependsOnMethods= {"T3"})
	public static void Dependency() {
		System.out.println("Depends on T3");
	}
	

}
