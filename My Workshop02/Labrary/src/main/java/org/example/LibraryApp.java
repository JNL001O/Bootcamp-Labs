package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryApp {
    private static ArrayList<Book>inventory = new ArrayList<>();
    public static void main(String[] arg){
        intializeInventory();
        showHomeScreen();
    }
    private static void intializeInventory(){
        //Adding 20 sample books to the inventory
       // Adding 20 books to the inventory
        inventory.add(new Book(1, "9780141439600", "Pride and Prejudice"));
        inventory.add(new Book(2, "9780061120084", "To Kill a Mockingbird"));
        inventory.add(new Book(3, "9780451524935", "1984"));
        inventory.add(new Book(4, "9780743273565", "The Great Gatsby"));
        inventory.add(new Book(5, "9781451673319", "The Catcher in the Rye"));
        inventory.add(new Book(6, "9780060850524", "The Hobbit"));
        inventory.add(new Book(7, "9780143111597", "Moby-Dick"));
        inventory.add(new Book(8, "9780141439792", "Jane Eyre"));
        inventory.add(new Book(9, "9780553212471", "War and Peace"));
        inventory.add(new Book(10, "9780449212606", "Crime and Punishment"));
        inventory.add(new Book(11, "9780486415871", "Alice's Adventures in Wonderland"));
        inventory.add(new Book(12, "9780141439471", "Wuthering Heights"));
        inventory.add(new Book(13, "9781593080279", "Anna Karenina"));
        inventory.add(new Book(14, "9780486270523", "Dracula"));
        inventory.add(new Book(15, "9780486282113", "Frankenstein"));
        inventory.add(new Book(16, "9780141439563", "Sense and Sensibility"));
        inventory.add(new Book(17, "9780141192462", "The Picture of Dorian Gray"));
        inventory.add(new Book(18, "9780486284735", "Les Misérables"));
        inventory.add(new Book(19, "9780452284247", "Brave New World"));
        inventory.add(new Book(20, "9780486280614", "The Scarlet Letter"));
        }
    }
    private static void showHomeScreen(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Store Home Screen");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");

            int choice = scanner.nextInt();
            switch(choice){
                case 1:
                    showAvailableBooks(scanner);
                    break;
                case 2:
                    showCheckedOutBooks(scanner);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void showAvailableBooks(Scanner scanner){
        System.out.println("Available Books");
        for (Book book : inventory){
            if (!book.isCheckedOut()){
                System.out.println("ID: " + book.getId());
        System.out.println("Title: " + book.getTitle());
        System.out.println("ISBN: " + book.getIsbn());
        System.out.println("________");
            }
        }
        System.out.println("1. check Out a Book");
        System.out.println("2. Go back to Home Screen");
        System.out.println("Enter your choice: ");

        int choice = scanner.nextInt();
        switch(choice){
            case 1:
                checkOutBook(scanner);
                break;
            case 2:
                return;
            default:
        System.out.println("Invalid choice. Going back to Home Screen. ");

        }

    }
    private static void checkOutBook(Scanner scanner){
        System.out.println("Enter the ID of the book you want to check out: ");
        int bookId = scanner.nextInt();
        System.out.println("Enter you name: ");
        String name = scanner.next();

        for(Book book : inventory){
            if (book.getId() == bookId && !book.isCheckedOut()){
                book.checkOut(name);
        System.out.println(book.getTitle() + "has been checked out to " + name + ".");
        return;
            }
        }
        System.out.println("Book not found or already checked out.");
    }
    private static void showCheckedOutBooks(Scanner scanner){
        System.out.println("Checked Out Books");
        for (Book book : inventory){
            if(book.isCheckedOut()){
                System.out.println("ID: " + book.getId());

                System.out.println("Title: " + book.getTitle());
                System.out.println("ISBN: " + book.getIsbn());
                System.out.println("Checked Out To: " + book.getCheckedOutTo());
                System.out.println("_________");
            }
        }
        System.out.println("1. Check In a Book");
        System.out.println("2. Go back Home Screen");
        System.out.println("Enter your choice: ");
           int choice = scanner.nextInt();
           switch (choice){
               case 1:
                   checkInBook(scanner);
                   break;
               case 2:
                   return;
               default:
        System.out.println("Invalid choice Going back to Home Screen. ");
           }
    }
    private static void checkInBook(Scanner scanner){
        System.out.println("Enter to ID of the book you want to check in: ");

        for(Book book : inventory){
            if (book.getId() == book.getId() && book.isCheckedOut()){
                book.checkIn();
        System.out.println(book.getTitle() + "has been checked in.");
        return;
            }
        }
        System.out.println("Book not found or already checked in.");
    }
}
