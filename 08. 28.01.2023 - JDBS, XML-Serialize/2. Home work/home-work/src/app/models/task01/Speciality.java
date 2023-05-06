package app.models.task01;

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
