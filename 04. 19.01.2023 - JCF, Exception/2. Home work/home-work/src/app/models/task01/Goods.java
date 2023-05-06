package app.models.task01;

import app.utils.Utils;

// Класс Товар
public class Goods {
    
    // id товара
    public int id;

    // наименование товара
    private String name;

    public String name() {return name;}

    public String name(String name) throws Exception {
        if (!name.isEmpty()) return this.name = name;
        throw new Exception("Goods: поле Plane не может быть пустым!");
    }

    // количество товара
    private int amount;

    public int amount() {return amount;}

    public int amount(int amount) throws Exception {
        if (amount > 0) return this.amount = amount;
        throw new Exception("Goods: поле Goods должно быть больше 0!");
    }

    // цена единицы
    private double price;

    public double price() {return price;}

    public double price(double price) throws Exception {
        if (price > 0) return this.price = price;
        throw new Exception("Goods: поле Price должно быть больше 0!");
    }


    // конструктор по умолчанию
    public Goods() {}

    // конструктор инициализирующий
    public Goods(int id, String name, int amount, double price) throws Exception {
        this.id = id;
        this.name(name);
        this.amount(amount);
        this.price(price);
    }


    // вывод в строку таблицы
    public String toTableRow() {
        return String.format(
                "<tr><th>%s</th><td>%s</td><td align='right'>%d</td><td align='right'>%.2f</td>",
                id, name, amount, price
        );
    }

    // фабричный метод
    public static Goods factory(int id) throws Exception {
        return new Goods(id, Utils.getItem(Utils.goodsNameList),Utils.getInt(2,10), Utils.getDouble(1e3,4e3));
    }
}
