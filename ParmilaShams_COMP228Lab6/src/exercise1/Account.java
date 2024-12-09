package exercise1;

public class Account {
    private double balance;

    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposited: $" + amount + ", New balance: $" + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " Invalid deposit amount.");
        }
    }

    public synchronized void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew: $" + amount + ", New balance: $" + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " Withdrawal failed. Insufficient funds or invalid amount.");
        }
    }
    public double getBalance() {
        return balance;
    }
}

