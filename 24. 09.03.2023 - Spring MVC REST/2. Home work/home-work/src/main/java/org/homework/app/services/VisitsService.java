package org.homework.app.services;

import org.homework.app.entries.Visit;

import java.util.List;


public interface VisitsService {
    
    // все записи
    List<Visit> findAll();
    
    // запись по id
    Visit findById(Long id);
    
    // добавить запись
    void store(Visit item);
    
    // изменить запись
    void update(Visit item);    
    
    // удалить запись
    void deleteById(Long id);

    // информация о клиентах, совершивших поездки с заданным количеством дней пребывания в стране
    List<Visit> findAllByDuration(int duration);

    // вычисление полной стоимости и ее полную стоимость с НДС для каждой поездки (метод в классе) 
    // сортировка по полю Страна назначения
    List<Visit> findAllByOrderByRouteCountryName();
}
