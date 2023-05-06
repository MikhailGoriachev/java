package org.homework.app.services;

import org.homework.app.entries.Route;
import org.homework.app.models.Query07;
import org.homework.app.repositories.RoutesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoutesServiceImpl implements RoutesService {

    // репозиторий
    private RoutesRepository repository;

    @Autowired
    public void setRepository(RoutesRepository repository) {
        this.repository = repository;
    }

    // сервис
    @Autowired
    private RoutesService service;

    // все записи
    @Override
    public List<Route> findAll() {
        return repository.findAll();
    }

    // запись по Id
    @Override
    public Route findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // добавить запись
    @Override
    public void store(Route item) {
        item.setId(0L);
        repository.saveAndFlush(item);
    }

    // изменить запись
    @Override
    public void update(Route item) {
        repository.saveAndFlush(item);
    }

    // информация о маршрутах с заданной целью поездки
    @Override
    public List<Route> findAllByObjectiveName(String objectiveName) {
        return repository.findAllByObjectiveName(objectiveName);
    }

    // информация о маршрутах с заданной целью поездки и стоимостью 
    // транспортных услуг менее заданного значения
    @Override
    public List<Route> findAllByObjectiveNameAndCountryCostServiceLessThan(String objectiveName, int costService) {
        return repository.findAllByObjectiveNameAndCountryCostServiceLessThan(objectiveName, costService);
    }

    // информация о маршрутах в заданную страну
    @Override
    public List<Route> findAllByCountryName(String countryName) {
        return repository.findAllByCountryName(countryName);
    }

    // группировка по полю Цель поездки. Статистика стоимости 1 дня пребывания
    public List<Query07> groupByObjective() {
        return repository.groupByObjective();
    }
}
