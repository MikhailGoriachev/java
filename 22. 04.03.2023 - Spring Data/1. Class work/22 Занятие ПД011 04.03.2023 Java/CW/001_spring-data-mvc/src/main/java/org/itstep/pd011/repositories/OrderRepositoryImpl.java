package org.itstep.pd011.repositories;

import java.util.ArrayList;
import java.util.List;
import org.itstep.pd011.models.Order;

// Реалиация репозитория
public class OrderRepositoryImpl implements OrderRepository {
	
	private List<Order> orders = new ArrayList<Order>();
	
	public OrderRepositoryImpl() {
		Order order = new Order();
		order.setId(1);
		order.setPrice(234d);
		order.setTitle("Pizza peperoni");
		Order order2 = new Order();
		order2.setId(2);
		order2.setPrice(123d);
		order2.setTitle("Sushi Philadelfia");
		orders.add(order);
		orders.add(order2);
	}

	public void save(Order order) {
		orders.add(order);
	}

	public void delete(Order order) {
		orders.remove(order);
	}

	public List<Order> getAll() {
		return orders;
	}

	// TODO: передалать на поиск по id
	public Order getById(Integer id) {
		return orders.get(id);
	}
}
