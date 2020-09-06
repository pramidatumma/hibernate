package com.Hibernate.studentdemo;

import com.Hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetStudentDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Student.class)
            .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            Student student = new Student("Bat", "Man", "batman@mail.com");
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            System.out.println("Saving is done for student ID: "+ student.getId());

            //Get the student
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Student myStudent = session.get(Student.class, student.getId());
            System.out.println("We got the student"+ myStudent);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }
}

