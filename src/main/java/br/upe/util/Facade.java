package br.upe.util;

import br.upe.entities.Customer;
import br.upe.entities.Employee;
import br.upe.repository.DAOCustomer;
import br.upe.repository.DAOEmployee;

import java.util.List;

public class Facade {

    private final DAOCustomer customerDAO;
    private final DAOEmployee employeeDAO;

    public Facade() {
        this.customerDAO = new DAOCustomer();
        this.employeeDAO = new DAOEmployee();
    }

    public List<Customer> getAllCustomers(){
        return DAOCustomer.read();
    }

    public void createCustomer(Customer customer){
        DAOCustomer.create(customer);
    }

    public void updateCustomer(Customer customer){
        DAOCustomer.update(customer);
    }
    public void deleteCustomer(Customer customer){
        DAOCustomer.delete(customer);
    }

    public List<Employee> getAllEmployees(){
        return DAOEmployee.read();
    }
}
