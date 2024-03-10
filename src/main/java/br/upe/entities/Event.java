package br.upe.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "event")
public class Event {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_event_generator")
  @SequenceGenerator(name = "id_event_generator", sequenceName = "id_event_seq", allocationSize = 1)
  @Column(name = "id_event")
  private Long id;

  @Column(length = 100, nullable = false)
  private String nome;

  @Column(length = 20)
  private String tipo;

  @Column(name = "data_inicio")
  private Date dataInicio;

  @Column(name = "data_fim")
  private Date dataFim;

  @Column(name = "organizador_nome", length = 100)
  private String organizadorNome;

  @Column(name = "organizador_telefone", length = 20)
  private String organizadorTelefone;

  @ManyToOne
  @JoinColumn(name = "id_employee", nullable = false)
  private Employee employee;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public Date getDataInicio() {
    return dataInicio;
  }

  public void setDataInicio(Date dataInicio) {
    this.dataInicio = dataInicio;
  }

  public Date getDataFim() {
    return dataFim;
  }

  public void setDataFim(Date dataFim) {
    this.dataFim = dataFim;
  }

  public String getOrganizadorNome() {
    return organizadorNome;
  }

  public void setOrganizadorNome(String organizadorNome) {
    this.organizadorNome = organizadorNome;
  }

  public String getOrganizadorTelefone() {
    return organizadorTelefone;
  }

  public void setOrganizadorTelefone(String organizadorTelefone) {
    this.organizadorTelefone = organizadorTelefone;
  }

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }
}
