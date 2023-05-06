package org.homework.app.middleware;


import org.homework.app.repositories.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// Класс для получения репозиториев из контекста (для удобства работы)
public class Repositories {
    
    // контекст
    public static ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    
    
    // товаровы
    public static GoodsRepository getGoodsRepository() {
        return context.getBean(GoodsRepository.class);
    }
    
    // персоны
    public static PeopleRepository getPeopleRepository() {
        return context.getBean(PeopleRepository.class);
    }
    
    // закупки
    public static PurchasesRepository getPurchasesRepository() {
        return context.getBean(PurchasesRepository.class);
    }
    
    // продажи
    public static SalesRepository getSalesRepository() {
        return context.getBean(SalesRepository.class);
    }
    
    // продавцы
    public static SellersRepository getSellersRepository() {
        return context.getBean(SellersRepository.class);
    }
    
    // единицы измерения
    public static UnitsRepository getUnitsRepository() {
        return context.getBean(UnitsRepository.class);
    }
}
