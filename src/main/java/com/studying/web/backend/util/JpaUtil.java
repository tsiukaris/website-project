package com.studying.web.backend.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

    private static final EntityManagerFactory emFactory;

    static {
        try {
            emFactory = Persistence.createEntityManagerFactory("1");
            System.out.println("entity manager factory created");
        } catch (Throwable ex) {
            System.out.println("em factory failed to create");
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManagerFactory getEmFactory(){ return emFactory; }
}
