package org.example;

import java.util.List;
import java.util.Scanner;

import static org.example.FileManager.loadTransactions;

public class Application {
    private Ledger ledger;
    public Application(){
        ledger = new Ledger();
        loadTransactions();
    }
    private void loadTransactions(){
        ledger.getTransactions().addAll(FileManager.loadTransactions());
    }
    public void run(){
        Scanner scanner = new Scanner(System.in);
        char choice;

        do{
            displayHomeScreen();
            choice = scanner.next().charAt(0);
            scanner.nextLine();

            switch (Character.toUpperCase(choice)){
                case 'D':
                    addDeposit(scanner);
                    break;
                case 'P':
                    makePayment(scanner);
                    break;
                case 'L':
                    displayLedger();
                    break;
                case 'X':
                    System.out.println("Exiting the application...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while(Character.toUpperCase(choice) != 'X');
    }
    private void displayHomeScreen() {
        System.out.println("Welcome to the Financial Transaction Tracker!");
        System.out.println("Choose an option:");
        System.out.println("D) Add Deposit");
        System.out.println("P) Make Payment (Debit)");
        System.out.println("L) Ledger");
        System.out.println("X) Exit");
        System.out.print("Enter your choice: ");
    }
    private void addDeposit(Scanner scanner) {
        System.out.print("Enter date (YYYY-MM-DD HH:MM:SS): ");
        String date = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter vendor: ");
        String vendor = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        Transaction transaction = new Transaction(date, description, vendor, amount);
        ledger.addTransaction(transaction);
        FileManager.saveTransaction(transaction);
        System.out.println("Deposit added successfully!");
    }
    private void makePayment(Scanner scanner) {
        System.out.print("Enter date (YYYY-MM-DD HH:MM:SS): ");
        String date = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter vendor: ");
        String vendor = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        Transaction transaction = new Transaction(date, description, vendor, -amount);
        ledger.addTransaction(transaction);
        FileManager.saveTransaction(transaction);
        System.out.println("Payment made successfully!");
    }
    private void displayLedger() {
        List<Transaction> transactions = ledger.getTransactions();
        System.out.println("Ledger:");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}

