package br.com.sgsistemas.devsg.controller.form;


import br.com.sgsistemas.devsg.controller.dto.LinguagemDto;
import br.com.sgsistemas.devsg.controller.dto.PessoaDto;
import br.com.sgsistemas.devsg.model.Equipe;
import br.com.sgsistemas.devsg.model.Linguagem;
import br.com.sgsistemas.devsg.model.Pessoa;
import br.com.sgsistemas.devsg.repository.EquipeRepository;
import br.com.sgsistemas.devsg.repository.LinguagemRepository;
import br.com.sgsistemas.devsg.repository.PessoaRepository;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class EquipeForm {
	
	@NotNull @NotEmpty @Length(min = 3)
    private String nome;
    @NotNull
    List<@Positive Integer> idsLinguagens = new ArrayList<>();

	public Equipe converter(LinguagemRepository linguagemRepository) {

        List<Linguagem> linguagens = new ArrayList<>();

        this.idsLinguagens.forEach(idling -> {
            Optional<Linguagem> linguagemOptional = linguagemRepository.findById(idling.intValue());
            if (linguagemOptional.isPresent()){
                linguagens.add(linguagemOptional.get());
            }
        });

        return new Equipe(nome, linguagens);
    }


}