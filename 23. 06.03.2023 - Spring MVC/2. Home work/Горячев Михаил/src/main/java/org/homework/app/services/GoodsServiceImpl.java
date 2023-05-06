package org.homework.app.services;

import org.homework.app.entries.Goods;
import org.homework.app.models.Query06;
import org.homework.app.repositories.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GoodsServiceImpl implements GoodsService {
    
    // репозиторий
    private GoodsRepository repository;
    
    @Autowired
    public void setRepository(GoodsRepository repository) {
        this.repository = repository;
    };
    
    // сервис
    @Autowired
    private GoodsService service;
    
    
    // все записи
    @Override
    public List<Goods> findAll() {
        return repository.findAll();
    }

    // запись по id
    @Override
    public Goods findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // добавить запись
    @Override
    public void store(Goods item) {
        item.setId(null);
        repository.saveAndFlush(item);
    }

    // изменить запись
    @Override
    public void update(Goods item) {
        repository.saveAndFlush(item);
    }

    // выполняет группировку по наименованию закупленного товара. Для каждого наименования 
    // вычисляет среднюю цену закупки товара, количество закупок
    @Override
    public List<Query06> groupByName() {
        return repository.groupByName(); 
    }
}
