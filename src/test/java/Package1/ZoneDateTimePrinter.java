package Package1;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.Scanner;

public class ZoneDateTimePrinter {

    public static void printDateTimeForZone(String zoneId) {
        try {
            ZoneId zone = ZoneId.of(zoneId);
            ZonedDateTime dateTime = ZonedDateTime.now(zone);
            System.out.println("Current date and time in " + zoneId + " is: " + dateTime);
        } catch (Exception e) {
            System.out.println("Invalid Zone ID. Please enter a valid time zone.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Zone ID ");
        String zoneId = sc.nextLine();

        printDateTimeForZone(zoneId);

        sc.close();
    }
}
