package org.itstep.pd011.models;

import java.io.Serializable;

// делаем JavaBean
// Класс Java Bean должен соответствовать ряду ограничений:
//    ► иметь конструктор, который не принимает никаких параметров
//    ► определять для всех свойств, которые используются в jsp, методы геттеры и сеттеры
//    ► названия геттеров и сеттеров должны соответствовать условностям: перед именем
//      переменной добавляется get (для геттера) и set (для сеттера), а название переменной
//      включается с большой буквы.
//      Например, если переменная называется firstName, то функции геттера и сеттера должны
//      называться соответственно getFirstName и setFirstName.
//      Однако для переменных типа boolean для функции геттера используется вместо get
//      приставка is. Например, переменная enabled и геттер isEnabled.
//    ► реализовать интерфейс Serializable или Externalizable
public class Student implements Serializable {

    String surname;
    String name;
    String patronymic;
    int birthYear;
    String city;
    String group;

    public Student() {
        this("Иванов", "Иван", "Иванович", 1998, "Алчевск", "СП-1221");
    }

    public Student(String surname, String name, String patronymic, int birthYear, String city, String group) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthYear = birthYear;
        this.city = city;
        this.group = group;
    } // Student


    //region Геттеры и сеттеры
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
    //endregion

    public String toHtmlList() {
        return String.format("<ul><li>Фамилия: <b>%s</b></li><li>Имя: <b>%s</b></li><li>Отчество: <b>%s</b></li>" +
                        "<li>Год рождения: <b>%d</b></li><li>Город: <b>%s</b></li><li>Группа: <b>%s</b></li></ul>",
                surname, name, patronymic, birthYear, city, group);
    } // toHtmlList
} // class Student
