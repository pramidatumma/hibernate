package com.Hibernate.studentdemo;

import com.Hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Student.class)
            .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try{
//            session.beginTransaction();
//
//            Student myStudent = session.get(Student.class, 4);
//            session.delete(myStudent);
//            session.getTransaction().commit();

            session.beginTransaction();
            session.createQuery("delete Student  where id=5").executeUpdate();
            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
