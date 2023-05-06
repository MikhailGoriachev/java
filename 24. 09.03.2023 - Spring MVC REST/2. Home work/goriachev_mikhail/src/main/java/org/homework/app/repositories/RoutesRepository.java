package org.homework.app.repositories;

import org.homework.app.entries.Route;
import org.homework.app.models.Query07;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface RoutesRepository extends JpaRepository<Route, Long> {

    // информация о маршрутах с заданной целью поездки
    List<Route> findAllByObjectiveName(String objectiveName);

    // информация о маршрутах с заданной целью поездки и стоимостью 
    // транспортных услуг менее заданного значения
    List<Route> findAllByObjectiveNameAndCountryCostServiceLessThan(String objectiveName, int costService);

    // информация о маршрутах в заданную страну
    List<Route> findAllByCountryName(String countryName);

    // группировка по полю Цель поездки. Статистика стоимости 1 дня пребывания
    @Query(value = """
                select new org.homework.app.models.Query07(
                    r.objective.name,
                    min(r.dailyCost),
                    avg(r.dailyCost),
                    max(r.dailyCost),
                    count(*)
                )
                from
                    Route r
                group by
                    r.objective.name
            """)
    List<Query07> groupByObjective();
}
