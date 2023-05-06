package app.models.task01;


import app.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Класс Магазин
public class Store {

    // коллекция товаров
    public List<Goods> goodsList;


    // конструктор по умолчанию
    public Store() throws Exception {
        goodsList = new ArrayList<>();
        initialization();
    }

    // конструктор
    public Store(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }


    // формирование коллекции (начальное заполнение коллекции, не менее 12 записей);
    public void initialization() throws Exception {
        goodsList.clear();

        var n = Utils.getInt(10, 12);
        for (int i = 0; i < n; i++) {
            goodsList.add(Goods.factory(i + 1));
        }
    }

    // упорядочивание коллекции по наименованию товара (сортирует копию)
    public List<Goods> orderByName() {
        var goodsSort = new ArrayList<>(goodsList);

        // goodsSort.sort((a, b) -> a.name().compareTo(b.name()));
        goodsSort.sort(Comparator.comparing(Goods::name));

        return goodsSort;
    }


    // упорядочивание коллекции по убыванию цены единицы товара (сортирует копию)
    public List<Goods> orderByPrice() {
        var goodsSort = new ArrayList<>(goodsList);

        goodsSort.sort((a, b) -> Double.compare(b.price(), a.price()));

        return goodsSort;
    }

    // формирование коллекции товаров с минимальной ценой
    public List<Goods> goodsByMinPrice() {
        // var min = Collections.min(goodsList, (a, b) -> Double.compare(a.price(), b.price()));
        var min = Collections.min(goodsList, Comparator.comparingDouble(Goods::price)).price();

        var select = new ArrayList<Goods>();
        goodsList.forEach((a) -> {if (Utils.doubleCompare(min, a.price())) select.add(a);});

        return select;
    }

    // формирование коллекции товаров с максимальной ценой
    public List<Goods> goodsByMaxPrice() {
        // var min = Collections.min(goodsList, (a, b) -> Double.compare(a.price(), b.price()));
        var min = Collections.max(goodsList, Comparator.comparingDouble(Goods::price)).price();

        var select = new ArrayList<Goods>();
        goodsList.forEach((a) -> {if (Utils.doubleCompare(min, a.price())) select.add(a);});

        return select;
    }

    // вывод коллекции в виде таблицы
    public String goodsToTable() {
        StringBuilder sb = new StringBuilder();
        sb.append("<table align='center' border='1' cellspacing='0' cellpadding='8'><thead>")
                .append("<tr><th>Id</th><th>Наименование</th><th>Количество</th><th>Цена (&#8381;)</th></tr>")
                .append("</thead><tbody>");

        goodsList.forEach(g -> sb.append(g.toTableRow()));

        sb.append("</tbody></table>");

        return sb.toString();
    }

    // вывод коллекции в виде таблицы
    public static String goodsToTable(List<Goods> goods) {
        StringBuilder sb = new StringBuilder();
        sb.append("<table align='center' border='1' cellspacing='0' cellpadding='8'><thead>")
                .append("<tr><th>Id</th><th>Наименование</th><th>Количество</th><th>Цена (&#8381;)</th></tr>")
                .append("</thead><tbody>");

        goods.forEach(g -> sb.append(g.toTableRow()));

        sb.append("</tbody></table>");

        return sb.toString();
    }
}
