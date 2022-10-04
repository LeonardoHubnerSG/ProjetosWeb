package br.com.sgsistemas.forum.repository;

import java.util.List;

import br.com.sgsistemas.forum.modelo.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

	List<Topico> findByCursoNome(String nomeCurso);

}
