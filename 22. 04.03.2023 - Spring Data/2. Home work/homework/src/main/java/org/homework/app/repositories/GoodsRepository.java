package org.homework.app.repositories;

import org.homework.app.entries.Goods;
import org.homework.app.models.Query05;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GoodsRepository extends JpaRepository<Goods, Long> {

    // выполняет группировку по наименованию закупленного товара. Для каждого наименования 
    // вычисляет среднюю цену закупки товара, количество закупок
    @Query(value = """
            select
                name as goodsName,
                ifnull(min(p.price), 0) as minPrice,
                ifnull(avg(p.price), 0) as avgPrice,
                ifnull(max(p.price), 0) as maxPrice,
                count(*) as count
            from
                goods left join purchases p on goods.id = p.goods_id
            group by
                name;
             """,
            nativeQuery = true)
    List<Query05> groupByName();
}
