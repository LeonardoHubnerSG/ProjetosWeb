package br.com.sgsistemas.devsg.controller.dto;

import br.com.sgsistemas.devsg.model.Linguagem;
import lombok.Data;

import java.util.List;

@Data
public class EquipeDto {
    private String nome;
    private List<PessoaDto> pessoas;
    private List<LinguagemDto> linguagens;

}
