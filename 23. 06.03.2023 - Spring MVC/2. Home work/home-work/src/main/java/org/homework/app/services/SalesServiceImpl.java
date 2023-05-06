package org.homework.app.services;

import org.homework.app.entries.Sale;
import org.homework.app.repositories.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SalesServiceImpl implements SalesService {
    
    // репозиторий
    private SalesRepository repository;
    
    // сервис
    @Autowired
    private SalesService service;
    
    @Autowired
    public void setRepository(SalesRepository repository) {
        this.repository = repository;
    };
    
    
    // все записи
    @Override
    public List<Sale> findAll() {
        return repository.findAll();
    }

    // запись по id
    @Override
    public Sale findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // добавить запись
    @Override
    public void store(Sale item) {
        item.setId(null);
        repository.saveAndFlush(item);
    }

    // изменить запись
    @Override
    public void update(Sale item) {
        repository.saveAndFlush(item);
    }

    // удалить запись
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    // Выбирает информацию обо всех зафиксированных фактах продажи товаров (Наименование товара, Цена закупки, Цена 
    // продажи, дата продажи), для которых Цена продажи оказалась в некоторых заданных границах. Значения задавать 
    // параметрами
    @Override
    public List<Sale> findAllByPriceBetween(int priceMin, int priceMax) {
        return repository.findAllByPriceBetween(priceMin, priceMax);
    }
}
