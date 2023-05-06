package org.homework.app.services;

import org.homework.app.entries.Seller;
import org.homework.app.models.Query07;
import org.homework.app.repositories.SellersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SellersServiceImpl implements SellersService {
    
    // репозиторий
    private SellersRepository repository;
    
    // сервис
    @Autowired
    private SellersService service;
    
    @Autowired
    public void setRepository(SellersRepository repository) {
        this.repository = repository;
    };
    
    
    // все записи
    @Override
    public List<Seller> findAll() {
        return repository.findAll();
    }

    // запись по id
    @Override
    public Seller findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // добавить запись
    @Override
    public void store(Seller item) {
        item.setId(null);
        repository.saveAndFlush(item);
    }

    // изменить запись
    @Override
    public void update(Seller item) {
        repository.saveAndFlush(item);
    }

    // выбирает информацию о продавцах с заданным значением процента комиссионных. 
    // Значение задавать параметром
    @Override
    public List<Seller> findAllByInterest(int interest) {
        return repository.findAllByInterest(interest);
    }

    // для всех продавцов вывести сумму и количество продаж, минимальную и 
    // максимальную стоимости продаж
    public List<Query07> groupBySeller() {
        return repository.groupBySeller();    
    }
}
