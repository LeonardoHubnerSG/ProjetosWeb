package br.com.sgsistemas.devsg.controller.dto;

import br.com.sgsistemas.devsg.model.Equipe;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class EquipeDto {
    private String nome;
    private List<String> linguagens = new ArrayList<>();

    public EquipeDto(Equipe equipe){
        this.nome = equipe.getNome();

        equipe.getLinguagens().forEach(linguagem -> {
            this.linguagens.add(linguagem.getNome());
        });
    }

    public static List<EquipeDto> converter(List<Equipe> equipes) {
        return equipes.stream().map(EquipeDto::new).collect(Collectors.toList());
    }
}
