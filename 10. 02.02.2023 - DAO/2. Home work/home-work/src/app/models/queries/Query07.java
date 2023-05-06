package app.models.queries;

public record Query07(
        String speciality,
        int amount,
        int minPrice,
        double avgPrice,
        int maxPrice  ) {

    // вывод персоны в строку таблицы
    public String toTableRow() {
        return String.format(
                "<tr>" +
                        "<td>%s</td>" +
                        "<td align='right'>%d</td>" +
                        "<td align='right'>%d</td>" +
                        "<td align='right'>%.3f</td>" +
                        "<td align='right'>%d</td>" +
                "</tr>",
                speciality,
                amount,
                minPrice,
                avgPrice,
                maxPrice
        );
    }
}
