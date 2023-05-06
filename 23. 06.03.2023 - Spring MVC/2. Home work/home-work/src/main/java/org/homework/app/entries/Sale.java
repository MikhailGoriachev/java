package org.homework.app.entries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


// Класс Продажа
@Entity
@Table(name = "sales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // закупка
    @ManyToOne
    private Purchase purchase;

    // единица товара
    @ManyToOne
    private Unit unit;

    // продавец
    @ManyToOne
    private Seller seller;

    // дата продажи
    @Column(name = "sale_date")
    @Temporal(TemporalType.DATE)
    private Date saleDate;

    // цена
    @Column(name = "price")
    private int price;

    // количество
    @Column(name = "amount")
    private int amount;


    // вычислить прибыль от продажи
    public int income() {
        return (price - purchase.getPrice()) * amount;
    }
}
