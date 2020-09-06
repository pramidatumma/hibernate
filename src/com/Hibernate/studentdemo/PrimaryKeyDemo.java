package com.Hibernate.studentdemo;

import com.Hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class PrimaryKeyDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
            .configure()
            .addAnnotatedClass(Student.class)
            .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            Student student1 = new Student("Ada", "Lovelave", "charles@mail.com");
            Student student2 = new Student("aaron", "swartz", "charles@mail.com");
            Student student3 = new Student("john", "lucky", "charles@mail.com");

            session.beginTransaction();

            System.out.println("Saving the students");
            session.save(student1);
            session.save(student2);
            session.save(student3);

            session.getTransaction().commit();
            System.out.println("Saving is done");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
