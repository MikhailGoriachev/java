package app.models.task02;

public record Query06(
        int yearOfBirth,
        int amount
) {
    // вывод в строку таблицы
    public String toTableRow() {
        return String.format(
                "<tr>" +
                "<td align='right'>%d</td>" +
                "<td align='right'>%d</td>" +
                "</tr>",
                yearOfBirth,
                amount
        );
    }
}
