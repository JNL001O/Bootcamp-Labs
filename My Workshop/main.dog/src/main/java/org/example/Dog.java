package org.example;

public class Dog {
    //properties (in Java they're called fields)
    private String furColor;
    private String breed;
    private int age;
    private double size;

    //constructor
    public Dog(String furColor, String breed, int age, double size){
        this.furColor = furColor;
        this.breed = breed;
        this.age = age;
        this.size = size;
    }

    //behaviors (methods/functions)
    public void bark(){
        System.out.println("Woof!");
    }
}
