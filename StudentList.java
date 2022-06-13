package com.example.model;

import codejava.Employee1;
import com.example.entity.Student;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jdk.jfr.FlightRecorder;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class StudentList {
    private ArrayList<Student> list = new ArrayList();
    private int length;

    public StudentList() {
        this.list.add(new Student(1, "Tran", "Phong", 8.1));
        this.list.add(new Student(2, "Tran", "Khanh", 8.2));
        this.list.add(new Student(3, "Manh", "An", 8.3));
        this.list.add(new Student(4, "Trung", "hieu", 8.4));
        this.list.add(new Student(5, "Nguyen1", "Nam", 8.5));
        this.list.add(new Student(6, "Nguyen2", "Tuan", 8.6));
        this.list.add(new Student(7, "Nguyen3", "Manh", 8.7));
        this.list.add(new Student(8, "Nguyen4", "Nhu", 8.8));
        this.list.add(new Student(9, "Nguyen5", "Dong", 8.9));
        this.list.add(new Student(10, "Nguyen6", "Tu", 9.0));
        this.list.add(new Student(11, "Nguyen7", "Dat", 9.1));
        this.list.add(new Student(12, "Nguyen8", "Linh", 9.2));
        this.list.add(new Student(13, "Nguyen9", "bang", 9.3));
        this.list.add(new Student(14, "Nguyen10", "le", 9.4));
        this.list.add(new Student(15, "Nguyen11", "dao", 9.5));
    }

    public  void getEmployee() throws IOException {
        Gson gson = new Gson();
        FileReader reader = new FileReader("employee.json");
        Employee1[] employees1 = gson.fromJson(reader, new TypeToken<List<Employee1>>() {
        }.getType());

        for (Employee1 c : employees1) {
            System.out.println(c);
        }
        reader.close();
    }

    public ArrayList<Student> findByName(String name) {
        boolean found = false;
        ArrayList<Student> matches = new ArrayList();
        Iterator var4 = this.list.iterator();

        while(var4.hasNext()) {
            Student s = (Student)var4.next();
            String var10002 = s.getFirstName();
            String fullName = (new String(var10002 + " " + s.getLastName())).toLowerCase();
            if (fullName.matches("(.*)" + name.toLowerCase() + "(.*)")) {
                matches.add(s);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Not found");
        }

        return matches;
    }

    public Student findById(int id) {
        Iterator var2 = this.list.iterator();

        Student s;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            s = (Student)var2.next();
        } while(s.getId() != id);

        return s;
    }

    public void add(Student s) {
        this.list.add(s);
    }

    public void remove(int id) {
        boolean found = false;
        Iterator var3 = this.list.iterator();

        while(var3.hasNext()) {
            Student s = (Student)var3.next();
            if (s.getId() == id) {
                System.out.println("Are you sure deleting this student? (1.Yes 2.No");
                int choice = (new Scanner(System.in)).nextInt();
                if (choice == 1) {
                    this.list.remove(s);
                }

                found = true;
            }
        }

        if (!found) {
            System.out.println("Can not find student with id " + id);
        }

    }

    public void sortMark() {
        Collections.sort(this.list, new Comparator<Student>() {
            public int compare(Student o1, Student o2) {
                if (o1.getMark() < o2.getMark()) {
                    return -1;
                } else {
                    return o1.getMark() > o2.getMark() ? 1 : 0;
                }
            }
        });
    }

    public void sortByMarks() {
    }

    public void showList() {
        Iterator var1 = this.list.iterator();

        while(var1.hasNext()) {
            Student s = (Student)var1.next();
            s.printINfo();
        }

    }

    public void showList(ArrayList<Student> slist) {
        Iterator var2 = slist.iterator();

        while(var2.hasNext()) {
            Student s = (Student)var2.next();
            s.printINfo();
        }

    }
}
