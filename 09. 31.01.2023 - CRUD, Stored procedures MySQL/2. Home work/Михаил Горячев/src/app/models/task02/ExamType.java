package app.models.task02;


// Класс Тип экзамена
public record ExamType(
        int id,
        String academicSubjectName,
        String name
) {
    // вывод персоны в строку таблицы
    public String toTableRow() {
        return String.format(
                "<tr>" +
                        "<th>%d</th>" +
                        "<td>%s</td>" +
                        "<td>%s</td>" +
                        "</tr>",
                id,
                academicSubjectName,
                name
        );
    }
}
