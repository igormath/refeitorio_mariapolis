package br.upe.repository;

import br.upe.entities.Event;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAOEvent {

    public DAOEvent() {
    }

    // Usa o padrão Factory para criar um gerenciador de entidade
    private EntityManager getEntityManager() {
        EntityManagerFactory factory = null;
        EntityManager entityManager = null;
        try {
            factory = Persistence.createEntityManagerFactory("centro_mariapolis");
            entityManager = factory.createEntityManager();
        } finally {
            factory.close();
        }
        return entityManager;
    }

    public Event createOrUpdate(Event event) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            System.out.println("Inserindo o evento: " + event.getNome());

            if (event.getId() == null) {
                em.persist(event);
            } else {
                event = em.merge(event);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return event;
    }

    public void delete(Event event) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Event foundEvent = findById(event.getId());
            System.out.println("Deletando o evento: " + foundEvent.getNome());
            em.remove(foundEvent);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Event findById(Long id_event) throws Exception {
        EntityManager em = getEntityManager();
        Event event = null;
        try {
            event = em.find(Event.class, id_event);
        } catch (Exception e) {
            throw new Exception("Id not found");
        } finally {
            em.close();
        }
        return event;
    }
}
