package br.com.sgsistemas.devsg.controller.dto;

import lombok.Data;

import java.util.List;

@Data
public class LinguagemDto {
    private String nome;
    private List<EquipeDto> equipes;

}
