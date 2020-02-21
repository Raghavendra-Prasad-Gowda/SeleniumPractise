package Basic_Methods;

import java.util.Scanner;

public class Input_Demo {

	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
    	
    	System.out.print("Enter an integer: ");
    	String number = input.next();
    	System.out.println("You entered " + number);
	}

}
