package app.models.task02;

import app.utils.Utils;


// Класс Персона
public class Person {

    // id персоны
    public int id;

    // фамилия
    public String surname;

    // имя
    public String name;

    // возраст
    public int age;

    // название города
    public String city;

    // рост
    public int height;


    // конструктор по умолчанию
    public Person() {}

    // конструктор инициализирующий
    public Person(int id, String surname, String name, int age, String city, int height) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.city = city;
        this.height = height;
    }


    // вывод персоны в строку таблицы
    public String toTableRow() {
        return String.format(
                "<tr><th>%d</th><td>%s</td><td>%s</td><td>%s</td><td align='right'>%d</td><td align='right'>%d</td>",
                id, surname, name, city, age, height
        );
    }

    // фабричный метод
    public static Person factory(int id) {
        String[] person = Utils.getItem(Utils.people);

        return new Person(
                id,
                person[0],
                person[1],
                Utils.getInt(20, 50),
                Utils.getItem(Utils.cities),
                Utils.getInt(170, 190)
        );
    }

    // вывод объекта в формате csv
    public String toCsv() {
        return String.format("%d;%s;%s;%d;%s;%d\n", id, surname, name, age, city, height);
    }

    // получить данные с формата csv
    public static Person getFromCsv(String line) {
        var values = line.split(";");
        return new Person(
                Integer.parseInt(values[0]),
                values[1],
                values[2],
                Integer.parseInt(values[3]),
                values[4],
                Integer.parseInt(values[5])
        );
    }
}
