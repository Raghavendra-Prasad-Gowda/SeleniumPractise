package Screen_Shot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Take_Screenshot {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramprakash\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://facebook.com");
		
		TakeScreen_Shot("facebook", driver);
		
		

	}
	
	public static void TakeScreen_Shot(String image_name, WebDriver driver) throws IOException {
		TakesScreenshot shot=((TakesScreenshot)driver);
		File SrcFile=shot.getScreenshotAs(OutputType.FILE);
		
		//Move image file to new destination
        String i="1";
        File DestFile=new File("D:\\SeleniumScreenshots\\"+image_name+".png");

        //Copy file at destination

        FileUtils.copyFile(SrcFile, DestFile);
	}

}
