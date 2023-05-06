package org.itstep.pd011.repositories;

import org.itstep.pd011.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

// репозиторий Spring Data
public interface OrderRepository extends JpaRepository<Order, Integer> {

	Order getById(Integer id);
} // interface OrderRepository
