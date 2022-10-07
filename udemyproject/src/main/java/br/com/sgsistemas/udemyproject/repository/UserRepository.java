package br.com.sgsistemas.udemyproject.repository;

import br.com.sgsistemas.udemyproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
