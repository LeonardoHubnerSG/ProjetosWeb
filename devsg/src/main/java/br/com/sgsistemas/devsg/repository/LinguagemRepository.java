package br.com.sgsistemas.devsg.repository;

import br.com.sgsistemas.devsg.model.Linguagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LinguagemRepository extends JpaRepository<Linguagem, Integer> {
    List<Linguagem> findByNome(String nomeLinguagem);
}
