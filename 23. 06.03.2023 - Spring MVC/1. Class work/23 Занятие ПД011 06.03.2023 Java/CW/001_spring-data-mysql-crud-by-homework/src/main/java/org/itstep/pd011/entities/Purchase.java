package org.itstep.pd011.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

// сведения о факте закупки товара
@Entity
@Table(name = "purchases")
@Getter
@Setter
public class Purchase {
    // первичный ключ
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // связное свойство к справочнику товаров
    @ManyToOne
    private Product product;

    // связное свойство к справочнику единиц измерения
    @ManyToOne
    private Unit unit;

    // дата закупки
    @Column(name="purchase_date")
    private Date purchaseDate;

    // закупочная цена
    private int price;

    // количество товара в закупке
    private int amount;

    // предоставляем конструктор по умолчанию
    public Purchase() {} // Purchase

    // строковое представление
    @Override
    public String toString() { return String.format(
        "Purchase{%d: \"%s\" %s %d.00 руб. %d %s}",
        id, product.getName(), purchaseDate, price, amount, unit.getShortName()
    );}
} // class Purchase
