package app.models.task02;


// Класс Экзаменатор
public record Examiner(
        int id,
        String lastName,
        String firstName,
        String patronymic,
        int examFee
) {
    // вывод персоны в строку таблицы
    public String toTableRow() {
        return String.format(
                "<tr>" +
                "<th>%d</th>" +
                "<td>%s</td>" +
                "<td>%s</td>" +
                "<td>%s</td>" +
                "<td align='right'>%d</td>" +
                "</tr>",
                id,
                lastName,
                firstName,
                patronymic,
                examFee
        );
    }

    // вывод персоны в строку таблицы
    public String toTableRowWithTaxAndSalary() {
        return String.format(
                "<tr>" +
                "<th>%d</th>" +
                "<td>%s</td>" +
                "<td>%s</td>" +
                "<td>%s</td>" +
                "<td align='right'>%d</td>" +
                "<td align='right'>%.2f</td>" +
                "<td align='right'>%.2f</td>" +
                "</tr>",
                id,
                lastName,
                firstName,
                patronymic,
                examFee
        );
    }

    // налог (Налог=Размер оплаты*13%)
    public double tax() {
        return examFee * 0.13;
    }

    // зарплата (Зарплата=Размер оплаты - Налог)
    public double salary() {
        return examFee - tax();
    }
}
