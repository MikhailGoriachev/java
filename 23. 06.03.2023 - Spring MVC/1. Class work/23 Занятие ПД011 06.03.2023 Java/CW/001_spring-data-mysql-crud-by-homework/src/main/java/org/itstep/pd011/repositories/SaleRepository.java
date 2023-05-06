package org.itstep.pd011.repositories;

import org.itstep.pd011.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Integer>  {
    // Запрос 3.
    // Выбирает информацию обо всех зафиксированных фактах продажи товаров
    // (Наименование товара, Цена закупки, Цена продажи, дата продажи),
    // для которых Цена продажи оказалась в некоторых заданных границах.
    // Значения задавать параметрами
    // List<Sale> findSalesByPriceBetween(int lo, int hi);
    List<Sale> findSalesByPriceBetween(Integer lo, Integer hi);

    // Запрос 3.
    // Выбирает информацию обо всех зафиксированных фактах продажи товаров
    // (Наименование товара, Цена закупки, Цена продажи, дата продажи),
    // для которых Цена продажи оказалась в некоторых заданных границах.
    // Значения задавать параметрами
    List<Sale> findByOrderByPurchaseProductName();
} // interface SaleRepository
