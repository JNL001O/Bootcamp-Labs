package org.example;

import java.util.Scanner;




public class Main {
    public static void main(String[] args) {
        //Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the principal amount:");
        double principal = scanner.nextDouble();
        System.out.print("Enter the annual interest rate (in percentage):");
        double annualInterestRate = scanner.nextDouble();
        System.out.print("Enter the loanLeangth in years:");
        int loanLengthyears = scanner.nextInt();


        //Calculate the monthly interest rate
        double monthlyInterestRate = (annualInterestRate / 12) / 100;
        int numberOfPayments = loanLengthyears * 12;


        double monthlyPayment = (principal * monthlyInterestRate) /
                (1- Math.pow(1+ monthlyInterestRate, - numberOfPayments));


        //Calculate the monthly payment
        double totalInterestpaid = (monthlyPayment * numberOfPayments) - principal;

        System.out.printf("The expected monthly payment is $%.2f\n", monthlyPayment);
        System.out.printf("The total interest paid is $%.2f\n", totalInterestpaid);

        scanner.close();

    }
}