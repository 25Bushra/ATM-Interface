package atm;

import java.util.Scanner;

class ATM {
    private User currentUser;
    private Account currentAccount;

    public ATM(User user, Account account) {
        this.currentUser = user;
        this.currentAccount = account;
    }

    public void showMenu() {
        System.out.println("1. Transactions History");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Quit");
    }

    public void performTransaction(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                displayTransactionHistory();
                break;
            case 2:
                System.out.print("Enter withdrawal amount: ");
                double withdrawalAmount = scanner.nextDouble();
                currentAccount.withdraw(withdrawalAmount);
                break;
            case 3:
                System.out.print("Enter deposit amount: ");
                double depositAmount = scanner.nextDouble();
                currentAccount.deposit(depositAmount);
                break;
            case 4:
                System.out.print("Enter transfer amount: ");
                double transferAmount = scanner.nextDouble();
                System.out.print("Enter receiver's account id: ");
                String receiverAccountId = scanner.next();
                Account receiverAccount = findAccount(receiverAccountId);
                if (receiverAccount != null) {
                    currentAccount.transfer(receiverAccount, transferAmount);
                } else {
                    System.out.println("Receiver account not found.");
                }
                break;
            case 5:
                System.out.println("Exiting ATM. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void displayTransactionHistory() {
        System.out.println("Transaction History:");
        for (Transaction transaction : currentAccount.getTransactionHistory()) {
            System.out.println(transaction.getType() + ": $" + transaction.getAmount());
        }
    }

    private Account findAccount(String accountId) {
        return currentAccount.getAccountId().equals(accountId) ? currentAccount : null;
    }
}
