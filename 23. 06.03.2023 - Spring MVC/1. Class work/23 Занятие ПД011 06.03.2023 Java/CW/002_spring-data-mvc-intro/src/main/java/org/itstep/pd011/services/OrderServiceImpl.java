package org.itstep.pd011.services;

import org.itstep.pd011.entities.Order;
import org.itstep.pd011.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.security.PrivilegedExceptionAction;
import java.util.List;

// реализация операций с использованием репозитория
@Service
public class OrderServiceImpl implements OrderService {
	private OrderRepository orderRepository;

	/* ----  настройка фреймоворка Spring */
	// @Autowired - фреймворк сам ищет поле сервиса
	@Autowired
	private OrderService orderService;

	// @Autowired - фреймворк сам ищет метод сервиса
	@Autowired
	public void setOrderRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	/* ---- */

	public void save(Order order) {
		if(order!=null) {
			orderRepository.saveAndFlush(order);
		}
	}

	public void delete(Order order) {
		if(order!=null) {
			orderRepository.delete(order);
		}	
	}

	public List<Order> getAll() {
		return orderRepository.findAll();
	}

	public Order getById(Integer id) {
		return id==null?null:orderRepository.getById(id);
	}
}
