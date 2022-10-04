package br.com.sgsistemas.devsg.model;

import lombok.*;

import javax.persistence.*;

@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
@Data
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Cargo cargo = Cargo.SEM_CARGO;
    @ManyToOne
    private Equipe equipe;
}
