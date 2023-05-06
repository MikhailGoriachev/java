package org.itstep.pd011.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

// сведения о продавце
@Entity
@Table(name = "sellers")
@Getter
@Setter
public class Seller {
    // первичный ключ
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    // связное свойство - связь с персональными данными
    // д.б. person_id
    @ManyToOne
    private Person person;

    // процент отчислений с продаж
    @Column(name = "interest")
    private Double interest;

    // предоставляем конструктор по умолчанию
    public Seller() {} // Seller

    // строковое представление
    @Override
    public String toString() { return String.format(
        "Seller{%d: %s %s %s; %s; %.2f}",
        id, person.getSurname(), person.getName(), person.getPatronymic(),
        person.getPassport(), interest
    );} // toString
} // class Seller
