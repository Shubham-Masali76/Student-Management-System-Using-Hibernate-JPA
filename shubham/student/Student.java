package com.shubham.student;

import jakarta.persistence.*;

@Entity
@Table(name = "students")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    private String course;
    private int marks;
    private String email;
    private String phone;

    public Student() {}

    public Student(String name, String course, int marks, String email, String phone) {
        this.name = name;
        this.course = course;
        this.marks = marks;
        this.email = email;
        this.phone = phone;
    }

    public int getId() { 
        return id; 
    }

    public String getName() { 
        return name; 
    }

    public void setName(String name) { 
        this.name = name; 
    }

    public String getCourse() { 
        return course; 
    }

    public void setCourse(String course) { 
        this.course = course; 
    }

    public int getMarks() { 
        return marks; 
    }

    public void setMarks(int marks) { 
        this.marks = marks; 
    }

    public String getEmail() { 
        return email; 
    }

    public void setEmail(String email) { 
        this.email = email; 
    }

    public String getPhone() { 
        return phone; 
    }

    public void setPhone(String phone) { 
        this.phone = phone; 
    }
}
