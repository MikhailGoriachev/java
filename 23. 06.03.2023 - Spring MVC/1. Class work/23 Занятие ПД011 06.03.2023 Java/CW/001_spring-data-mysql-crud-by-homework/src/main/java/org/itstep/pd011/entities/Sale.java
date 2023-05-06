package org.itstep.pd011.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

// учет фактов продаж
@Entity
@Table(name="sales")
@Getter
@Setter
public class Sale {
    // первичный ключ
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    // проданный товар (продаем только из закупленных товаров, без проверки наличия)
    @ManyToOne
    private Purchase purchase;

    // единица измерения
    @ManyToOne
    private Unit unit;

    // продавец, выполнивший продажу
    @ManyToOne
    private Seller seller;

    // дата продажи
    @Column(name="sale_date")
    private Date saleDate;

    // цена продажи
    @Column(name = "price")
    private int price;

    // количество проданного товара
    @Column(name="amount")
    private int amount;

    // предоставляем конструктор по умолчанию
    public Sale() {} // Sale

    // предоставляем конструктор для добавления записи в таблицу
    public Sale(Purchase purchase, Unit unit, Seller seller, Date saleDate, int price, int amount) {
        this.id = null;

        this.purchase = purchase;
        this.unit = unit;
        this.seller = seller;
        this.saleDate = saleDate;
        this.price = price;
        this.amount = amount;
    }

    // вычисление прибыли от продажи
    public int getProfit() {
        //               доходы - расходы
        return amount * (price - purchase.getPrice());
    } // getProfit

    // строковое представление
    @Override
    public String toString() {
        var purchase = getPurchase();
        var seller = getSeller();
        var person = seller.getPerson();

        return String.format(
        "Sale{%d: %s -> %s %c.%c. -> %s З: %d.00 руб. П: %d.00 руб. К: %d %s. С: %d.00 руб.}",
        id, saleDate,
        person.getSurname(), person.getName().charAt(0), person.getPatronymic().charAt(0),
        purchase.getProduct().getName(), purchase.getPrice(),
        price, amount, purchase.getUnit().getShortName(), price*amount
    );}
} // class Sale
