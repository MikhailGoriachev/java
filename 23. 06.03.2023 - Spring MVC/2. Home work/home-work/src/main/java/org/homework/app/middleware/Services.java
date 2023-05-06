package org.homework.app.middleware;

import org.homework.app.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Services {
    
    // товары
    @Autowired
    public GoodsService goodsService;
    
    // персоны
    @Autowired
    public PeopleService peopleService;
    
    // закупки
    @Autowired
    public PurchasesService purchasesService;
    
    // продажи
    @Autowired
    public SalesService salesService;
    
    // продавцы
    @Autowired
    public SellersService sellersService;
    
    // единицы измерения
    @Autowired
    public UnitsService unitsService;
}
