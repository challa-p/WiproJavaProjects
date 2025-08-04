package Package1;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class DurationBetweenTwoDates {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Accept first date
        System.out.println("Enter the first date:");
        System.out.print("Year (YYYY): ");
        int year1 = sc.nextInt();
        System.out.print("Month (MM): ");
        int month1 = sc.nextInt();
        System.out.print("Day (DD): ");
        int day1 = sc.nextInt();
        LocalDate date1 = LocalDate.of(year1, month1, day1);
 
        System.out.println("Enter the second date:");
        System.out.print("Year (YYYY): ");
        int year2 = sc.nextInt();
        System.out.print("Month (MM): ");
        int month2 = sc.nextInt();
        System.out.print("Day (DD): ");
        int day2 = sc.nextInt();
        LocalDate date2 = LocalDate.of(year2, month2, day2);
 
        if (date1.isAfter(date2)) {
            LocalDate temp = date1;
            date1 = date2;
            date2 = temp;
        }

         
        Period duration = Period.between(date1, date2);

        
        System.out.println("Duration between the two dates is: " +
                duration.getYears() + " years, " +
                duration.getMonths() + " months, and " +
                duration.getDays() + " days.");

        sc.close();
    }
}
