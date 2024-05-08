package org.example;

public class Transaction {
    private String date;
    private String time;
    private String description;
    private String vendor;
    private double amount;


    public Transaction(String date, String time, String description, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }
    //getter and setter methods
    public String getDate(){
        return date;
    }
    public String setTime(){
        return time;
    }
    public String getDescription(){
        return description;
    }

    public String getVendor() {
        return vendor;
    }

    public double getAmount() {
        return amount;
    }

    //toString method to represent the transaction as a string
    public String toString(){
        return date + " | " + time + " | " + description + " | " + vendor + " | " + amount;
    }
}
