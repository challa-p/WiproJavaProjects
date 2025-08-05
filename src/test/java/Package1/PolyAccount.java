package Package1;

public class PolyAccount {
    private static long accCounter = 1000; // Auto-generated account numbers start from 1000
    private long accNum;
    private double balance;
    private PolyPerson accHolder;

    // Constructor
    public PolyAccount(PolyPerson accHolder, double balance) {
        this.accNum = ++accCounter;
        this.accHolder = accHolder;
        if (balance >= 500) { // Ensure minimum balance
            this.balance = balance;
        } else {
            this.balance = 500; // Default to minimum if initial balance is less
        }
    }

    // Deposit Method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Withdraw Method
    public void withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= 500) { // Maintain minimum balance of 500
            balance -= amount;
        } else {
            System.out.println("Withdrawal denied. Minimum balance of INR 500 must be maintained.");
        }
    }

    // Get Balance
    public double getBalance() {
        return balance;
    }

    // Getters
    public long getAccNum() {
        return accNum;
    }

    public PolyPerson getAccHolder() {
        return accHolder;
    }

    public void setAccHolder(PolyPerson accHolder) {
        this.accHolder = accHolder;
    }

    @Override
    public String toString() {
        return "Account [Account Number=" + accNum + ", Balance=" + balance + ", Account Holder=" + accHolder + "]";
    }
}

