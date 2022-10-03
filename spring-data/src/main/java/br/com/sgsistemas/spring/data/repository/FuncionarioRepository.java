package br.com.sgsistemas.spring.data.repository;

import br.com.sgsistemas.spring.data.model.Funcionario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario,Integer> {
    public List<Funcionario> findByNomeLike(String nome);
}
