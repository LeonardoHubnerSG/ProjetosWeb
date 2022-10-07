package br.com.sgsistemas.devsg.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @ManyToOne
    private Equipe equipe;

    public Produto(String nome, Equipe equipe) {
        this.nome = nome;
        this.equipe = equipe;
    }

    public Produto() {
    }
}
