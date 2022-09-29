package br.com.sgsistemas.spring.data.repository;

import br.com.sgsistemas.spring.data.model.UnidadeTrabalho;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeTrabalhoRepository extends CrudRepository<UnidadeTrabalho,Integer> {
}
