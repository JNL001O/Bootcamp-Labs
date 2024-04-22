package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    public Book(int id, String isbn, String title){
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }
    public int getId(){
        return id;
    }
    public String getIsbn(){
        return isbn;
    }
    public String getTitle(){
        return title;
    }
    public boolean isCheckedOut(){
        return isCheckedOut;
    }
    public String getCheckedOutTo(){
        return checkedOutTo;
    }
    public void checkOut(String name){
        if(!isCheckedOut){
            isCheckedOut = true;
            checkedOutTo = name;
        } else {
            System.out.println("This book is already checked out.");
        }

    }
    public void checkIn(){
        if (isCheckedOut){
            isCheckedOut = false;
            checkedOutTo = "";
        } else {
            System.out.println("This book is already checked in.");
        }

    }
}