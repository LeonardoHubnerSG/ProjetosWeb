package br.com.sgsistemas.cadastroclientes.repository;

import br.com.sgsistemas.cadastroclientes.model.Cliente;
import br.com.sgsistemas.cadastroclientes.model.ClienteProjection;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClienteRepository extends CrudRepository<Cliente,Integer>, JpaSpecificationExecutor<Cliente> {

    @Query(nativeQuery = true, value = "SELECT c.nome, c.datanasc FROM clientes c")
    List<ClienteProjection> findClienteProjection();

}
