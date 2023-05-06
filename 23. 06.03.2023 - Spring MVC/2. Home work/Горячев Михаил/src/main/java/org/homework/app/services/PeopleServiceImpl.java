package org.homework.app.services;

import org.homework.app.entries.Person;
import org.homework.app.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PeopleServiceImpl implements PeopleService {
    
    // репозиторий
    private PeopleRepository repository;
    
    // сервис
    @Autowired
    private PeopleService service;
    
    @Autowired
    public void setRepository(PeopleRepository repository) {
        this.repository = repository;
    };
    
    
    // все записи
    @Override
    public List<Person> findAll() {
        return repository.findAll();
    }

    // запись по id
    @Override
    public Person findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // добавить запись
    @Override
    public void store(Person item) {
        item.setId(null);
        repository.saveAndFlush(item);
    }

    // изменить запись
    @Override
    public void update(Person item) {
        repository.saveAndFlush(item);
    }
}
