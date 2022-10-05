package br.com.sgsistemas.devsg.controller.dto;

import br.com.sgsistemas.devsg.model.Linguagem;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class LinguagemDto {
    private String nome;

    public LinguagemDto(Linguagem linguagem){
        this.nome = linguagem.getNome();
    }

    public static List<LinguagemDto> converter(List<Linguagem> linguagens) {
        return linguagens.stream().map(LinguagemDto::new).collect(Collectors.toList());
    }
}
