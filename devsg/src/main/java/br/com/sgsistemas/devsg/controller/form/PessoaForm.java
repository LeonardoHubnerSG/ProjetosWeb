package br.com.sgsistemas.devsg.controller.form;

import lombok.Data;
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

@Data
public class PessoaForm {
	@NotNull @NotEmpty @Length(min = 5)
    private String nome;
	@NotNull @NotEmpty
    private String nomeCargo;
	@NotNull
    private Integer idEquipe;

	public Pessoa converter(EquipeRepository equipeRepository) {
        Equipe equipe = equipeRepository.findById(idEquipe).get();
        return new Pessoa(nome, nomeCargo, equipe);
    }
}