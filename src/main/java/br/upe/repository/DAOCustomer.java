package br.upe.repository;

import br.upe.entities.Customer;
import br.upe.util.JPAUtil;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class DAOCustomer {

    public DAOCustomer() {
    }

    public Customer createOrUpdate(Customer customer) throws Exception {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            System.out.println("Inserindo o cliente: " + customer.getCpf());

            if (customer.getId() == null) {
                em.persist(customer);
            } else {
                customer = em.merge(customer);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return customer;
    }

    public void delete(Customer customer) throws Exception {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Customer foundCustomer = findById(customer.getId());
            System.out.println("Deletando o cliente: " + foundCustomer.getCpf());
            em.remove(foundCustomer);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Customer findById(Long id_customer) throws Exception {
        EntityManager em = JPAUtil.getEntityManager();
        Customer customer = null;
        try {
            customer = em.find(Customer.class, id_customer);
        } catch (Exception e) {
            throw new Exception("Id not found");
        } finally {
            em.close();
        }
        return customer;
    }

    public static List<Customer> read() {
        EntityManager em = JPAUtil.getEntityManager();

        List<Customer> customers = null;

        try {
            System.out.println("Buscando todos os clientes");
            TypedQuery<Customer> query = em.createQuery("select c from Customer c", Customer.class);
            customers = query.getResultList();
        } finally {
            em.close();
        }
        return customers;
    }
}
