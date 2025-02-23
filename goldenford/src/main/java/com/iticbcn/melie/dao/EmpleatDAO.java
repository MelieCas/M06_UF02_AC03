package com.iticbcn.melie.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.iticbcn.melie.model.Empleat;

public class EmpleatDAO extends GenDAOImpl<Empleat> {
    
    private SessionFactory sessionFactory;

    public EmpleatDAO(SessionFactory sessionFactory) {
        super(sessionFactory, Empleat.class); 

    }

}
