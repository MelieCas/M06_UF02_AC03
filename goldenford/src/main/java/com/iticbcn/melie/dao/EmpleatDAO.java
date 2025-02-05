package com.iticbcn.melie.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.iticbcn.melie.models.Empleat;

public class EmpleatDAO {
    
    private SessionFactory sessionFactory;

    public EmpleatDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }

    public Empleat getEmpleat(int empleatId) {
        Empleat empleat = null;

        try (Session session = sessionFactory.openSession()) {
            empleat = session.find(Empleat.class, empleatId);
        } catch (HibernateException e) {
            System.err.println("Error en Hibernate: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        } 

        return empleat;

    }

    public void createEmpleat(Empleat empleat) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            try {
                 session.persist(empleat);
                 session.getTransaction().commit();            
            } catch (HibernateException e) {
                if (session.getTransaction() != null) {
                    session.getTransaction().rollback();
                    System.err.println("Error en Hibernate: " + e.getMessage()); 
                }
            } catch (Exception e) {
                if (session.getTransaction()  != null) {
                    session.getTransaction().rollback();
                    System.err.println("Error inesperado: " + e.getMessage());
                }

           }
        }
    }
}
