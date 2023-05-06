package org.itstep.pd011.repositories;

import org.itstep.pd011.models.Order;

import java.util.List;

// поведение репозитория
public interface OrderRepository {

	void save(Order order);
	
	void delete(Order order);
	
	List<Order> getAll();
	
	Order getById(Integer id);
} // interface OrderRepository
