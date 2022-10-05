package br.com.sgsistemas.devsg.controller.dto;

import br.com.sgsistemas.devsg.model.Produto;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ProdutoDto {
    private String nome;
    private String equipe;

    public ProdutoDto(Produto produto){
        this.nome = produto.getNome();
        this.equipe = produto.getEquipe().getNome();
    }

    public static List<ProdutoDto> converter(List<Produto> produtos) {
        return produtos.stream().map(ProdutoDto::new).collect(Collectors.toList());
    }
}
