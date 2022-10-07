package br.com.sgsistemas.udemyproject.repository;

import br.com.sgsistemas.udemyproject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
