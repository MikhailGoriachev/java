package org.itstep.pd011.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

// единицы измерения количества товара
@Entity
@Table(name="units")
@Getter
@Setter
public class Unit {
    // первичный ключ
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // краткое наименование единицы измерения количества товара
    @Column(name="short", length = 10)
    public String shortName;

    // полное наименование единицы измерения количества товара
    @Column(name="full", length = 35)
    public String fullName;

    // предоставляем конструктор по умолчанию
    public Unit() {} // Unit

    @Override
    public String toString() {
        return String.format("Unit{%d: \"%s\"; \"%s\"}", id, shortName, fullName);
    } // toString
} // class Unit

