package org.homework.app.services;

import org.homework.app.entries.Person;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PeopleService {
    
    // все записи
    List<Person> findAll();
    
    // запись по id
    Person findById(Long id);
    
    // добавить запись
    void store(Person item);
    
    // изменить запись
    void update(Person item);
}
