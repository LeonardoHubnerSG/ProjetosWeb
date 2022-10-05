package br.com.sgsistemas.devsg.repository;

import br.com.sgsistemas.devsg.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto,Integer> {

    List<Produto> findByNome(String nome);
}
