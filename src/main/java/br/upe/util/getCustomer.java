package br.upe.util;

import br.upe.entities.Customer;

import java.util.List;

public class getCustomer {
    public static Customer getCustomerByCpf(List<Customer> customers, String cpf){
        for (Customer customer : customers) {
            if (customer.getCpf().equals(cpf)){
                return customer;
            }
        }
        return null;
    }
}
