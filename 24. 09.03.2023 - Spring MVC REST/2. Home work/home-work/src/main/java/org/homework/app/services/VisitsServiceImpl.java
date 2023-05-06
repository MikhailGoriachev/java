package org.homework.app.services;

import org.homework.app.entries.Visit;
import org.homework.app.repositories.VisitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VisitsServiceImpl implements VisitsService {
    
    // репозиторий
    private VisitsRepository repository;
    
    @Autowired
    public void setRepository(VisitsRepository repository) {
        this.repository = repository;
    }
    
    // сервис
    @Autowired
    private VisitsService service;
    
    // все записи
    @Override
    public List<Visit> findAll() {
        return repository.findAll();
    }

    // запись по Id
    @Override
    public Visit findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // добавить запись
    @Override
    public void store(Visit item) {
        item.setId(0L);
        repository.saveAndFlush(item);
    }

    // изменить запись
    @Override
    public void update(Visit item) {
        repository.saveAndFlush(item);
    }
    
    // удалить запись
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    // информация о клиентах, совершивших поездки с заданным количеством дней пребывания в стране
    public List<Visit> findAllByDuration(int duration) {
        return repository.findAllByDuration(duration);
    }

    // вычисление полной стоимости и ее полную стоимость с НДС для каждой поездки (метод в классе) 
    // сортировка по полю Страна назначения
    public List<Visit> findAllByOrderByRouteCountryName() {
        return repository.findAllByOrderByRouteCountryName();
    }
}
