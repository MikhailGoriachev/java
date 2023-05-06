package org.itstep.pd011.models;

import java.io.Serializable;

// делаем JavaBean
public class Student implements Serializable, Cloneable {

    String surname;
    String name;
    String patronymic;
    int birthYear;
    String city;
    String group;

    public Student() {}

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

    @Override
    public String toString() {
        return "Student{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthYear=" + birthYear +
                ", city='" + city + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}
