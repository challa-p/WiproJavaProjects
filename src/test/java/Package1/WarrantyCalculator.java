package Package1;

import java.time.LocalDate;
import java.util.Scanner;

public class WarrantyCalculator {

    public static LocalDate calculateExpiryDate(LocalDate purchaseDate, int warrantyYears, int warrantyMonths) {
         
        return purchaseDate.plusYears(warrantyYears).plusMonths(warrantyMonths);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.println("Enter product purchase date:");
        System.out.print("Year (YYYY): ");
        int year = sc.nextInt();
        System.out.print("Month (MM): ");
        int month = sc.nextInt();
        System.out.print("Day (DD): ");
        int day = sc.nextInt();

        LocalDate purchaseDate = LocalDate.of(year, month, day);
 
        System.out.print("Enter warranty period (years): ");
        int warrantyYears = sc.nextInt();
        System.out.print("Enter warranty period (months): ");
        int warrantyMonths = sc.nextInt();
 
        LocalDate expiryDate = calculateExpiryDate(purchaseDate, warrantyYears, warrantyMonths);

      
        System.out.println("Warranty expires on: " + expiryDate);

        sc.close();
    }
}
