package org.homework.app.services;

import org.homework.app.entries.Unit;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UnitsService {
    
    // все записи
    List<Unit> findAll();
    
    // запись по id
    Unit findById(Long id);
    
    // добавить запись
    void store(Unit item);
    
    // изменить запись
    void update(Unit item);
}
