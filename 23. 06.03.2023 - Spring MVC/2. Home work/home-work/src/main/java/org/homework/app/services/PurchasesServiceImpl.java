package org.homework.app.services;

import org.homework.app.entries.Purchase;
import org.homework.app.repositories.PurchasesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PurchasesServiceImpl implements PurchasesService {

    // репозиторий
    private PurchasesRepository purchasesRepository;

    // сервис
    @Autowired
    private PurchasesService purchasesService;

    @Autowired
    public void setPurchasesRepository(PurchasesRepository purchasesRepository) {
        this.purchasesRepository = purchasesRepository;
    }


    // все записи
    @Override
    public List<Purchase> findAll() {
        return purchasesRepository.findAll();
    }

    // запись по id
    @Override
    public Purchase findById(Long id) {
        return purchasesRepository.findById(id).orElse(null);
    }

    // добавить запись
    @Override
    public void store(Purchase item) {
        item.setId(null);
        purchasesRepository.saveAndFlush(item);
    }

    // изменить запись
    @Override
    public void update(Purchase item) {
        purchasesRepository.saveAndFlush(item);
    }

    // выбирает из информацию о товарах, единицей измерения которых является «шт» (штуки) и цена закупки составляет 
    // меньше 200 руб. Значения задавать параметрами
    @Override
    public List<Purchase> findAllByUnitShortNameAndPriceLessThan(String shortName, int price) {
        return purchasesRepository.findAllByUnitShortNameAndPriceLessThan(shortName, price);
    }

    // выбирает информацию о товарах, цена закупки которых меньше 500 руб. за единицу товара. Значения задавать
    // параметрами
    @Override
    public List<Purchase> findAllByPriceLessThan(int price) {
        return purchasesRepository.findAllByPriceLessThan(price);
    }
}
