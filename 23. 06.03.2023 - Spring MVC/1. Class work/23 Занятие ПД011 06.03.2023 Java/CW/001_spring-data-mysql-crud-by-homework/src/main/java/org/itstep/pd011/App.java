package org.itstep.pd011;

import org.itstep.pd011.entities.*;
import org.itstep.pd011.repositories.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;
import java.util.Comparator;
import java.util.List;

/**
 * Разработайте базу данных MySQL и консольное Spring Data приложение
 * для выполнения запросов по заданию. Все таблицы должны быть инициированы
 * не менее чем 10 записями.
 *
 */
public class App {

    public static void main( String[] args ) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // репозитории для работы с сущностями базы данных
        UnitRepository unitRepository = context.getBean(UnitRepository.class);
        PurchaseRepository purchaseRepository = context.getBean(PurchaseRepository.class);
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        SellerRepository sellerRepository = context.getBean(SellerRepository.class);
        SaleRepository saleRepository = context.getBean(SaleRepository.class);

        System.out.println("\n\033[1m*** начало работы ***\033[0m\n");

        // читаем все записи из таблицы единиц измерения
        System.out.println("units");
        List<Unit> unitList = unitRepository.findAll();
        unitList.forEach(System.out::println);
        System.out.println();

        // читаем все записи из таблицы справочника товаров
        System.out.println("products");
        List<Product> products = productRepository.findAll();
        products.forEach(System.out::println);
        System.out.println();

        // Запрос 1.
        // Выбирает информацию о товарах, единицей измерения которых является «шт» (штуки)
        // и цена закупки составляет меньше 500 руб. Значения задавать параметрами
        System.out.println("Запрос 1.");
        // List<Purchase> purchaseList =  purchaseRepository.findPurchasesBy("шт", 500);
        List<Purchase> purchaseList =  purchaseRepository.findPurchasesByUnitShortNameAndPriceLessThan("шт", 500);
        purchaseList.forEach(System.out::println);
        System.out.println();


        // Запрос 2.
        // Выбирает информацию о товарах, цена закупки которых меньше 500 руб.
        // за единицу товара. Значения задавать параметрами
        System.out.println("Запрос 2.");
        purchaseList = purchaseRepository.findPurchasesByPriceLessThan(500);
        purchaseList.forEach(System.out::println);
        System.out.println();


        // Запрос 3.
        // Выбирает информацию обо всех зафиксированных фактах продажи товаров
        // (Наименование товара, Цена закупки, Цена продажи, дата продажи),
        // для которых Цена продажи оказалась в некоторых заданных границах.
        // Значения задавать параметрами
        System.out.println("Запрос 3.");
        List<Sale> saleList = saleRepository.findSalesByPriceBetween(500, 1_000);
        saleList.forEach(System.out::println);
        System.out.println();


        // Запрос 4.
        // Вычисляет прибыль от продажи за каждый проданный товар. Включает поля
        // Дата продажи, Наименование товара, Цена закупки, Цена продажи,
        // Количество проданных единиц, Прибыль. Сортировка по полю Наименование
        // товара
        System.out.println("Запрос 4.");
        var sales = saleRepository.findByOrderByPurchaseProductName();
        sales.forEach(s -> System.out.format("%s Прибыль: %d.00 руб.\n", s, s.getProfit()));
        System.out.println();


        // Запрос 5.
        // Выполняет группировку по наименованию закупленного товара.
        // Для каждого наименования вычисляет среднюю цену закупки
        // товара, количество закупок
        // https://www.baeldung.com/jpa-queries-custom-result-with-aggregation-functions
        System.out.println("Запрос 5.");
        var reportQuery05 = purchaseRepository.query05();
        reportQuery05.forEach(c -> System.out.println(c.toResultString()));
        System.out.println();


        // Запрос 6.
        // Для всех продавцов вывести сумму и количество продаж, минимальную
        // и максимальную стоимости продаж
        System.out.println("Запрос 6.");
        var reportQuery06 = sellerRepository.query06();
        reportQuery06.forEach(c -> System.out.println(c.toResultString()));
        System.out.println();


        // Запрос 7.
        // Добавление факта продажи
        System.out.println("Запрос 7.");
        Purchase purchase = purchaseRepository.findById(1).get();
        Unit unit = unitRepository.findByShortName("шт");
        Seller seller = sellerRepository.findById(1).get();

        Sale sale = new Sale(
                purchase, unit, seller,
                new Date(2023 - 1900, 3 - 1, 6),
                purchase.getPrice()*2,
                1);

        sale = saleRepository.saveAndFlush(sale);
        System.out.println(sale);
        System.out.println();

        // Запрос 8.
        // Изменение количества проданного товара для факта продаж,
        // заданного идентификатором
        System.out.println("Запрос 8.");
        int id = 1, delta = 3;
        System.out.println(saleRepository.findById(id).get());
        query08(id, saleRepository, delta);
        System.out.println(saleRepository.findById(id).get());
        System.out.println();

        // Запрос 9.
        // Удаление факта продаж по идентификатору
        System.out.println("Запрос 9.");
        id = query09(saleRepository);
        System.out.printf("удалена запись о продаже с id: %d\n", id);
        System.out.println();


        System.out.println("\n\033[1m*** конец работы ***\033[0m\n");
    } // main

    // Запрос 8.
    // Изменение количества проданного товара для факта продаж,
    // заданного идентификатором
    private static void query08(int id, SaleRepository saleRepository, int delta) {
        var sale = saleRepository.findById(id).get();
        sale.setAmount(sale.getAmount()+delta);
        saleRepository.saveAndFlush(sale);
    } // query08


    // Запрос 9.
    // Удаление факта продаж по идентификатору
    private static int query09(SaleRepository saleRepository) {
        // а) получаем id для удадения - пусть это будет максимальный id
        int id = saleRepository
                .findAll()
                .stream()
                .max(Comparator.comparingLong(Sale::getId))
                .get()
                .getId();

        // б) собственно удаление записи по идентификатору
        saleRepository.deleteById(id);
        return id;
    }
} // class App
