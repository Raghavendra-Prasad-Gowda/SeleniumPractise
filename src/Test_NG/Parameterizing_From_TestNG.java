package Test_NG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameterizing_From_TestNG {

	@Parameters({"user","pass"})
	@Test
	public static void Param1(String user, String pass) {
		System.out.println("Param1");
		System.out.println(user);
		System.out.println(pass);
		
	}

}
