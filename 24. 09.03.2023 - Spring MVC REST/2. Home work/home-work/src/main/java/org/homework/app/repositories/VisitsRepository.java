package org.homework.app.repositories;

import org.homework.app.entries.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface VisitsRepository extends JpaRepository<Visit, Long> {

    // информация о клиентах, совершивших поездки с заданным количеством дней пребывания в стране
    List<Visit> findAllByDuration(int duration);

    // вычисление полной стоимости и ее полную стоимость с НДС для каждой поездки (метод в классе) 
    // сортировка по полю Страна назначения
    List<Visit> findAllByOrderByRouteCountryName();
}
