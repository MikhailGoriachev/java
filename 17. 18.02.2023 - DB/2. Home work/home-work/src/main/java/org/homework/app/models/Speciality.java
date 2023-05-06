package org.homework.app.models;

public record Speciality(
        int id,
        String name) {

    // вывод персоны в строку таблицы
    public String toTableRow() {
        return String.format(
                "<tr>" +
                        "<th>%d</th>" +
                        "<td>%s</td>" +
                "</tr>",
                id,
                name
        );
    }
}
