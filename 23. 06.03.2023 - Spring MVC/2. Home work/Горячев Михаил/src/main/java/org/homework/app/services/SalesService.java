package org.homework.app.services;

import org.homework.app.entries.Sale;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SalesService {
    
    // все записи
    List<Sale> findAll();
    
    // запись по id
    Sale findById(Long id);
    
    // добавить запись
    void store(Sale item);
    
    // изменить запись
    void update(Sale item);
    
    // удалить запись
    void delete(Long id);

    // Выбирает информацию обо всех зафиксированных фактах продажи товаров (Наименование товара, Цена закупки, Цена 
    // продажи, дата продажи), для которых Цена продажи оказалась в некоторых заданных границах. Значения задавать 
    // параметрами
    List<Sale> findAllByPriceBetween(int priceMin, int priceMax);
}
