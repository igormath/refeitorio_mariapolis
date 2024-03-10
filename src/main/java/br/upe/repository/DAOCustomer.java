package br.upe.util;

import br.upe.entities.Customer;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class DAOCustomer {

    public DAOCustomer() {
    }

    public static List<Customer> read(){
        EntityManager em = JPAUtil.getEntityManager();

        Query q = em.createQuery("select a from Customer a", Customer.class);
        List<Customer> customers = q.getResultList();

        em.close();

        return customers;
    }
}
