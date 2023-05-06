package org.homework.app.services;

import org.homework.app.entries.Unit;
import org.homework.app.repositories.UnitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UnitsServiceImpl implements UnitsService {
    
    // репозиторий
    private UnitsRepository repository;
    
    // сервис
    @Autowired
    private UnitsService service;
    
    @Autowired
    public void setRepository(UnitsRepository repository) {
        this.repository = repository;
    };
    
    
    // все записи
    @Override
    public List<Unit> findAll() {
        return repository.findAll();
    }

    // запись по id
    @Override
    public Unit findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // добавить запись
    @Override
    public void store(Unit item) {
        item.setId(null);
        repository.saveAndFlush(item);
    }

    // изменить запись
    @Override
    public void update(Unit item) {
        repository.saveAndFlush(item);
    }
}
