package Test_NG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test2 {

	@Test
	public static void Account() {
		System.out.println("Account");
	}

	
	//Passing the data from Data Provider
	@Test(dataProvider="get_data")
	public static void DB(String user, String Password) {
		System.out.println("DB");
		System.out.println(user);
		System.out.println(Password);
		
	}

	@Test(groups = "Smoke")
	public static void Smoke_Test_2() {
		System.out.println("Smoke_Test_2");
	}

	// Provides data for the method with multiple data sets
	@DataProvider
	public static Object[][] get_data() {

		Object[][] data = new Object[2][2];

		// 1st Data Set
		data[0][0] = "User1";
		data[0][1] = "Pass1";

		// 2nd Data Set
		data[1][0] = "User2";
		data[1][1] = "Pass2";
		
		return data;
	}

}
