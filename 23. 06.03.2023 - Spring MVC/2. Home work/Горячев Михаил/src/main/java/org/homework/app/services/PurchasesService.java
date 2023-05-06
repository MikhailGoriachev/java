package org.homework.app.services;

import org.homework.app.entries.Purchase;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PurchasesService {
    
    // все записи
    List<Purchase> findAll();
    
    // запись по id
    Purchase findById(Long id);
    
    // добавить запись
    void store(Purchase item);
    
    // изменить запись
    void update(Purchase item);

    // выбирает из информацию о товарах, единицей измерения которых является «шт» (штуки) и цена закупки составляет 
    // меньше 200 руб. Значения задавать параметрами
    List<Purchase> findAllByUnitShortNameAndPriceLessThan(String shortName, int price);
    
    // выбирает информацию о товарах, цена закупки которых меньше 500 руб. за единицу товара. Значения задавать
    // параметрами
    List<Purchase> findAllByPriceLessThan(int price);
}
