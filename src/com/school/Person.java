package com.school;

public abstract class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void displayDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
    }
}
