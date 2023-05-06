package org.homework.app.models;

import java.util.List;


public interface Query05 {
    
    // название товара
    String getGoodsName();
    
    // минимальная цена
    int getMinPrice();
    
    // средняя цена
    int getAvgPrice();
    
    // максимальная цена
    int getMaxPrice();
    
    // количество
    int getCount();

    // вывод с троку таблицы
    default String toTableRow() {
        return String.format(
                "<tr><td>%s</td><td>%d</td><td>%d</td><td>%d</td><td>%d</td></tr>",
                getGoodsName(),
                getMinPrice(),
                getAvgPrice(),
                getMaxPrice(),
                getCount()
        );
    }

    // вывод html таблицы
    static String toTableHtml(List<Query05> list, String title) {
        var sb = new StringBuilder();
        sb.append("<html><table align='center' border='1' cellspacing='0' cellpadding='8'><thead>")
                .append("<tr>")
                .append("<th colspan='4'>")
                .append(title)
                .append("</th>")
                .append("<th>")
                .append("Количество:").append(list.size())
                .append("</th>")
                .append("</tr>")
                .append("<tr>")
                .append("<th>Товар</th>")
                .append("<th>Минимальная цена</th>")
                .append("<th>Средняя цена</th>")
                .append("<th>Максимальная цена</th>")
                .append("<th>Количество</th>")
                .append("</thead><tbody>");

        list.forEach((c) -> sb.append(c.toTableRow()));

        sb.append("</tbody></table>");

        return sb.toString();
    }
}
