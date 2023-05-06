package org.homework.app.entries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.homework.app.utils.Utils;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


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

    // единица измерения
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
    public int getIncome() {
        return (price - purchase.getPrice()) * amount;
    }

    // вывод с троку таблицы
    public String toTableRow() {
        return String.format(
                "<tr><th>%d</th><td>%s</td><td>%s</td><td>%s %s. %s.</td><td>%s</td><td>%d</td><td>%d</td><td>%d</td></tr>",
                id,
                purchase.getGoods().getName(),
                unit.getShortName(),
                seller.getPerson().getSurname(),
                seller.getPerson().getName().charAt(0),
                seller.getPerson().getPatronymic().charAt(0),
                Utils.dateToFormat(saleDate),
                purchase.getPrice(),
                price,
                amount
        );
    }

    // вывод с троку таблицы с полем прибыль
    public String toTableRowWithIncome() {
        return String.format(
                "<tr><th>%d</th><td>%s</td><td>%s</td><td>%s %s. %s.</td><td>%s</td><td>%d</td><td>%d</td><td>%d</td><td>%d</td></tr>",
                id,
                purchase.getGoods().getName(),
                unit.getShortName(),
                seller.getPerson().getSurname(),
                seller.getPerson().getName().charAt(0),
                seller.getPerson().getPatronymic().charAt(0),
                Utils.dateToFormat(saleDate),
                purchase.getPrice(),
                price,
                amount,
                getIncome()
        );
    }

    // вывод html таблицы
    public static String toTableHtml(List<Sale> list, String title) {
        var sb = new StringBuilder();
        sb.append("<html><table align='center' border='1' cellspacing='0' cellpadding='8'><thead>")
                .append("<tr>")
                .append("<th colspan='7'>")
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
                .append("<th>Продавец</th>")
                .append("<th>Дата</th>")
                .append("<th>Цена закупки (&#8381;)</th>")
                .append("<th>Цена продажи (&#8381;)</th>")
                .append("<th>Количество</th>")
                .append("</thead><tbody>");

        list.forEach((c) -> sb.append(c.toTableRow()));

        sb.append("</tbody></table>");

        return sb.toString();
    }

    // вывод html таблицы с полем прибыль
    public static String toTableHtmlWithIncome(List<Sale> list, String title) {
        var sb = new StringBuilder();
        sb.append("<html><table align='center' border='1' cellspacing='0' cellpadding='8'><thead>")
                .append("<tr>")
                .append("<th colspan='8'>")
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
                .append("<th>Продавец</th>")
                .append("<th>Дата</th>")
                .append("<th>Цена закупки (&#8381;)</th>")
                .append("<th>Цена продажи (&#8381;)</th>")
                .append("<th>Количество</th>")
                .append("<th>Прибыль (&#8381;)</th>")
                .append("</thead><tbody>");

        list.forEach((c) -> sb.append(c.toTableRowWithIncome()));

        sb.append("</tbody></table>");

        return sb.toString();
    }

    @Override
    public String toString() {
        return String.format(
                "| Id: %d | Товар: %s | Ед. изм.:%s | Продавец: %s %s. %s. | Дата: %s | Цена закуп.: %d" +
                        " | Цена продаж.: %d | Количество: %d |",
                id,
                purchase.getGoods().getName(),
                unit.getShortName(),
                seller.getPerson().getSurname(),
                seller.getPerson().getName().charAt(0),
                seller.getPerson().getPatronymic().charAt(0),
                Utils.dateToFormat(saleDate),
                purchase.getPrice(),
                price,
                amount
        );
    }
}
