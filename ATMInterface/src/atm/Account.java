package atm;

import java.util.ArrayList;


class Account {
    private String accountId;
    private double balance;
    private ArrayList<Transaction> transactionHistory;

    public Account(String accountId) {
        this.accountId = accountId;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public String getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add(new Transaction("Deposit", amount));
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add(new Transaction("Withdrawal", amount));
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void transfer(Account receiver, double amount) {
        if (amount <= balance) {
            balance -= amount;
            receiver.deposit(amount);
            transactionHistory.add(new Transaction("Transfer to " + receiver.getAccountId(), amount));
        } else {
            System.out.println("Insufficient funds.");
        }
    }
}