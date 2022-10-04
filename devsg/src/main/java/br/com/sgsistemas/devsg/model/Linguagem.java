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
    @ManyToMany
    private List<Equipe> equipes;
}
