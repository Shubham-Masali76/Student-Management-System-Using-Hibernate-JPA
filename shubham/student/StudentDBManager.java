package com.shubham.student;

import jakarta.persistence.*;
import java.util.List;

import com.shubham.util.HibernateUtil;

public class StudentDBManager {
    private EntityManager em;

    public StudentDBManager() {
            this.em = HibernateUtil.getEntityManagerFactory().createEntityManager();
    }

    public void addStudent(Student s) {
        EntityTransaction tx = em.getTransaction();
        
        try {

            tx.begin();
            em.persist(s);
            tx.commit();
            System.out.println("Student added successfully.");
            StudentDBLogger.run("Student added: " + s.getName());

        } catch (Exception e) {
            if (tx.isActive())
                tx.rollback();
            
            StudentDBLogger.run("Failed to add student: " + e.getMessage());
            e.printStackTrace();

        } finally {
            em.close();
        }
    }

    public List<Student> getAllStudents() {
        List<Student> students = em.createQuery("FROM Student", Student.class).getResultList();
        StudentDBLogger.run("Retrieved all students from DB.");
        return students;
    }

    public Student getStudentById(int id) {
        Student s = em.find(Student.class, id);
        StudentDBLogger.run(s != null ? "Student found by ID: " + id : "Student not found for ID: " + id);
        return s;
    }

    public void updateStudent(Student s) {
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(s);
            tx.commit();
            System.out.println("Student updated.");
            StudentDBLogger.run("Updated student ID: " + s.getId());

        } catch (Exception e) {
            if (tx.isActive()) 
                tx.rollback();
            
            StudentDBLogger.run("Failed to update student: " + e.getMessage());
            e.printStackTrace();

        } finally {
            em.close();
        }
    }

    public void deleteStudent(int id) {
        EntityTransaction tx = em.getTransaction();

        try {
            Student s = em.find(Student.class, id);

            if (s != null) {
                tx.begin();
                em.remove(s);
                tx.commit();
                System.out.println("Student deleted.");
                StudentDBLogger.run("Deleted student ID: " + id);
            } 
            
            else {
                System.out.println("Student not found.");
                StudentDBLogger.run("Attempted to delete non-existent student ID: " + id);
            }

        } catch (Exception e) {
            if (tx.isActive()) 
                tx.rollback();
            
            StudentDBLogger.run("Failed to delete student: " + e.getMessage());
            e.printStackTrace();

        } finally {
            em.close();
        }
    }
}
