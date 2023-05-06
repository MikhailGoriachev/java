package app.models.queries;

import java.util.Date;

public record Query06(
        Date appointmentDate,
        int amount,
        int minPercent,
        double avgPercent,
        int maxPercent) {

    // вывод персоны в строку таблицы
    public String toTableRow() {
        return String.format(
                "<tr>" +
                        "<td>%1$td.%1$tm.%1$tY</td>" +
                        "<td align='right'>%2$d</td>" +
                        "<td align='right'>%3$d</td>" +
                        "<td align='right'>%4$.3f</td>" +
                        "<td align='right'>%5$d</td>" +
                        "</tr>",
                appointmentDate,
                amount,
                minPercent,
                avgPercent,
                maxPercent
        );
    }
}
