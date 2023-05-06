package org.homework.app.services;

import org.homework.app.entries.Country;
import org.homework.app.models.Query08;
import org.homework.app.repositories.CountriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CountriesServiceImpl implements CountriesService {
    
    // репозиторий
    private CountriesRepository repository;
    
    @Autowired
    public void setRepository(CountriesRepository repository) {
        this.repository = repository;
    }
    
    // сервис
    @Autowired
    private CountriesService service;
    
    // все записи
    @Override
    public List<Country> findAll() {
        return repository.findAll();
    }

    // запись по Id
    @Override
    public Country findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // добавить запись
    @Override
    public void store(Country item) {
        item.setId(0L);
        repository.saveAndFlush(item);
    }

    // изменить запись
    @Override
    public void update(Country item) {
        repository.saveAndFlush(item);
    }

    // информация о странах, для которых стоимость оформления визы есть 
    // значение из некоторого диапазона
    public List<Country> findAllByCostVisaBetween(int costVisaMin, int costVisaMax) {
        return repository.findAllByCostVisaBetween(costVisaMin, costVisaMax);
    }

    // группировка по полю Страна назначения. Для каждой страны вычисляется среднее значение 
    // по полю Стоимость транспортных услуг
    public List<Query08> groupByCountry() {
        return repository.groupByCountry();
    }
}
