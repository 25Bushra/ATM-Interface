package atm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        User user = new User("bushra123", "9870");
        Account account = new Account("A123");
        ATM atm = new ATM(user, account);

        System.out.print("Enter user ID: ");
        String userIdInput = scanner.next();
        System.out.print("Enter PIN: ");
        String pinInput = scanner.next();

        if (userIdInput.equals(user.getUserId()) && pinInput.equals(user.getPin())) {
            System.out.println("Login successful!");
            int choice;

            while (true) {
                atm.showMenu();
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                atm.performTransaction(choice, scanner);
            }
        } else {
            System.out.println("Invalid user ID or PIN. Exiting.");
        }
    scanner.close();
    }
}
