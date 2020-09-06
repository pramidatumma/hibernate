package com.Hibernate.studentdemo;

import com.Hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Student.class)
            .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            List<Student> studentList = session.createQuery("from Student").getResultList();



            printStudents(studentList);
            List<Student> lastStudentList = session.createQuery("from Student s where s.lastName='Man'").getResultList();
            System.out.println("Students with last name of Man");
            printStudents(lastStudentList);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }
        }

    private static void printStudents(List<Student> studentList) {
        for(Student student: studentList) {
            System.out.println(student);
        }
    }
}
