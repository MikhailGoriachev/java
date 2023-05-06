package org.homework.app.services;

import org.homework.app.entries.Seller;
import org.homework.app.models.Query07;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SellersService {
    
    // все записи
    List<Seller> findAll();
    
    // запись по id
    Seller findById(Long id);
    
    // добавить запись
    void store(Seller item);
    
    // изменить запись
    void update(Seller item);
    
    // выбирает информацию о продавцах с заданным значением процента комиссионных. 
    // Значение задавать параметром
    List<Seller> findAllByInterest(int interest);
    
    // для всех продавцов вывести сумму и количество продаж, минимальную и 
    // максимальную стоимости продаж
    List<Query07> groupBySeller();
}
