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
    @OneToMany(mappedBy = "equipe")
    private List<Pessoa> pessoas;
    @OneToMany(mappedBy = "equipe")
    private List<Produto> produtos;
    @ManyToMany
    private List<Linguagem> linguagens;

    public Equipe(String nome, List<Linguagem> linguagens) {
        this.nome = nome;
        this.linguagens = linguagens;
    }

    public Equipe() {
    }

    /*
	public Integer getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	public List<Linguagem> getLinguagens() {
		return linguagens;
	}
	*/
    
}
