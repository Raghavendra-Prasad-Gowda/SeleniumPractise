package Implicit_Wait__Explicit_Wait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Implicit_Wait {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		
		//Specifying Implicit Wait --> Where each steps wait for 5sec Max, after which it will throw error. 
		//If the step finished within 3 secs then it proceeds immediately, will not wait unyill 5 secs.
		
		
		
		// Invoking Chrome Browser
		Invoke_Chrome();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Getting the respective test URL
		Geturl("https://rahulshettyacademy.com/seleniumPractise/#/");

		
		// Getting Index and Passing Item Names
		String a[] = { "Carrot", "Brinjal", "Mushroom" };
		int b[] = { 3, 6, 15 };

		for (int p = 0; p < a.length; p++) {
			Addingarrayofitems(Getitemindex(a[p]), a[p], b[p] - 1, 0);
			Thread.sleep(3000);

		}

		Checkout();
		System.out.println("Operation Completed");

	}

	public static void Invoke_Chrome() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramprakash\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	public static void Geturl(String URL) {
		driver.get(URL);
	}

	public static int[] Getitemindex(String itemName) {

		// Adding the list of Items in WebElement List
		List<WebElement> a = driver.findElements(By.xpath("//h4[@class='product-name']"));
		int i = 0;
		int x = 1;
		int indexlist[] = { 0, 0 };
		for (i = 0; i < a.size(); i++) {

			if (a.get(i).getText().trim().contains(itemName)) {
				break;
			} else {
				x = x + 1;
			}
		}
		indexlist[0] = i;
		indexlist[1] = x;

		return indexlist;
	}

	public static void Addingarrayofitems(int[] IndexList, String itemName, int addNo, int delNo) {

		// Validating the item presence
		if (IndexList[1] <= 30) {
			int z = IndexList[0] + 1;
			String a1 = Integer.toString(z);
			// System.out.println(a1);
			String addToCartButton = "(//div[@class='product-action'] //button[@type='button'])" + "[" + a1 + "]";
			// System.out.println(custom_Xpath);
			driver.findElement(By.xpath(addToCartButton)).click();

			// driver.close();

			// Pressing the Decrement button
			String minusButton = "(//div[@class='stepper-input'] //a[@class='decrement'])" + "[" + a1 + "]";
			String plusButton = "(//div[@class='stepper-input'] //a[@class='increment'])" + "[" + a1 + "]";

			if (addNo > 0) {

				for (int g = 0; g < addNo; g++) {
					// driver.findElement(By.xpath(plusButton)).click();
					driver.findElement(By.xpath(plusButton)).click();

				}
			}

		} else {
			System.out.println("Your Item " + itemName
					+ " is not found. Please enter the valid Item name to Search and add to the cart");
		}

	}

	public static void Checkout() throws InterruptedException {
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		System.out.println("Cart Icon Clicked");

		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		System.out.println("Procced to Checkout Clicked");

		
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		System.out.println("promoCode Sent");

		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		System.out.println("promoCode Applied");

		

		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		System.out.println("Place Order Clicked");
		Thread.sleep(3000);
		Select s = new Select(driver.findElement(By.xpath("//select[@style='width: 200px;']")));
		s.selectByValue("Greece");
		System.out.println("Country Selected");

		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		System.out.println("Checkbox Selected");

		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		System.out.println("Proceed Buton Clicked");

		// driver.findElement(By.linkText("Home")).click();

	}

}
