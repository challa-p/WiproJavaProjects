package Package1;

import java.util.Scanner;

public class PolyMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create Smith
        System.out.print("Enter name for first person: ");
        String name1 = sc.nextLine();
        System.out.print("Enter age for first person: ");
        float age1 = sc.nextFloat();
        System.out.print("Enter initial balance for first account: ");
        double balance1 = sc.nextDouble();

        PolyPerson smith = new PolyPerson(name1, age1);
        PolyAccount smithAccount = new PolyAccount(smith, balance1);

        // Create Kathy
        sc.nextLine(); // clear buffer
        System.out.print("\nEnter name for second person: ");
        String name2 = sc.nextLine();
        System.out.print("Enter age for second person: ");
        float age2 = sc.nextFloat();
        System.out.print("Enter initial balance for second account: ");
        double balance2 = sc.nextDouble();

        PolyPerson kathy = new PolyPerson(name2, age2);
        PolyAccount kathyAccount = new PolyAccount(kathy, balance2);

        // Deposit to Smith
        System.out.print("\nEnter amount to deposit into " + name1 + "'s account: ");
        double depositAmount = sc.nextDouble();
        smithAccount.deposit(depositAmount);

        // Withdraw from Kathy
        System.out.print("Enter amount to withdraw from " + name2 + "'s account: ");
        double withdrawAmount = sc.nextDouble();
        kathyAccount.withdraw(withdrawAmount);

        // Display Updated Balances
        System.out.println("\n--- Updated Account Details ---");
        System.out.println(smithAccount);
        System.out.println(kathyAccount);

        sc.close();
    }
}

