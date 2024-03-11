package br.upe.util;

import br.upe.entities.Customer;

public class CustomerModel {
    private static CustomerModel instance;
    private Customer customer;

    public CustomerModel() {
    }

    public static CustomerModel getInstance(){
        if (instance == null){
            instance = new CustomerModel();
        }
        return instance;
    }

    public static void setInstance(CustomerModel instance) {
        CustomerModel.instance = instance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
