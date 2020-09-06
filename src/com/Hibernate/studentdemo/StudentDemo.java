package com.Hibernate.studentdemo;

import com.Hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Student.class)
            .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            Student student = new Student("Charles", "Babbbage", "charles@mail.com");
            session.beginTransaction();
            System.out.println("Saving the student");
            session.save(student);
            session.getTransaction().commit();
            System.out.println("Saving is done");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
