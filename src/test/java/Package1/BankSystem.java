package Package1;

import java.util.Scanner;

class BankPerson {
    private String name;
    private float age;

    public BankPerson(String name, float age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [Name=" + name + ", Age=" + age + "]";
    }
}

class BankAccount {
    private static long accCounter = 1000;
    protected long accNum;
    protected double balance;
    protected BankPerson accHolder;

    public BankAccount(BankPerson accHolder, double balance) {
        this.accNum = ++accCounter;
        this.accHolder = accHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Overridden in subclasses
    public boolean withdraw(double amount) {
        if (amount > 0 && balance - amount >= 500) {
            balance -= amount;
            return true;
        }
        System.out.println("Withdrawal denied.");
        return false;
    }

    @Override
    public String toString() {
        return "Account [Account Number=" + accNum + ", Balance=" + balance + ", Account Holder=" + accHolder + "]";
    }
}

class BankSavingsAccount extends BankAccount {
    private final double minimumBalance;

    public BankSavingsAccount(BankPerson accHolder, double balance, double minimumBalance) {
        super(accHolder, balance);
        this.minimumBalance = minimumBalance;
        if (this.balance < minimumBalance) {
            this.balance = minimumBalance;
        }
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= minimumBalance) {
            balance -= amount;
            return true;
        }
        System.out.println("Withdrawal denied. Minimum balance of INR " + minimumBalance + " must be maintained.");
        return false;
    }

    @Override
    public String toString() {
        return "SavingsAccount [Account Number=" + accNum + ", Balance=" + balance +
               ", Minimum Balance=" + minimumBalance + ", Account Holder=" + accHolder + "]";
    }
}

class BankCurrentAccount extends BankAccount {
    private double overdraftLimit;

    public BankCurrentAccount(BankPerson accHolder, double balance, double overdraftLimit) {
        super(accHolder, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= -overdraftLimit) {
            balance -= amount;
            return true;
        }
        System.out.println("Withdrawal denied. Overdraft limit of INR " + overdraftLimit + " exceeded.");
        return false;
    }

    @Override
    public String toString() {
        return "CurrentAccount [Account Number=" + accNum + ", Balance=" + balance +
               ", Overdraft Limit=" + overdraftLimit + ", Account Holder=" + accHolder + "]";
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Savings Account
        System.out.print("Enter name for savings account holder: ");
        String name1 = sc.nextLine();
        System.out.print("Enter age: ");
        float age1 = sc.nextFloat();
        System.out.print("Enter initial balance: ");
        double balance1 = sc.nextDouble();
        System.out.print("Enter minimum balance: ");
        double minBalance = sc.nextDouble();

        BankPerson person1 = new BankPerson(name1, age1);
        BankAccount savings = new BankSavingsAccount(person1, balance1, minBalance);

        // Current Account
        sc.nextLine(); // clear buffer
        System.out.print("\nEnter name for current account holder: ");
        String name2 = sc.nextLine();
        System.out.print("Enter age: ");
        float age2 = sc.nextFloat();
        System.out.print("Enter initial balance: ");
        double balance2 = sc.nextDouble();
        System.out.print("Enter overdraft limit: ");
        double overdraftLimit = sc.nextDouble();

        BankPerson person2 = new BankPerson(name2, age2);
        BankAccount current = new BankCurrentAccount(person2, balance2, overdraftLimit);

        // Transactions
        System.out.print("\nEnter amount to deposit into savings account: ");
        double depositAmount = sc.nextDouble();
        savings.deposit(depositAmount);

        System.out.print("Enter amount to withdraw from current account: ");
        double withdrawAmount = sc.nextDouble();
        current.withdraw(withdrawAmount);

        // Output
        System.out.println("\n--- Updated Account Details ---");
        System.out.println(savings);
        System.out.println(current);

        sc.close();
    }
}

