package Handling_Auto_Suggestive_Dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LiveExample_JavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramprakash\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://ksrtc.in/oprs-web/");

		driver.manage().window().fullscreen();
		From_City_Selector(driver, "BELLARY");

		To_City_Selector(driver, "BENGALURU");

		Date_Selector(driver, "February", "8");

	}

	public static void Date_Selector(WebDriver driver, String month, String date) {

		driver.findElement(By.id("txtJourneyDate")).click();
		WebElement month_name = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));

		

		if (month_name.getText().trim().equals(month)) {
			System.out.println("Month is in First Page");

		} else {

			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			System.out.println("Month is in Second Page");
		}

		System.out.println("List Not prepared");
		List<WebElement> dates = driver.findElements(By.xpath("//td[@data-handler='selectDay']"));
		System.out.println("List Prepared");
		
		for (int i = 0; i < dates.size(); i++) {
			System.out.println(dates.get(i).getText());
			if (dates.get(i).getText().trim().equals(date)) {
				System.out.println("Not Clicked");
				dates.get(i).click();
				System.out.println("Clicked");
				break;
			}
		}
	

	}

	public static void From_City_Selector(WebDriver driver, String From_City) {

		WebElement from = driver.findElement(By.xpath("//input[@id='fromPlaceName']"));
		from.click();
		from.sendKeys(From_City);
		int while_validator = 0;
		while (while_validator == 0) {

			from.sendKeys(Keys.DOWN);
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			String script2 = "return document.getElementById(\"fromPlaceName\").value;";
			String location = (String) js.executeScript(script2);

			if (location.equals(From_City)) {
				System.out.println(location);
				from.sendKeys(Keys.ENTER);
				from.sendKeys(Keys.TAB);

				while_validator = 1;
			}
		}
	}

	public static void To_City_Selector(WebDriver driver, String To_City) throws InterruptedException {

		WebElement to = driver.findElement(By.xpath("//input[@id='toPlaceName']"));
		// to.click();
		// Thread.sleep(3000);
		// to.sendKeys(To_City);
		int while_validator = 0;
		while (while_validator == 0) {

			to.sendKeys(Keys.DOWN);
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			String script2 = "return document.getElementById(\"toPlaceName\").value;";
			String location = (String) js.executeScript(script2);

			if (location.equals(To_City)) {
				System.out.println(location);
				to.sendKeys(Keys.ENTER);
				to.sendKeys(Keys.TAB);
				while_validator = 1;
			}
		}
	}

}
