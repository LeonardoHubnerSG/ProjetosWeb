package br.com.sgsistemas.devsg.controller.dto;

import br.com.sgsistemas.devsg.model.Linguagem;
import lombok.Data;

import java.util.List;

@Data
public class EquipeDto {
    private String nome;
    private List<PessoaDto> pessoas;
    private List<LinguagemDto> linguagens;
        /*
    private Integer id;
    private String nome;
    @OneToMany
    private List<Pessoa> pessoas;
    @ManyToMany(mappedBy = "equipes")
    private List<Linguagem> linguagens;
     */
}
