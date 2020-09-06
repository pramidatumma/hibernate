package com.Hibernate.studentdemo;

import com.Hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Student.class)
            .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            int studentId = 1;
            session.beginTransaction();
            System.out.println("Getting student with id"+studentId);
            Student myStudent = session.get(Student.class, studentId);
            System.out.println("Get Complete"+myStudent);

            System.out.println("\n Updating...\n");
            myStudent.setFirstName("Scooby");

            session.getTransaction().commit();

            //Update emails
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("update Student set email='aaron@email.com' where id=2").executeUpdate();

            session.getTransaction().commit();


        } finally {
            sessionFactory.close();
        }

    }
}
