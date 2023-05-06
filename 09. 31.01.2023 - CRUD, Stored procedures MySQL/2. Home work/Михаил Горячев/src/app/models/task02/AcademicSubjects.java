package app.models.task02;


// Класс Учебный предмет
public record AcademicSubjects(
        int id,
        String name
) {

    // вывод в строку таблицы
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
