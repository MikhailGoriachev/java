package app.models.task01;

public record Query05(
        int id,
        String surname,
        String name,
        String patronymic,
        String specialityName,
        int price,
        int percent,
        double salary) {

    // вывод персоны в строку таблицы
    public String toTableRow() {
        return String.format(
                "<tr>" +
                        "<th>%d</th>" +
                        "<td>%s</td>" +
                        "<td>%s</td>" +
                        "<td>%s</td>" +
                        "<td>%s</td>" +
                        "<td align='right'>%d</td>" +
                        "<td align='right'>%d</td>" +
                        "<td align='right'>%.3f</td>" +
                        "</tr>",
                id,
                surname,
                name,
                patronymic,
                specialityName,
                price,
                percent,
                salary
        );
    }
}
