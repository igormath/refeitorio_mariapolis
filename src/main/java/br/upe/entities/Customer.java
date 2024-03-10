package br.upe.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_customer_generator")
    @SequenceGenerator(name = "id_customer_generator", sequenceName = "id_customer_seq", allocationSize = 1)
    @Column(name = "id_customer")
    private Long id;

    @Column(length = 20, nullable = false)
    private String cpf;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(name = "data_nascimento")
    private Date dataNascimento;

    @Column(length = 100)
    private String email;

    @Column(length = 20)
    private String telefone;

    @Column(length = 10)
    private String sexo;

    @Column(length = 15)
    private String cep;

    @Column(name = "saldo_cafe", precision = 5, scale = 2)
    private BigDecimal saldo_cafe;

    @Column(name = "saldo_almoco", precision = 5, scale = 2)
    private BigDecimal saldo_almoco;

    @Column(name = "saldo_jantar", precision = 5, scale = 2)
    private BigDecimal saldo_jantar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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

    public BigDecimal getSaldo_cafe() {
        return saldo_cafe;
    }

    public void setSaldo_cafe(BigDecimal saldo_cafe) {
        this.saldo_cafe = saldo_cafe;
    }

    public BigDecimal getSaldo_almoco() {
        return saldo_almoco;
    }

    public void setSaldo_almoco(BigDecimal saldo_almoco) {
        this.saldo_almoco = saldo_almoco;
    }

    public BigDecimal getSaldo_jantar() {
        return saldo_jantar;
    }

    public void setSaldo_jantar(BigDecimal saldo_jantar) {
        this.saldo_jantar = saldo_jantar;
    }
}
