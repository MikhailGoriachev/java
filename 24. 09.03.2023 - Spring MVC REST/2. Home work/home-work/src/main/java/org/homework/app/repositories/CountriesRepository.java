package org.homework.app.repositories;

import org.homework.app.entries.Country;
import org.homework.app.models.Query08;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CountriesRepository extends JpaRepository<Country, Long> {
    
    // информация о странах, для которых стоимость оформления визы есть 
    // значение из некоторого диапазона
    List<Country> findAllByCostVisaBetween(int costVisaMin, int costVisaMax);
    
    // группировка по полю Страна назначения. Для каждой страны вычисляется среднее значение 
    // по полю Стоимость транспортных услуг
    @Query(value = """
                select new org.homework.app.models.Query08(
                    c.name,
                    min(c.costService),
                    avg(c.costService),
                    max(c.costService),
                    count(*)
                )
                from
                    Country c
                group by
                    c.name
            """)
    List<Query08> groupByCountry();
}
