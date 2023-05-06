package org.homework.app.repositories;

import org.homework.app.entries.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchasesRepository extends JpaRepository<Purchase, Long> {
    // выбирает из информацию о товарах, единицей измерения которых является «шт» (штуки) и цена закупки составляет 
    // меньше 200 руб. Значения задавать параметрами
    List<Purchase> findAllByUnitShortNameAndPriceLessThan(String shortName, int price);

    // выбирает информацию о товарах, цена закупки которых меньше 500 руб. за единицу товара. Значения задавать
    // параметрами
    List<Purchase> findAllByPriceLessThan(int price);
}
