package app.models.task01;

import app.utils.Files;
import app.utils.Utils;

import java.io.*;


// Класс Персона
public class Person {

    // длина текстового поля
    public static final int TEXT_FIELD_LENGTH = 50;

    // общий размер записи
    public static final int FULL_LENGTH = (Integer.BYTES * 3) + TEXT_FIELD_LENGTH * 4;

    // id персоны
    private int id;

    public int id() {return id;}

    public int id(int id) {return this.id = id;}

    // фамилия
    private String surname;

    public String surname() {return surname;}

    public String surname(String surname) throws Exception {
        if (surname.isEmpty()) throw new Exception("Person: поле Surname не может быть пустым");
        return this.surname = surname;
    }

    // имя
    private String name;

    public String name() {return name;}

    public String name(String name) throws Exception {
        if (name.isEmpty()) throw new Exception("Person: поле Name не может быть пустым");
        return this.name = name;
    }

    // возраст
    private int age;

    public int age() {return age;}

    public int age(int age) throws Exception {
        if (age < 0) throw new Exception("Person: поле Age должно быть больше либо равно 0");
        return this.age = age;
    }

    // название города
    private String city;

    public String city() {return city;}

    public String city(String city) throws Exception {
        if (city.isEmpty()) throw new Exception("Person: поле City не может быть пустым");
        return this.city = city;
    }

    // профессия
    private String profession;

    public String profession() {return profession;}

    public String profession(String profession) throws Exception {
        if (profession.isEmpty()) throw new Exception("Person: поле Profession не может быть пустым");
        return this.profession = profession;
    }

    // оклад
    private int salary;

    public int salary() {return salary;}

    public int salary(int salary) throws Exception {
        if (salary < 0) throw new Exception("Person: поле Salary должно быть больше либо равно 0");
        return this.salary = salary;
    }


    // конструктор по умолчанию
    public Person() {}

    // конструктор инициализирующий
    public Person(int id, String surname, String name, int age, String city, String profession, int salary) throws Exception {
        this.id(id);
        this.surname(surname);
        this.name(name);
        this.age(age);
        this.city(city);
        this.profession(profession);
        this.salary(salary);
    }


    // вывод персоны в строку таблицы
    public String toTableRow() {
        return String.format(
                "<tr><th>%d</th><td>%s</td><td>%s</td><td>%s</td><td align='right'>%d</td><td>%s</td><td align='right'>%d</td>",
                id, surname, name, city, age, profession, salary
        );
    }

    // фабричный метод
    public static Person factory(int id) {
        String[] person = Utils.getItem(Utils.people);

        try {
            return new Person(
                    id,
                    person[0],
                    person[1],
                    Utils.getInt(20, 50),
                    Utils.getItem(Utils.cities),
                    Utils.getItem(Utils.professions),
                    Utils.getInt(40, 80) * 1000
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // вывод объекта в бинарном формате
    public void saveToBinData(DataOutput stream) {
        try {
            stream.writeInt(id);
            Files.writeString(stream, surname, TEXT_FIELD_LENGTH);
            Files.writeString(stream, name, TEXT_FIELD_LENGTH);
            stream.writeInt(age);
            Files.writeString(stream, surname, TEXT_FIELD_LENGTH);
            Files.writeString(stream, name, TEXT_FIELD_LENGTH);
            stream.writeInt(age);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // получить данные из бинарного формата
    public static Person loadFromBinData(DataInput stream) {
        try {
            return new Person(
                    stream.readInt(),
                    Files.readString(stream, TEXT_FIELD_LENGTH),
                    Files.readString(stream, TEXT_FIELD_LENGTH),
                    stream.readInt(),
                    Files.readString(stream, TEXT_FIELD_LENGTH),
                    Files.readString(stream, TEXT_FIELD_LENGTH),
                    stream.readInt()
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
