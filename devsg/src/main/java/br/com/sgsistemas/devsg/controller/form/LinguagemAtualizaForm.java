package br.com.sgsistemas.devsg.controller.form;

import br.com.sgsistemas.devsg.model.Linguagem;
import br.com.sgsistemas.devsg.repository.LinguagemRepository;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class LinguagemAtualizaForm {

    @NotNull
    @NotEmpty
    private String nome;

    public Linguagem atualizar(Integer id, LinguagemRepository linguagemRepository) {
        Linguagem linguagem = linguagemRepository.findById(id).get();

        linguagem.setNome(this.nome);

        return linguagem;
    }
}