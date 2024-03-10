package br.upe.util;

import br.upe.entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class DAOEmployee {

    public DAOEmployee() {
    }

    public static List<Employee> read(){
        EntityManager em = JPAUtil.getEntityManager();

        Query q = em.createQuery("select a from Employee a", Employee.class);
        List<Employee> employees = q.getResultList();

        em.close();

        return employees;
    }

}
