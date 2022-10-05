package br.com.sgsistemas.devsg.controller.form;


import br.com.sgsistemas.devsg.model.Equipe;
import br.com.sgsistemas.devsg.model.Pessoa;
import br.com.sgsistemas.devsg.model.Produto;
import br.com.sgsistemas.devsg.repository.EquipeRepository;
import br.com.sgsistemas.devsg.repository.PessoaRepository;
import br.com.sgsistemas.devsg.repository.ProdutoRepository;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ProdutoAtualizaForm {
	
	@NotNull @NotEmpty @Length(min = 5)
    private String nome;
    @NotNull
    private Integer idEquipe;


    public Produto atualizar(Integer id, ProdutoRepository produtoRepository, EquipeRepository equipeRepository) {
        Produto produto = produtoRepository.findById(id).get();

        produto.setNome(this.nome);
        Equipe equipe = equipeRepository.findById(this.idEquipe).get();
        produto.setEquipe(equipe);

        return produto;
    }
}