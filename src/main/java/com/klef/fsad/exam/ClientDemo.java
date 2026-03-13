package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class ClientDemo {

    public static void main(String[] args) {

        // Build SessionFactory from hibernate.cfg.xml
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();

        // ─────────────────────────────────────────
        // I. Insert a new Course record
        // ─────────────────────────────────────────
        Session insertSession = sf.openSession();
        Transaction tx = null;

        try {
            tx = insertSession.beginTransaction();

            Course course = new Course();
            course.setName("Full Stack Application Development");
            course.setDescription("A comprehensive course covering frontend and backend technologies.");
            course.setDate(new Date());
            course.setStatus("Active");
            course.setInstructor("Dr. Ramesh Kumar");
            course.setDuration(60);
            course.setCategory("Engineering");

            insertSession.save(course);
            tx.commit();

            System.out.println("Record inserted successfully! Generated ID: " + course.getId());

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            insertSession.close();
        }

        // ─────────────────────────────────────────
        // II. View the record based on the ID
        // ─────────────────────────────────────────
        Session viewSession = sf.openSession();

        try {
            // Retrieve the record with ID = 1
            // (Change the ID value below as needed)
            int searchId = 1;

            Course retrievedCourse = (Course) viewSession.get(Course.class, searchId);

            if (retrievedCourse != null) {
                System.out.println("\n--- Course Record (ID=" + searchId + ") ---");
                System.out.println("ID          : " + retrievedCourse.getId());
                System.out.println("Name        : " + retrievedCourse.getName());
                System.out.println("Description : " + retrievedCourse.getDescription());
                System.out.println("Date        : " + retrievedCourse.getDate());
                System.out.println("Status      : " + retrievedCourse.getStatus());
                System.out.println("Instructor  : " + retrievedCourse.getInstructor());
                System.out.println("Duration    : " + retrievedCourse.getDuration() + " hours");
                System.out.println("Category    : " + retrievedCourse.getCategory());
            } else {
                System.out.println("No record found for ID: " + searchId);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            viewSession.close();
        }

        sf.close();
        System.out.println("\nHibernate session closed. Done!");
    }
}
