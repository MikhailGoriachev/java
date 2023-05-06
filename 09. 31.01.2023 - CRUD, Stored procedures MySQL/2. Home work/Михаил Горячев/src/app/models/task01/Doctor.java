package app.models.task01;

public record Doctor(
        int id,
        String surname,
        String name,
        String patronymic,
        String specialityName,
        int price,
        int percent) {

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
                "</tr>",
                id,
                surname,
                name,
                patronymic,
                specialityName,
                price,
                percent
        );
    }
}
