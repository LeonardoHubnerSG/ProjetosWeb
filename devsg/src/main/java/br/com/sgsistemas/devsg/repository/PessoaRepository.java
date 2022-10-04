package br.com.sgsistemas.devsg.repository;

import br.com.sgsistemas.devsg.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    List<Pessoa> findByNome(String nome);
}
