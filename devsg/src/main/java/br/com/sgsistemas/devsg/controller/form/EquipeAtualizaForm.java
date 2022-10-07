package br.com.sgsistemas.devsg.controller.form;

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
public class EquipeAtualizaForm {
    @NotNull @NotEmpty
    private String nome;
    @NotNull
    List<@Positive Integer> idsLinguagens = new ArrayList<>();


    public Equipe atualizar(Integer id, EquipeRepository equipeRepository, LinguagemRepository linguagemRepository) {

        Equipe equipe = equipeRepository.findById(id).get();

        equipe.setNome(this.nome);

        List<Linguagem> linguagens = new ArrayList<>();
        this.idsLinguagens.forEach(linguagem -> {
            Optional<Linguagem> linguagemOptional = linguagemRepository.findById(linguagem.intValue());
            if (linguagemOptional.isPresent()){
                linguagens.add(linguagemOptional.get());
            }
        });
        equipe.setLinguagens(linguagens);

        return equipe;
    }
}