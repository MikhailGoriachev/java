package org.homework.app.services;

import org.homework.app.entries.Objective;
import org.homework.app.repositories.ObjectivesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ObjectivesServiceImpl implements ObjectivesService {
    
    // репозиторий
    private ObjectivesRepository repository;
    
    @Autowired
    public void setRepository(ObjectivesRepository repository) {
        this.repository = repository;
    }
    
    // сервис
    @Autowired
    private ObjectivesService service;
    
    // все записи
    @Override
    public List<Objective> findAll() {
        return repository.findAll();
    }

    // запись по Id
    @Override
    public Objective findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // добавить запись
    @Override
    public void store(Objective item) {
        item.setId(0L);
        repository.saveAndFlush(item);
    }

    // изменить запись
    @Override
    public void update(Objective item) {
        repository.saveAndFlush(item);
    }
}
