package br.com.sgsistemas.cadastroclientes.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private LocalDate datanasc;
    private Double limite;
    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos;

    public Cliente(String nome, LocalDate datanasc, Double limite) {
        this.nome = nome;
        this.datanasc = datanasc;
        this.limite = limite;
    }

    public Cliente() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(LocalDate datanasc) {
        this.datanasc = datanasc;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public String toString() {
        return  id + " - " + nome + " (Data Nasc.: " + datanasc + ", Limite: " + limite + ") \n" + enderecos;
    }
}
