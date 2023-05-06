package org.homework.app.repositories;

import org.homework.app.entries.Seller;
import org.homework.app.models.Query06;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SellersRepository extends JpaRepository<Seller, Long> {

    // 6	Итоговый запрос с левым соединением	    Для всех продавцов вывести сумму и количество продаж, минимальную и 
    //                                              максимальную стоимости продаж
    @Query(value = """
            select
                sellers.id,
                sellers.person_id as personId,
                ifnull(sum(s.price), 0) as sumPrice,
                count(s.price) as count,
                ifnull(min(s.price), 0) as minPrice,
                ifnull(max(s.price), 0) as maxPrice
            from
                sellers left join sales s on sellers.id = s.seller_id
            group by
                sellers.id, sellers.person_id;
            """,
            nativeQuery = true)
    List<Query06> groupBySeller();
}
