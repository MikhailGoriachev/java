package org.itstep.pd011.controllers;

import java.util.List;

import org.itstep.pd011.models.Order;
import org.itstep.pd011.services.OrderService;
import org.itstep.pd011.services.OrderServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class OrderController {
	
	private OrderService orderService = new OrderServiceImpl();

	// отдать странцу с закзам
	@RequestMapping(value="/order-list", method=RequestMethod.GET)
	public String getOrderPage(Model model) {
		List<Order> orders = orderService.getAll();
		model.addAttribute("orderList", orders);

		return "order";
	}

	// отдать форму добавления элемента заказа
	@RequestMapping(value = "/add-new-order", method=RequestMethod.GET)
	public String addNewOrderPage() {
		return "add-new-order";
	}


	// !!! в данном случае решено было не делать Spring-форму !!!
	// обработать форму добавления элемента заказа
	@RequestMapping(value="/add-new-order", method=RequestMethod.POST)
	public String addNewOrder(@RequestParam(value="title") String title, @RequestParam(value="price") Double price) {
		Order order = new Order();
		order.setTitle(title);
		order.setPrice(price);
		orderService.save(order);

		return "redirect:/";
	}

	// TODO: Spring-форма для изменения элемента заказа

	// удаление элемента заказа по id
	@RequestMapping(value="delete-order/{id}", method=RequestMethod.GET)
	public String deleteItem(@PathVariable Integer id) {
		Order order = orderService.getById(id);
		orderService.delete(order);
		return "redirect:/";
	}
}
