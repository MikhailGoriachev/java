package org.itstep.pd011.controllers;

import org.itstep.pd011.entities.Order;
import org.itstep.pd011.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

// REST-запросы к сущности Order
@RestController
@RequestMapping("/rest")
public class OrderRestController {

    // первый запрос, просто вернем переданное число, по умолчанию формат XML
    @GetMapping(value = "/repeat/{number}")
    public int repeatNumber(@PathVariable int number) {
        return number;
    } // repeatNumber

    // первый запрос, просто вернем переданное число, формат JSON
    @GetMapping(value = "/repeat-json/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
    public int repeatNumberJson(@PathVariable int number) {
        return number;
    } // repeatNumberJson

    // ----------------------------------------------------------------------------

    // сервис доступа к базе данных
    @Autowired
    private OrderService orderService;

    // получить элемент заказа по идентификатору, по умолчанию формат ответа XML
    @GetMapping(value = "/order/{id}")
    public Order getOrderById(@PathVariable int id) {
        return orderService.getById(id);
    } // getOrderById

    // получить элемент заказа по идентификатору, формат ответа JSON
    @GetMapping(value = "/order-json/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order getOrderByIdJson(@PathVariable int id) {
        return orderService.getById(id);
    } // getOrderById


    // получить все элементы заказа, по умолчанию формат ответа XML
    @GetMapping(value="/order-list")
    public List<Order> getOrders() {
        return orderService.getAll();
    } // getOrders

    // получить все элементы заказа, формат ответа JSON
    @GetMapping(value="/order-list-json", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> getOrdersJson() {
        return orderService.getAll();
    } // getOrdersJson

    // выполнение запроса - в Postman

    // добавление записи
    @PutMapping("/order-add")
    public Order addOrder(@RequestBody Order order) {
        return orderService.save(order);
    } // addOrder

    // удаление записи по id
    @DeleteMapping("/order-delete")
    public int deleteOrderById(@RequestBody int id) {
        int cc = 0;
        try {
            orderService.delete(orderService.getById(id));
        } catch (Exception ex) {
            cc = 500;
        } // try-catch

        return cc;
    } // deleteOrderById

    // Изменение записи
    @PostMapping("/order-post")
    public Order postOrder(@RequestBody Order order) {
        return orderService.save(order);
    } // postOrder
} // class OrderRestController
