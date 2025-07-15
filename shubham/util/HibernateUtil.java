package com.shubham.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtil {
    
    private static final String PERSISTENCE_UNIT_NAME = "student-unit";
    private static final EntityManagerFactory emf;
    
    static {
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    public static void closeFactory() {
        if(emf != null && emf.isOpen())
            emf.close();
    }
}

