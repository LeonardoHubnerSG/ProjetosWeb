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
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @OneToMany
    private List<Pessoa> pessoas;
    @ManyToMany(mappedBy = "equipes")
    private List<Linguagem> linguagens;
}
