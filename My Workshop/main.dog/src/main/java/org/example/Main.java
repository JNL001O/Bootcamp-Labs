package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //instantiate the Scanner
        Scanner scanner = new Scanner(System.in);

        Dog fido = new Dog("black", "German Shepherd", 2, 3.5);
        Dog bandit = new Dog("orange", "Golden Retriever", 5, 4.5);

        fido.bark();
        bandit.bark();
    }
}