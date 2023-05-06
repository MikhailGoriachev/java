package app.models.task01;

import java.util.Date;

public record Patient(
        int id,
        String surname,
        String name,
        String patronymic,
        Date bornDate,
        String address,
        String passport) {

    // вывод персоны в строку таблицы
    public String toTableRow() {
        return String.format(
                "<tr>" +
                        "<th>%d</th>" +
                        "<td>%s</td>" +
                        "<td>%s</td>" +
                        "<td>%s</td>" +
                        "<td>%5$td.%5$tm.%5$tY</td>" +
                        "<td>%6$s</td>" +
                        "<td>%7$s</td>" +
                        "</tr>",
                id,
                surname,
                name,
                patronymic,
                bornDate,
                address,
                passport
        );
    }
}
