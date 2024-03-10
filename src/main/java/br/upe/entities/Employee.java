package br.upe.entities;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_employee;
    private String name_employee;
    private String cpf;
    private String email;
    private String pass;

    public Employee() {
    }

    public Employee(Long id_employee, String name_employee, String cpf, String email, String pass) {
        this.id_employee = id_employee;
        this.name_employee = name_employee;
        this.cpf = cpf;
        this.email = email;
        this.pass = pass;
    }

    public Long getId_employee() {
        return id_employee;
    }

    public void setId_employee(Long id_employee) {
        this.id_employee = id_employee;
    }

    public String getName() {
        return name_employee;
    }

    public void setName(String name_employee) {
        this.name_employee = name_employee;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
