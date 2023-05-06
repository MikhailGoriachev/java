package app.models.task02;


// Класс Студент
public record Student(
        int id,
        String lastName,
        String firstName,
        String patronymic,
        String address,
        int yearOfBirth,
        String passport
) {
    // вывод персоны в строку таблицы
    public String toTableRow() {
        return String.format(
                "<tr>" +
                        "<th>%d</th>" +
                        "<td>%s</td>" +
                        "<td>%s</td>" +
                        "<td>%s</td>" +
                        "<td>%s</td>" +
                        "<td>%d</td>" +
                        "<td>%s</td>" +
                        "</tr>",
                id,
                lastName,
                firstName,
                patronymic,
                address,
                yearOfBirth,
                passport
        );
    }
}
