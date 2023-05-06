package org.homework.app.services;

import org.homework.app.entries.Goods;
import org.homework.app.models.Query06;
import org.springframework.stereotype.Service;

import java.util.List;

public interface GoodsService {
    
    // все записи
    List<Goods> findAll();
    
    // запись по id
    Goods findById(Long id);
    
    // добавить запись
    void store(Goods item);
    
    // изменить запись
    void update(Goods item);
    
    // выполняет группировку по наименованию закупленного товара. Для каждого наименования 
    // вычисляет среднюю цену закупки товара, количество закупок
    List<Query06> groupByName();
}
