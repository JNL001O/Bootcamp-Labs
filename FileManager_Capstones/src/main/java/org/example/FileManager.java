package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private static final String FILE_NAME = "transactions.csv";
    public static void saveTransaction(Transaction transaction){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))){
           writer.write(transaction.toString());
           writer.newLine();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static List<Transaction> loadTransactions(){
        List<Transaction> transactions = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
           String line;
           while((line = reader.readLine()) != null){
               String[] parts = line.split("\\|");
               transactions.add(new Transaction(parts[0], parts[1], parts[2], Double.parseDouble(parts[4])));
           }
        }catch (IOException e){
            e.printStackTrace();
        }
        return transactions;
    }
}
