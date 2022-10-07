package br.com.sgsistemas.udemyproject.repository;

import br.com.sgsistemas.udemyproject.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
