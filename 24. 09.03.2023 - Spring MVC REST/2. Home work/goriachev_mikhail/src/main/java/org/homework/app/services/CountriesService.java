package org.homework.app.services;

import org.homework.app.entries.Country;
import org.homework.app.models.Query08;

import java.util.List;


public interface CountriesService {
    
    // все записи
    List<Country> findAll();
    
    // запись по id
    Country findById(Long id);
    
    // добавить запись
    void store(Country item);
    
    // изменить запись
    void update(Country item);

    // информация о странах, для которых стоимость оформления визы есть 
    // значение из некоторого диапазона
    List<Country> findAllByCostVisaBetween(int costVisaMin, int costVisaMax);

    // группировка по полю Страна назначения. Для каждой страны вычисляется среднее значение 
    // по полю Стоимость транспортных услуг
    List<Query08> groupByCountry();
}
