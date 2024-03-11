package br.upe.repository;

import br.upe.entities.Customer;
import br.upe.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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

    public static void create(Customer customer){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(customer);
        tx.commit();

        em.close();
    }

    public static void update(Customer customer){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(customer);
            tx.commit();
        } catch (Exception e){
            if (tx != null && tx.isActive()){
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void delete(Customer customer){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Customer managedCustomer = em.find(Customer.class, customer.getId_customer());
            if (managedCustomer != null){
                em.remove(managedCustomer);
                tx.commit();
            }
        } catch (Exception e){
            if (tx != null && tx.isActive()){
                tx.rollback();
            }
            e.printStackTrace();
        }
    }
}
