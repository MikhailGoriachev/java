package org.homework.app.repositories;

import org.homework.app.entries.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalesRepository extends JpaRepository<Sale, Long> {
    
    // Выбирает информацию обо всех зафиксированных фактах продажи товаров (Наименование товара, Цена закупки, Цена 
    // продажи, дата продажи), для которых Цена продажи оказалась в некоторых заданных границах. Значения задавать 
    // параметрами
    List<Sale> findAllByPriceBetween(int priceMin, int priceMax);
}
