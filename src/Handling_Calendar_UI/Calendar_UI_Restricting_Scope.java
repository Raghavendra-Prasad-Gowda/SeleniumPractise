package Handling_Calendar_UI;

import java.io.IOException;
import java.util.List;
import Sending_Mail_Using_Java.*;
import java.util.concurrent.TimeUnit;
import Screen_Shot.*;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar_UI_Restricting_Scope {

	public static void main(String[] args) throws AddressException, MessagingException, IOException {
		
		Date_Selector("November", "8");
		

	}

	
	public static void Date_Selector(String required_month, String required_date) throws AddressException, MessagingException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramprakash\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.spicejet.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']")).click();


		int page_seq = 0;
		int while_validator = 0;
		int for_terminator = 0;
		while (while_validator == 0) {

			List<WebElement> months = driver.findElements(By.xpath("//span[@class='ui-datepicker-month']"));

			for (int i = 0; i < months.size(); i++) {
				if (months.get(i).getText().trim().contains(required_month)) {

					page_seq = i + 1;
					for_terminator = 1;
					break;
				}
			}

			if (for_terminator == 1) {
				while_validator = 1;
			} else {
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			}
		}

		// System.out.println(page_seq);

		String X_Path = "";

		if (page_seq == 1) {
			X_Path = "//div[@class='ui-datepicker-group ui-datepicker-group-first']";
		} else if (page_seq == 2) {
			X_Path = "//div[@class='ui-datepicker-group ui-datepicker-group-last']";
		}

		// System.out.println(X_Path);

		// Limiting the search scope

		WebElement full_calendar = driver.findElement(By.xpath(X_Path));

		List<WebElement> dates = full_calendar.findElements(By.xpath(".//a[@class='ui-state-default']"));

		int date_validator = 0;
		for (int j = 0; j < dates.size(); j++) {
			if (dates.get(j).getText().trim().equals(required_date)) {
				dates.get(j).click();
				date_validator = 1;
				break;
			}
		}

		if (date_validator != 1) {
			System.out.println("Invalid date for the month");
			Sending_Mail.Mail_Sender("Test Case Fail");
		}else {
			Take_Screenshot.TakeScreen_Shot("Spicejet",driver);
			Sending_Mail.Mail_Sender("Test Case Pass for Spice Jet");
			
		}
		
	}

}
