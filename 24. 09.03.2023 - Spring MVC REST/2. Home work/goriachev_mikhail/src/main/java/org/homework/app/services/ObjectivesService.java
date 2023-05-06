package org.homework.app.services;

import org.homework.app.entries.Objective;

import java.util.List;


public interface ObjectivesService {
    
    // все записи
    List<Objective> findAll();
    
    // запись по id
    Objective findById(Long id);
    
    // добавить запись
    void store(Objective item);
    
    // изменить запись
    void update(Objective item);    
}
