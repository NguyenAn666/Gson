package com.example.entity;

import java.util.Scanner;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private double mark;

    public Student() {
    }

    public Student(int id, String firstName, String lastName, double mark) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mark = mark;
    }

    public void scanInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID: ");
        this.id = scanner.nextInt();
        System.out.println("Enter first name: ");
        this.firstName = scanner.nextLine();
        System.out.println("Enter last name: ");
        this.lastName = scanner.nextLine();
        System.out.println("Enter Mark: ");
        this.mark = scanner.nextDouble();
    }

    public void printINfo() {
        System.out.printf("%3d|%10s%10s|%5f\n", this.getId(), this.getFirstName(), this.getLastName(), this.getMark());
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getId() {
        return this.id;
    }

    public double getMark() {
        return this.mark;
    }
}
