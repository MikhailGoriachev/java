package app.models.task02;


// Класс Персона
public record Person(
        int id,
        String lastName,
        String firstName,
        String patronymic
) {
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
                lastName,
                firstName,
                patronymic
        );
    }
}
