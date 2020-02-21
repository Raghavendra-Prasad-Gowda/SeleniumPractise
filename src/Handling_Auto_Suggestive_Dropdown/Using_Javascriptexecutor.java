package Handling_Auto_Suggestive_Dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Using_Javascriptexecutor {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramprakash\\Desktop\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://ksrtc.in/oprs-web/");
		
		WebElement from=driver.findElement(By.xpath("//input[@id='fromPlaceName']"));
		from.click();
		from.sendKeys("Ben");
		from.sendKeys(Keys.DOWN);
		from.sendKeys(Keys.DOWN);
		
		//Use JavaScript Executor when the Elements are in Autoload form, where
		//it is not possible to extract the text using getText() method.
		
		//Instantiate JavaScriptExecutor class
		JavascriptExecutor js=((JavascriptExecutor)driver);
		
		//Write the DOM (Data Object Model) statement to locate the element.
       
       String script="document.getElementById(\"fromPlaceName\").value";
		
       //Use return before 'document' word to get the value
       String script1="return document.getElementById(\"fromPlaceName\").value";
       
       //Add ';' at the end of value
       String script2="return document.getElementById(\"fromPlaceName\").value;";
       
       //Execute the Script and store it in String
       String location = (String)js.executeScript(script2);
       
       //Print the location
       
      System.out.println(location);
		
		

	}

}
