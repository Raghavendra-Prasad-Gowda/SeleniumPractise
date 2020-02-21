package Handling_Calendar_UI;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar_UI {

	public static void main(String[] args) {
		
		Date_Selector("February", 2, "1");

	}

	public static void Date_Selector(String required_month, int month_number, String required_date) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramprakash\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.spicejet.com/");

		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']")).click();

		String required_month1= required_month;
		int month_number1=month_number;

		int UI_Month_Number = month_number1 - 1;

		String UI_Number_Converted = Integer.toString(UI_Month_Number);

		boolean flag = false;
		int while_cond = -1;

		while (while_cond == -1) {
			List<WebElement> month = driver.findElements(By.xpath("//span[@class='ui-datepicker-month']"));
			for (int i = 0; i < month.size(); i++) {
				if (month.get(i).getText().trim().equals(required_month1)) {
					flag = true;
				}
			}

			if (flag == true) {
				while_cond = 1;
			} else {
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
				while_cond = -1;
			}

		}

		
		String required_date1 = required_date;
		List<WebElement> dates = driver.findElements(By.xpath("//td[@data-handler='selectDay']"));

		for (int j = 0; j < dates.size(); j++) {
			if (dates.get(j).getText().trim().equals(required_date1)&& dates.get(j).getAttribute("data-month").equals(UI_Number_Converted)) {
				 dates.get(j).click();
				 break;

			}
		}
		
		System.out.println("Date Clicked");
		
	}

}
