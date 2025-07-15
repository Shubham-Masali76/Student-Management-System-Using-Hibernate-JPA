package com.shubham.student;

import java.util.List;
import java.util.Scanner;

public class MenuApp {
    public static void main(String[] args) {
        StudentDBManager db = new StudentDBManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    
                    System.out.print("Course: ");
                    String course = sc.nextLine();
                    
                    System.out.print("Marks: ");
                    int marks = sc.nextInt();
                    sc.nextLine();
                    
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    
                    System.out.print("Phone: ");
                    String phone = sc.nextLine();

                    db.addStudent(new Student(name, course, marks, email, phone));
                }

                case 2 -> {
                    System.out.println("ID | Name | Course | Marks | Email | Phone");
                    List<Student> students = db.getAllStudents();
                    students.forEach(s -> System.out.printf("%d | %s | %s | %d | %s | %s%n",
                        s.getId(), s.getName(), s.getCourse(), s.getMarks(), s.getEmail(), s.getPhone()));
                }

                case 3 -> {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    
                    Student s = db.getStudentById(id);
                    
                    if (s != null) 
                        System.out.println(s.getName());
                    else 
                        System.out.println("Not Found");
                }

                case 4 -> {
                    System.out.print("Enter ID to update: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    
                    Student s = db.getStudentById(id);
                    
                    if (s != null) {
                        System.out.print("New Name: ");
                        s.setName(sc.nextLine());
                    
                        System.out.print("New Course: ");
                        s.setCourse(sc.nextLine());
                    
                        System.out.print("New Marks: ");
                        s.setMarks(sc.nextInt());
                        sc.nextLine();
                    
                        System.out.print("New Email: ");
                        s.setEmail(sc.nextLine());
                    
                        System.out.print("New Phone: ");
                        s.setPhone(sc.nextLine());
                    
                        db.updateStudent(s);
                    
                    } 
                    
                    else 
                        System.out.println("Student not found");
                }

                case 5 -> {
                    System.out.print("Enter ID to delete: ");
                    db.deleteStudent(sc.nextInt());
                }

                case 6 -> {
                    System.out.println("Thank You for using the Student Management System! Have a great day!");
                    System.out.println("Exiting...");
                    StudentDBLogger.run("Application exited.");
                }

                default -> 
                    System.out.println("Invalid choice");
            }

        } while (choice != 6);

        sc.close();
    }
}
