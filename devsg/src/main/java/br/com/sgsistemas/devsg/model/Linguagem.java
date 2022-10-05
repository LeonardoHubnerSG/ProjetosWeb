package br.com.sgsistemas.devsg.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
@Data
public class Linguagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @ManyToMany(mappedBy = "linguagens")
    private List<Equipe> equipes;

    public Linguagem(String nome) {
        this.nome = nome;
    }

    public Linguagem() {
    }
}
