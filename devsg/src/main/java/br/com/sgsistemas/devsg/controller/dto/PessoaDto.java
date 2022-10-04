package br.com.sgsistemas.devsg.controller.dto;

import br.com.sgsistemas.devsg.model.Equipe;
import br.com.sgsistemas.devsg.model.Pessoa;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class PessoaDto {
    private String nome;
    private EquipeDto equipe;

    /*
    private Integer id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Cargo cargo = Cargo.SEM_CARGO;
    @ManyToOne
    private Equipe equipe;
     */

    public static List<PessoaDto> converter(List<Pessoa> pessoas) {
        return pessoas.stream().map(PessoaDto::new).collect(Collectors.toList());
    }
}
