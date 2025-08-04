package Package1;

import java.util.Scanner;

public class PersonMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Accept person details from user
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine(); // Consume newline

        System.out.print("Enter Phone Number: ");
        String phoneNumber = sc.nextLine();

        System.out.print("Enter Gender (M/F): ");
        char genderChar = sc.next().charAt(0);

        Gender gender;
        try {
            gender = Gender.fromChar(genderChar);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            sc.close();
            return;
        }

        // Create object using parameterized constructor
        Person p1 = new Person(name, age, phoneNumber, gender);

        // Display details
        p1.displayDetails();

        sc.close();
    }
}