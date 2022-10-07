package br.com.sgsistemas.devsg.controller.form;

import br.com.sgsistemas.devsg.model.Equipe;
import br.com.sgsistemas.devsg.model.Pessoa;
import br.com.sgsistemas.devsg.model.Produto;
import br.com.sgsistemas.devsg.repository.EquipeRepository;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ProdutoForm {
	@NotNull @NotEmpty @Length(min = 5)
    private String nome;
	@NotNull
    private Integer idEquipe;

	public Produto converter(EquipeRepository equipeRepository) {
        Equipe equipe = equipeRepository.findById(idEquipe).get();
        return new Produto(this.nome, equipe);
    }
}