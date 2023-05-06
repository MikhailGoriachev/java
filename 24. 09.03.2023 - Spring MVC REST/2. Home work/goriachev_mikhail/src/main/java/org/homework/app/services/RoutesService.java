package org.homework.app.services;

import org.homework.app.entries.Route;
import org.homework.app.models.Query07;

import java.util.List;


public interface RoutesService {

    // все записи
    List<Route> findAll();

    // запись по id
    Route findById(Long id);

    // добавить запись
    void store(Route item);

    // изменить запись
    void update(Route item);

    // информация о маршрутах с заданной целью поездки
    List<Route> findAllByObjectiveName(String objectiveName);

    // информация о маршрутах с заданной целью поездки и стоимостью 
    // транспортных услуг менее заданного значения
    List<Route> findAllByObjectiveNameAndCountryCostServiceLessThan(String objectiveName, int costService);

    // информация о маршрутах в заданную страну
    List<Route> findAllByCountryName(String countryName);

    // группировка по полю Цель поездки. Статистика стоимости 1 дня пребывания
    List<Query07> groupByObjective();
}
