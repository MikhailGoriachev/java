package app.models.task03;


import java.io.Serializable;

// Класс Товар
public class Goods implements Serializable {

    // наименование
    private String name;

    public String name() {return name;}

    public void name(String name) throws Exception {
        if (name.isEmpty()) throw new Exception("Goods: поле Name не может быть пустым");
        this.name = name;
    }

    // количество
    private int amount;

    public int amount() {return amount;}

    public void amount(int amount) throws Exception {
        if (amount < 0) throw new Exception("Goods: поле Amount должно быть больше или равно 0");
        this.amount = amount;
    }

    // цена единицы товара
    private int price;

    public int price() {return price;}

    public void price(int price) throws Exception {
        if (price < 0) throw new Exception("Goods: поле Price должно быть больше или равно 0");
        this.price = price;
    }

    // стоимость
    public int cost() {return price * amount;}

    // конструктор по умолчанию
    public Goods() {}

    // конструктор инициализирующий
    public Goods(String name, int amount, int price) throws Exception {
        this.name(name);
        this.amount(amount);
        this.price(price);
    }


    // получить данные в формате csv
    public String getCsv() {
        return String.format("%s;%d;%d\n", name, amount, price);
    }

    // получить объект из csv
    public static Goods setCsv(String line) throws Exception {
        var data = line.split(";");
        return new Goods(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]));
    }

    // вывод в строку таблицы
    public String toTableRow(int n) {
        return String.format("<tr><td>%s</td><td align='right'>%d</td><td align='right'>%.2f</td><td align='right'>%.2f</td></tr>", 
                name, amount, (double)price, (double)cost());
    }
}
