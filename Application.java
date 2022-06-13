package com.example.model;

import com.example.entity.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    private static Scanner input;
    private static StudentList list;

    public Application() {
    }

    public static void menu() {
        System.out.println("1. Add a new student to the list");
        System.out.println("2. Delete a student from the list");
        System.out.println("3. Search by name");
        System.out.println("4. Search by id");
        System.out.println("5. Print student info in descending order of mark");
        System.out.println("6. Exit");
    }

    public static void main(String[] args) {
        list = new StudentList();
        menu();

        while(true) {
            while(true) {
                System.out.println("#: ");
                int choice = input.nextInt();
                if (choice == 1) {
                    addStudent();
                    menu();
                } else if (choice == 2) {
                    deleteStudent();
                    menu();
                } else if (choice == 3) {
                    searchById();
                    menu();
                } else if (choice == 4) {
                    printSorted();
                    menu();
                } else if (choice == 6) {
                    System.exit(0);
                }
            }
        }
    }

    public static void addStudent() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter student ID: ");
        int id = input.nextInt();
        System.out.println("Enter first name: ");
        String fn = input.next();
        System.out.println("Enter last name: ");
        String ln = input.next();
        System.out.println("Enter mark: ");
        double mark = input.nextDouble();
        Student s = new Student(id, fn, ln, mark);
        list.add(s);
    }

    public static void deleteStudent() {
        System.out.println("Enter student id: ");
        int id = input.nextInt();
        list.remove(id);
    }

    public static void searchByName() {
        System.out.println("Enter a name: ");
        String name = input.next();
        ArrayList<Student> found = list.findByName(name);
        list.showList(found);
    }

    public static void searchById() {
        System.out.println("Enter an ID: ");
        int id = input.nextInt();
        Student s = list.findById(id);
        if (s == null) {
            System.out.println("Not null");
        } else {
            s.printINfo();
        }

    }

    public static void printSorted() {
        list.sortByMarks();
        list.showList();
    }

    static {
        input = new Scanner(System.in);
    }
}
