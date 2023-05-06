package app.models.task03;

/* 
    Mobile, описывающий мобильный телефон (фирма-разработчик, название модели, стоимость,
    год выпуска). Создайте и проинициируйте массив из 12 элементов класса Mobile (коллекцию мобильных телефонов).
 */

// Класс Телефон
public class Mobile {

    // фирма-разработчик
    public String brand;

    // модель
    public String model;

    // стоимость
    public int price;

    // год выпуска
    public int year;


    // конструктор по умолчанию
    public Mobile() {
    }

    // конструктор инициализирующий
    public Mobile(String brand, String model, int price, int year) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.year = year;
    }

    // вывод в строку таблицы
    public String toTableRow(int n) {
        return "<tr>" +
                "<th>" + n +"</td>" +
                "<td>" + brand + "</td>" +
                "<td>" + model + "</td>" +
                "<td>" + price + "&#8381;</td>" +
                "<td>" + brand + "</td>" +
                "<td>" + year + "</td>" +
                "</tr>";
    }
}
