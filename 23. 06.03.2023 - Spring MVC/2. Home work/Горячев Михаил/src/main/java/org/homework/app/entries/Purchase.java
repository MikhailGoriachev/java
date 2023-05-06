package org.homework.app.entries;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.homework.app.utils.Utils;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


// Класс Закупка
@Entity
@Table(name = "purchases")
@Getter
@Setter
@NoArgsConstructor
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // товар
    @ManyToOne
    private Goods goods;

    // единица измерения
    @ManyToOne
    private Unit unit;

    // дата
    @Column(name = "purchase_date")
    @Temporal(TemporalType.DATE)
    private Date purchaseDate;

    // цена
    @Column(name = "price")
    private int price;

    // количество
    @Column(name = "amount")
    private int amount;


    // строковое представление
    public String getToString() {
        return String.format(
                "%d. %s %d %s %s %d &#8381; ед.",
                id,
                goods.getName(),
                amount,
                unit.getShortName(),
                Utils.dateToFormat(purchaseDate),
                price
        );
    }
}
