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

    
    // вывод с троку таблицы
    public String toTableRow() {
        return String.format(
                "<tr><th>%d</th><td>%s</td><td>%s</td><td>%s</td><td>%d</td><td>%d</td></tr>",
                id, 
                goods.getName(),
                unit.getShortName(),
                Utils.dateToFormat(purchaseDate),
                price,
                amount
        );
    }

    // вывод html таблицы
    public static String toTableHtml(List<Purchase> list, String title) {
        var sb = new StringBuilder();
        sb.append("<html><table align='center' border='1' cellspacing='0' cellpadding='8'><thead>")
                .append("<tr>")
                .append("<th colspan='5'>")
                .append(title)
                .append("</th>")
                .append("<th>")
                .append("Количество:").append(list.size())
                .append("</th>")
                .append("</tr>")
                .append("<tr>")
                .append("<th>Id</th>")
                .append("<th>Товар</th>")
                .append("<th>Единица измерения</th>")
                .append("<th>Дата закупки</th>")
                .append("<th>Цена (&#8381;)</th>")
                .append("<th>Количество</th>")
                .append("</thead><tbody>");

        list.forEach((c) -> sb.append(c.toTableRow()));

        sb.append("</tbody></table>");

        return sb.toString();
    }
}
