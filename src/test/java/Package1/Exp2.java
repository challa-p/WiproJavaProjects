package Package1;

import java.util.Scanner;

public class Exp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println("Enter the num : " + num );
		
		if (num > 0) {
		System.out.println("The entered is negative");
	    }
		else {
			System.out.println("The Entered number is Positive" );
		}
	}
}