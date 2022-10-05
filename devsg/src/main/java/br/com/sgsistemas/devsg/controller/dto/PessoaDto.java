package br.com.sgsistemas.devsg.controller.dto;

import br.com.sgsistemas.devsg.model.Equipe;
import br.com.sgsistemas.devsg.model.Pessoa;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class PessoaDto {
    private String nome;
    private String equipe;
    private String cargo;
    
    public PessoaDto(Pessoa pessoa) {
		this.nome = pessoa.getNome();
		this.equipe = pessoa.getEquipe().getNome();
		this.cargo = pessoa.getCargo().name();
	}

    /*
    public String getNome() {
		return nome;
	}

	public String getEquipe() {
		return equipe;
	}
	
	public String getCargo() {
		return this.cargo;
	}
    */

	public static List<PessoaDto> converter(List<Pessoa> pessoas) {
        return pessoas.stream().map(PessoaDto::new).collect(Collectors.toList());
    }
}
