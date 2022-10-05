package br.com.sgsistemas.devsg.controller.form;



import org.hibernate.validator.constraints.Length;

import br.com.sgsistemas.devsg.model.Cargo;
import br.com.sgsistemas.devsg.model.Equipe;
import br.com.sgsistemas.devsg.model.Pessoa;
import br.com.sgsistemas.devsg.repository.EquipeRepository;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PessoaForm {
	
	@NotNull @NotEmpty @Length(min = 5)
    private String nome;
	@NotNull @NotEmpty @Length(min = 10)
    private String nomeCargo;
	@NotNull @NotEmpty @Length(min = 5)
    private String nomeEquipe;
	
	
	
    public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getNomeCargo() {
		return nomeCargo;
	}



	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}



	public String getNomeEquipe() {
		return nomeEquipe;
	}



	public void setNomeEquipe(String nomeEquipe) {
		this.nomeEquipe = nomeEquipe;
	}



	public Pessoa converter(EquipeRepository equipeRepository) {
        Equipe equipe = equipeRepository.findByNome(nomeEquipe);
        return new Pessoa(nome, nomeCargo, equipe);
    }


}