package br.com.sgsistemas.cadastroclientes.specification;

import br.com.sgsistemas.cadastroclientes.model.Cliente;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class SpecificationCliente {

    public static Specification<Cliente> nome(String nome){
        return ((root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get("nome"), "%" + nome + "%"));
    }

    public static Specification<Cliente> dataNascimento(LocalDate dataNascimento){
        return ((root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.greaterThan(root.get("dataNascimento"), dataNascimento));
    }

    public static Specification<Cliente> limite(Double limite){
        return ((root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.greaterThan(root.get("limite"), limite));
    }
}
