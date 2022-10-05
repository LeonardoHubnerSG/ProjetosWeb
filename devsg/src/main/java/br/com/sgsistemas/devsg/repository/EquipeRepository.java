package br.com.sgsistemas.devsg.repository;

import br.com.sgsistemas.devsg.model.Equipe;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipeRepository extends JpaRepository<Equipe, Integer> {

	Equipe findByNome(String nomeEquipe);
}
