package app.models.task02;

import java.util.Date;

public record Query07(
        Date date,
        int minScore,
        double avgScore,
        int maxScore,
        int amount
) {

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
                date,
                amount,
                minScore,
                avgScore,
                maxScore
        );
    }
}
