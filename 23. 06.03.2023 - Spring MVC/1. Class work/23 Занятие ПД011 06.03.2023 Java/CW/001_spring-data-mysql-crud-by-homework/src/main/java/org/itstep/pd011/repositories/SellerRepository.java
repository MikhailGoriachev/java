package org.itstep.pd011.repositories;

import org.itstep.pd011.entities.Seller;
import org.itstep.pd011.models.IQuery06;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// сведения о продавцах
public interface SellerRepository extends JpaRepository<Seller, Integer>  {
    @Query(value = """
    select\s
        persons.surname                              as surname
        , persons.`name`                             as name
        , persons.patronymic                         as patronymic
        , persons.passport                           as passport
        , ifnull(sum(sales.price * sales.amount), 0) as totalSale
        , count(sales.id)                            as salesFact
        , ifnull(min(sales.price * sales.amount), 0) as minSale
        , ifnull(max(sales.price * sales.amount), 0) as maxSale
    from\s
        (sellers join persons on sellers.person_id = persons.id) left join sales on sellers.id = sales.seller_id
    group by
        persons.surname, persons.name, persons.patronymic, persons.passport;
    """, nativeQuery = true)
    List<IQuery06> query06();
} // interface SellerRepository
