package br.upe.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_customer;
    private String cpf;
    private String name_customer;
    private Date data_nascimento;
    private String email;
    private String phone;
    private String sexo;
    private String cep;
    @Column(precision = 10, scale = 2)
    private Double saldo;

    public Customer() {
    }

    public Customer(Long id_customer, String cpf, String name_customer, Date data_nascimento, String email, String phone, String sexo, String cep, Double saldo) {
        this.id_customer = id_customer;
        this.cpf = cpf;
        this.name_customer = name_customer;
        this.data_nascimento = data_nascimento;
        this.email = email;
        this.phone = phone;
        this.sexo = sexo;
        this.cep = cep;
        this.saldo = saldo;
    }

    public Long getId_customer() {
        return id_customer;
    }

    public void setId_customer(Long id_customer) {
        this.id_customer = id_customer;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name_customer;
    }

    public void setName(String name_customer) {
        this.name_customer = name_customer;
    }

    public Date getDataNascimento() {
        return data_nascimento;
    }

    public void setDataNascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public void deductMealCost(){
        saldo -= 10;
    }
}
