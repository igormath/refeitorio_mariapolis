package br.upe.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("centro_mariapolis");

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    public static void closeConnection(){
        emf.close();
    }
}
