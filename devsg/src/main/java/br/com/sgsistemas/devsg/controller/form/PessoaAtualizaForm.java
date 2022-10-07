package br.com.sgsistemas.devsg.controller.form;


import br.com.sgsistemas.devsg.model.Equipe;
import br.com.sgsistemas.devsg.model.Pessoa;
import br.com.sgsistemas.devsg.repository.EquipeRepository;
import br.com.sgsistemas.devsg.repository.PessoaRepository;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class PessoaAtualizaForm {
	
	@NotNull @NotEmpty @Length(min = 5)
    private String nome;
	@NotNull @NotEmpty
    private String nomeCargo;


    public Pessoa atualizar(Integer id, PessoaRepository pessoaRepository) {
        Pessoa pessoa = pessoaRepository.findById(id).get();
        System.out.println("nome: " + this.nome + " cargo: " + this.nomeCargo);
        pessoa.atualizaPessoa(this.nome, this.nomeCargo);
//        pessoa.setNome(this.nome);
//        pessoa.setCargo(this.nomeCargo);

        return pessoa;
    }
}