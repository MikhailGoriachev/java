package org.homework.app.repositories;

import org.homework.app.entries.Goods;
import org.homework.app.models.Query06;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long> {

    // выполняет группировку по наименованию закупленного товара. Для каждого наименования 
    // вычисляет среднюю цену закупки товара, количество закупок
    @Query(value = """
            select new org.homework.app.models.Query06(
                g.name,
                coalesce(min(p.price), 0),
                cast(coalesce(avg(p.price), 0) as int),
                coalesce(max(p.price), 0),
                count(*))
            from
                Goods g left join Purchase p on g.id = p.goods.id
            group by
                g.name
             """)
    List<Query06> groupByName();
}
