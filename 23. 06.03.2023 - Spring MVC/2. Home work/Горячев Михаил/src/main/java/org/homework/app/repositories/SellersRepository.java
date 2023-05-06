package org.homework.app.repositories;

import org.homework.app.entries.Seller;
import org.homework.app.models.Query07;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SellersRepository extends JpaRepository<Seller, Long> {

    // для всех продавцов вывести сумму и количество продаж, минимальную и 
    // максимальную стоимости продаж
    @Query(value = """
            select new org.homework.app.models.Query07(
                sel.id,
                sel.person,
                coalesce(sum(sale.price), 0),
                coalesce(min(sale.price), 0),
                coalesce(max(sale.price), 0),
                count(sale.price)
                )
            from
                Seller sel left join Sale sale on sel.id = sale.seller.id
            group by
                sel.id
            """)
    List<Query07> groupBySeller();
    
    // выбирает информацию о продавцах с заданным значением процента комиссионных. 
    // Значение задавать параметром
    List<Seller> findAllByInterest(int interest);
}
