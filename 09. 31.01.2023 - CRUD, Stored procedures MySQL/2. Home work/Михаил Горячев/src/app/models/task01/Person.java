package app.models.task01;

public record Person(
        int id,
        String surname,
        String name,
        String patronymic) {

    // вывод персоны в строку таблицы
    public String toTableRow() {
        return String.format(
                "<tr>" +
                        "<th>%d</th>" +
                        "<td>%s</td>" +
                        "<td>%s</td>" +
                        "<td>%s</td>" +
                "</tr>",
                id,
                surname,
                name,
                patronymic
        );
    }
}
