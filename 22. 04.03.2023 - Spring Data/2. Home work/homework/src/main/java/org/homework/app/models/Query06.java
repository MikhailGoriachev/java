package org.homework.app.models;

import org.homework.app.middleware.Repositories;

import java.util.List;


public interface Query06 {

    // id
    int getId();

    // персона
    long getPersonId();

    // суммарная цена
    int getSumPrice();

    // минимальная цена
    int getMinPrice();

    // максимальная цена
    int getMaxPrice();

    // количество
    int getCount();


    // вывод с троку таблицы
    default String toTableRow() {
        var person = Repositories
                .getPeopleRepository()
                .findById(getPersonId())
                .orElse(null);

        assert person != null;
        return String.format(
                "<tr><td>%d</td><td>%s %s. %s.</td><td>%d</td><td>%d</td><td>%d</td><td>%d</td></tr>",
                getId(),
                person.getSurname(),
                person.getName().charAt(0),
                person.getPatronymic().charAt(0),
                getSumPrice(),
                getMinPrice(),
                getMaxPrice(),
                getCount()
        );
    }

    // вывод html таблицы
    static String toTableHtml(List<Query06> list, String title) {
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
                .append("<th>Продавец</th>")
                .append("<th>Суммарная стоимость</th>")
                .append("<th>Минимальная цена</th>")
                .append("<th>Максимальная цена</th>")
                .append("<th>Количество продаж</th>")
                .append("</thead><tbody>");

        list.forEach((c) -> sb.append(c.toTableRow()));

        sb.append("</tbody></table>");

        return sb.toString();
    }
}
