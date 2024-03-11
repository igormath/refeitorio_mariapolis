package br.upe.util;

import br.upe.entities.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class FacadeTest {

    private EntityManagerFactory emf;
    private EntityManager em;

    @BeforeEach
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("centro_mariapolis");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    @AfterEach
    public void tearDown() {
        em.getTransaction().rollback();
        em.close();
        emf.close();
    }

    @Test
    public void testCreateCustomer() {
        // Crie um objeto Customer para teste
        Customer customer = new Customer();
        customer.setCpf("123.456.789-00");
        customer.setName("John Doe");
        customer.setDataNascimento(new Date());
        customer.setEmail("john.doe@example.com");
        customer.setPhone("123456789");
        customer.setSexo("M");
        customer.setCep("12345-678");
        customer.setSaldo(100.0);

        // Chame o método createCustomer
        Facade facade = new Facade();
        facade.createCustomer(customer);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String expectedDate = sdf.format(customer.getDataNascimento());

        // Verifique se o objeto foi persistido no banco de dados
        Customer savedCustomer = em.find(Customer.class, customer.getId_customer());
        assertNotNull(savedCustomer);
        assertEquals(customer.getCpf(), savedCustomer.getCpf());
        assertEquals(customer.getName(), savedCustomer.getName());
        assertEquals(expectedDate, sdf.format(savedCustomer.getDataNascimento()));
        assertEquals(customer.getEmail(), savedCustomer.getEmail());
        assertEquals(customer.getPhone(), savedCustomer.getPhone());
        assertEquals(customer.getSexo(), savedCustomer.getSexo());
        assertEquals(customer.getCep(), savedCustomer.getCep());
        assertEquals(customer.getSaldo(), savedCustomer.getSaldo());
    }
}