package br.com.sgsistemas.devsg.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

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

    public Pessoa(String nome, String nomeCargo, Equipe equipe) {
        this.nome = nome;
        this.cargo = Cargo.valueOf(nomeCargo);
        this.equipe = equipe;
    }

    public Pessoa() {

    }

    public void atualizaPessoa(String nome, String nomeCargo) {
        this.nome = nome;
        this.cargo = Cargo.valueOf(nomeCargo);
    }

	/*

	
	public Pessoa() {
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


	public Cargo getCargo() {
		return cargo;
	}


	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}


	public Equipe getEquipe() {
		return equipe;
	}


	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	*/
	
    
}
