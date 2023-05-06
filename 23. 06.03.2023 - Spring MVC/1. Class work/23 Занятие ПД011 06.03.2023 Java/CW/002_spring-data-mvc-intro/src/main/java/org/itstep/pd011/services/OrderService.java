package org.itstep.pd011.services;

import java.util.List;

import org.itstep.pd011.entities.Order;

// операции, предоставляемые сервисом
public interface OrderService {
	
	void save(Order order);

	void delete(Order order);

	List<Order> getAll();

	Order getById(Integer id);
}
