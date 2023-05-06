package org.itstep.pd011.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

// персональные данные (в этой БД - продавца)
@Entity
@Table(name = "persons")
@Getter
@Setter
public class Person {
    // первичный ключ
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // фамилия
    @Column(name = "surname", length = 50)
    private String surname;

    // имя
    @Column(name = "name", length = 50)
    private String name;

    // отчество
    @Column(name = "patronymic", length = 60)
    private String patronymic;

    // номер и серия паспорта
    @Column(name = "passport", length = 60, unique = true)
    private String passport;

    // предоставляем конструктор по умолчанию
    public Person() {} // Person

    // строковое представление
    @Override
    public String toString() {
        return String.format("Person{%d: %s %s %s; %s", id, surname, name, patronymic, passport);
    }
} // class Person
