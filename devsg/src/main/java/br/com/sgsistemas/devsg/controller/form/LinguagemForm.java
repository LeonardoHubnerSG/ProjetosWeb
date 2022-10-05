package br.com.sgsistemas.devsg.controller.form;

import br.com.sgsistemas.devsg.model.Equipe;
import br.com.sgsistemas.devsg.model.Linguagem;
import br.com.sgsistemas.devsg.model.Pessoa;
import br.com.sgsistemas.devsg.repository.EquipeRepository;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class LinguagemForm {
	@NotNull @NotEmpty
    private String nome;

	public Linguagem converter() {
        return new Linguagem(this.nome);
    }
}