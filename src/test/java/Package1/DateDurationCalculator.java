package Package1;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class DateDurationCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter year (YYYY): ");
        int year = sc.nextInt();
        System.out.print("Enter month (MM): ");
        int month = sc.nextInt();
        System.out.print("Enter day (DD): ");
        int day = sc.nextInt();
 
        LocalDate enteredDate = LocalDate.of(year, month, day);

      
        LocalDate currentDate = LocalDate.now();
 
        Period duration = Period.between(enteredDate, currentDate);

      
        System.out.println("Duration is: " +
                duration.getYears() + " years, " +
                duration.getMonths() + " months, and " +
                duration.getDays() + " days.");

        sc.close();
    }
}
