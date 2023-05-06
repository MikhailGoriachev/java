package org.itstep.pd011.repositories;

import org.itstep.pd011.entities.Purchase;
import org.itstep.pd011.models.IQuery05;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
    // Запрос 1.
    // Выбирает информацию о товарах, единицей измерения которых является «шт» (штуки)
    // и цена закупки составляет меньше 500 руб. Значения задавать параметрами
    @Query(value= """
        select
            *
        from
            purchases join products on purchases.product_id = products.id
                      join units    on purchases.unit_id = units.id
        where
            units.short = :unit and purchases.price < :price""", nativeQuery = true)
    List<Purchase> findPurchasesBy(@Param("unit") String unit, @Param("price") Integer price);

    List<Purchase> findPurchasesByUnitShortNameAndPriceLessThan(String unit, Integer price);

    // Запрос 2.
    // Выбирает информацию о товарах, цена закупки которых меньше 500 руб.
    // за единицу товара. Значения задавать параметрами
    List<Purchase> findPurchasesByPriceLessThan(int value);

    // Запрос 5.
    // Выполняет группировку по наименованию закупленного товара.
    // Для каждого наименования вычисляет среднюю цену закупки
    // товара, количество закупок
    @Query(value= """ 
        select
            products.name            as name
            , avg(purchases.price)   as averagePrice
            , count(purchases.price) as amount
        from
            purchases join products on purchases.product_id = products.id
        group by
            products.name;
        """, nativeQuery = true)
    List<IQuery05> query05();
} // interface PurchaseRepository
