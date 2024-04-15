package org.example;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Accept the initial deposit, interest rate, and number of years from the user
        System.out.println("Enter the initial deposit: ");
        float initialDeposit = scanner.nextFloat();
        System.out.println("Enter the annual interest rate(in percentage): ");
        float annualInterestRate = scanner.nextFloat();
        System.out.println("Enter the number of years: ");
        byte numberOfYears = scanner.nextByte();

        scanner.close();

        //Calculate the daily interest rate
        double dailyInterest = annualInterestRate / 36500;
        int numberOfCompoundsPerYear = 365;
        double futureValue = initialDeposit * Math.pow((1+ dailyInterest),numberOfCompoundsPerYear * numberOfYears);
        double totalInterestEarned = futureValue - initialDeposit;


        //Display the future value and total interest earned

        System.out.printf("\nFuture value of the deposit: $%.2f\n", futureValue);
        System.out.printf("The total interest earned: $%.2f\n", totalInterestEarned);

        scanner.close();


    }
}